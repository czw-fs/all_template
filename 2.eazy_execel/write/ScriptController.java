package com.prcvalve.script;

import com.prcvalve.common.model.transport.ResponseResult;
import com.prcvalve.script.SupportOrderScriptPackage.SupportOrderScript;
import com.prcvalve.script.allProductToExcel.ProdcutionScript;
import com.prcvalve.script.excelToProductAndProjectAndTask.TransExcelToProductScript;
import com.prcvalve.script.execelToAfterSale.AfterSaleScript;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ScriptController {

private final ProdcutionScript prodcutionScript

    @RequestMapping("/allProductToExcel")
    public void allProductToExcel(HttpServletResponse response){
        prodcutionScript.allProductToExcel(response);
    }

}
