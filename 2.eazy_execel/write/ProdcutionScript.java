package com.prcvalve.script.allProductToExcel;

import com.alibaba.excel.EasyExcelFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdcutionScript {


    public void allProductToExcel(HttpServletResponse response) {
        List<Object> result = new ArrayList<>();

        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=user_excel_" + System.currentTimeMillis() + ".xlsx");

        try {
            EasyExcelFactory.write(response.getOutputStream(), ExcelProduct.class).sheet("productOrder").doWrite(result);
        } catch (IOException e) {
            // 使用自定义异常进行处理
            throw new RuntimeException("导出Excel失败", e);
        }
    }

}
