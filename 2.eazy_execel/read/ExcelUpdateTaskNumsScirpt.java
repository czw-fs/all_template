package com.prcvalve.script.TaskToExcel;

import com.alibaba.excel.EasyExcel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExcelUpdateTaskNumsScirpt {


    private final ObjectListener objectListener;

    public void ExcelUpdateTaskNumsScirpt(MultipartFile multipartFile)  {

        //本地
//        BufferedInputStream br = null;
//        try {
//            br = new BufferedInputStream(new FileInputStream("C:\\Users\\14128\\Desktop\\无标题.xlsx"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        EasyExcel.read( br, ExcelEntity.class, objectListener).sheet().doRead();

        //服务器
        try {
            EasyExcel.read( multipartFile.getInputStream(), ExcelEntity.class, objectListener).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ok");
    }
}
