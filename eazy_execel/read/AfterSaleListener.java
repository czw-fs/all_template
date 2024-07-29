package com.prcvalve.script.execelToAfterSale;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.prcvalve.module.basic.mapper.BasicSelectionMapper;
import com.prcvalve.module.basic.model.entity.BasicSelection;
import com.prcvalve.module.client.mapper.ClientAfterSaleFormMapper;
import com.prcvalve.module.client.mapper.OfficialClientMapper;
import com.prcvalve.module.client.model.entity.ClientAfterSaleForm;
import com.prcvalve.module.client.model.entity.OfficialClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AfterSaleListener extends AnalysisEventListener<AfterSaleExcelEntity> {


    private final ClientAfterSaleFormMapper clientAfterSaleFormMapper;
    private final OfficialClientMapper officialClientMapper;
    private final BasicSelectionMapper basicSelectionMapper;

    private List<AfterSaleExcelEntity> afterSaleEntityList = new ArrayList<>();

    @Override
    public void invoke(AfterSaleExcelEntity afterSaleExcelEntity, AnalysisContext analysisContext) {
        afterSaleEntityList.add(afterSaleExcelEntity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        transformToAfterSale(afterSaleEntityList);
        afterSaleEntityList.clear();
    }

    private List<AfterSaleExcelEntity> transformToAfterSale(List<AfterSaleExcelEntity> afterSaleEntityList) {
			
    }
}
