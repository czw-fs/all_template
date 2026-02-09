package com.example.activitytest.Demo;

import lombok.RequiredArgsConstructor;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ActivityDemoController {

    private final RepositoryService repositoryService;
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    /**
     * 部署流程
     */
    @PostMapping("/deploy")
    public void testDeploy(@RequestParam("bpmnFile")MultipartFile bpmnFile,String bpmnName) {
        try {
            repositoryService
                    .createDeployment()
                    .name(bpmnName)
                    .addInputStream(bpmnFile.getOriginalFilename(), bpmnFile.getInputStream())
                    .deploy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 开启流程
     */
    @GetMapping("/startProcess")
    public void startProcess(String processKey) {

        /**
         * 可以设置流程发起人,也可以不设置
         */
        Authentication.setAuthenticatedUserId("流程发起人1");
        //流程业务key，可以理解为本次启动流程实例的名字
        String businessKey = processKey + DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS").format(LocalDateTime.now());
        // 设置「全局字段」（流程变量）
        HashMap<String, Object> globalValue = new HashMap<>();
        globalValue.put("HrCode", "123456");
        /**
         * 1. 根据 KEY_ 找到最新版本的 ProcessDefinition
         * 2. 创建 ProcessInstance
         * 3. 创建 root Execution
         * 4. 按 BPMN 顺序推进
         * 5. 碰到 endEvent → 流程结束
         */
        runtimeService.startProcessInstanceByKey(processKey,businessKey,globalValue);

        //当然也可以自定义启动版本,但是要指定流程定义id
        //runtimeService.startProcessInstanceById("processDefinitionId");
    }

    /**
     * 查询下一个任务id
     */
    @GetMapping("/getLastTaskId")
    public String getLastTaskId(String processKey, String processInstanceId) {
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(processKey)
                .processInstanceId(processInstanceId)
                .singleResult();
        return task.getId();
    }

    /**
     * 完成任务
     */
    @GetMapping("/completeTask")
    public void completeTask(String taskId) {
        /**
         * 任务结束前可以设置流程作用域变量
         */
        Map<String, Object> exeMap = new HashMap<>();
        exeMap.put("我是流程作用域变量", "程作用域变量值");
        taskService.setVariables(taskId, exeMap);
        /**
         * 任务结束前可以设置当前任务作用域变量
         * 一般只用于“本任务结束瞬间”的流程决策
         */
        Map<String, Object> curTaskMap = new HashMap<>();
        curTaskMap.put("我是hr任务作用域变量","hr任务变量值");
        taskService.setVariablesLocal(taskId, curTaskMap);
        taskService.complete(taskId);
    }
}
