package com.example.spring_source.demo.validationDemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SonDto {

    @NotBlank(message = "sonName不能为空")
    private String sonName;
}
