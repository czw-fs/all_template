package com.prcvalve.module.basic.aopToLog;

import com.prcvalve.common.annotation.OperateLog;
import com.prcvalve.module.basic.mapper.OperationLogMapper;
import com.prcvalve.module.basic.model.entity.LogType;
import com.prcvalve.module.basic.model.entity.OperationLog;
import com.prcvalve.module.basic.model.entity.OperationTopic;
import com.prcvalve.module.basic.model.entity.OperationType;
import com.prcvalve.security.SecurityHelper;
import com.prcvalve.utils.IpUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@RequiredArgsConstructor
public class LoggerAspect {

    private final SecurityHelper securityHelper;

    @Pointcut("@annotation(com.prcvalve.common.annotation.OperateLog)")
    public void pointCut() {
    }

    private final HttpServletRequest request;
    private final OperationLogMapper operationLogMapper;

    @After(value = "pointCut()")
    public void afterLogWrite(JoinPoint joinPoint) {
        OperationLog operationLog = getLog(joinPoint);
        operationLogMapper.insert(operationLog);
    }

    private OperationLog getLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OperateLog log = method.getAnnotation(OperateLog.class);

        LogType logType = log.logType();
        OperationTopic operationTopic = log.operationTopic();
        OperationType operationType = log.operationType();
        String content = log.content();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = method.getName();
        String operationMethod = className + "#" + methodName;

        // 获取方法参数名和参数值
        String[] paramNames = signature.getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        Map<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            paramMap.put(paramNames[i], paramValues[i]);
        }
        String operationParams = paramMap.toString();

        LocalDateTime now = LocalDateTime.now();
        Long operatorId = securityHelper.getOperatorId();
        String ipAddress = IpUtil.getIpAddr(request);

        return new OperationLog()
                .setLogType(logType)
                .setOperationTopic(operationTopic)
                .setOperationType(operationType)
                .setOperationContent(content)
                .setOperationMethod(operationMethod)
                .setOperationParams(operationParams)
                .setOperationTime(now)
                .setOperatorId(operatorId)
                .setOperatorRemoteAddress(ipAddress)
                .setDeleted(false)
                ;
    }

}
