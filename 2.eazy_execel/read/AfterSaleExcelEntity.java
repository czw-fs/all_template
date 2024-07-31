package com.prcvalve.script.execelToAfterSale;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class AfterSaleExcelEntity {

    //客户全称	客户简称	业务类型		服务开始时间	服务到期时间	商务负责人
    @ExcelProperty("客户全称")
    private String clientFullName;

    @ExcelProperty("客户简称")
    private String clientName;

    @ExcelProperty("业务类型")
    private String businessType;

    @ExcelProperty("服务开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    @ExcelProperty("服务到期时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;

    @ExcelProperty("商务负责人")
    private String businessHeadName;

}
