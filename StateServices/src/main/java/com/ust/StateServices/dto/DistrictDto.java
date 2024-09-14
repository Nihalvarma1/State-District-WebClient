package com.ust.StateServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {
    private Long dcode;
    private String dname;
    private String statecode;
    private String population;
    private String area;
}
