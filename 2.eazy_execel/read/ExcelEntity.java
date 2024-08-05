package com.prcvalve.script.TaskToExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelEntity {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("实际工作量")
    private Long taskNum;
}
