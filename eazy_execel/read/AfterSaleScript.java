package com.prcvalve.script.execelToAfterSale;


import com.alibaba.excel.EasyExcel;
import com.prcvalve.common.model.transport.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class AfterSaleScript {

    private final AfterSaleListener afterSaleListener;

    public ResponseResult transExcelToProductAndProject(MultipartFile multipartFile) {

        String fileName = multipartFile.getOriginalFilename();  //获取文件名

        String fileXlsx = fileName.substring(fileName.length()-5);       //获取文件的后缀名为xlsx
        String fileXls = fileName.substring(fileName.length()-4);

        if(!(fileXlsx.equals(".xlsx") || fileXls.equals(".xls"))){   //如果不是excel文件
            return ResponseResult.errorResult(400,"文件格式错误");
        }

        // 方法一：
        InputStream is = null;
        try {
            is = multipartFile.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        EasyExcel.read(is, AfterSaleExcelEntity.class, afterSaleListener).sheet().doRead();
        return ResponseResult.okResult("转换成功");

    }
}
