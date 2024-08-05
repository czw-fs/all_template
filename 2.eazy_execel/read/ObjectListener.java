package com.prcvalve.script.TaskToExcel;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.prcvalve.module.project.mapper.WorkTaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ObjectListener extends AnalysisEventListener<ExcelEntity> {

    private final WorkTaskMapper workTaskMapper;

    private List<ExcelEntity> entityList = new ArrayList<>();

    @Override
    public void invoke(ExcelEntity excelEntity, AnalysisContext analysisContext) {
        entityList.add(excelEntity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //读取到所有的集合
        doSomeThing();
        //清空集合
        entityList.clear();
    }

    private void doSomeThing() {

    }
}
