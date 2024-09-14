package com.ust.DistrictServices.controller;

import com.ust.DistrictServices.model.District;
import com.ust.DistrictServices.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping("/adddistrict")
    public District addDistrict(@RequestBody District district){
        return districtService.addDistrict(district);
    }

    @PostMapping("/addalldistrict")
    public List<District> addAllDistrict(@RequestBody List<District> districts){
        return districtService.addAllDistrict(districts);
    }


    @GetMapping("/getdistrictbystatecode/{statecode}")
    public List<District> getDistrictsByStateCode(@PathVariable String statecode){
        return districtService.getDistrictsByStateCode(statecode);
    }

    @GetMapping("/getalldistrict")
    public List<District> getAllDistricts(){
        return districtService.getAllDistricts();
    }
}
