package com.ust.DistrictServices.service;

import com.ust.DistrictServices.model.District;
import com.ust.DistrictServices.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepo repo;
    public District addDistrict(District district) {
        return repo.save(district);
    }

    public List<District> getDistrictsByStateCode(String statecode) {
        return repo.findByStatecode(statecode);
    }

    public List<District> getAllDistricts() {
        return repo.findAll();
    }

    public List<District> addAllDistrict(List<District> districts) {
        return repo.saveAll(districts);
    }
}
