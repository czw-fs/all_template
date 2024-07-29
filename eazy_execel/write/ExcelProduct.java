package com.prcvalve.script.allProductToExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ExcelProduct {

    @ExcelProperty("客户名称")
    private String clientName;

    @ExcelProperty("订单名称")
    private String orderName;


    @ExcelProperty("更进记录")
    private String followRecordContent;

    @ExcelProperty("签订合同")
    private String signed;

    @ExcelProperty("付款方式")
    private String paymentName;


    @ExcelProperty("业务类型")
    private String businessTypeName;

    @ExcelProperty("状态")
    private String status;


}
