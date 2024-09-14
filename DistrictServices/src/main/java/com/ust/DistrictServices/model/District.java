package com.ust.DistrictServices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="district")
public class District {
    @Id
    private Long dcode;
    private String dname;
    private String statecode;
    private String population;
    private String area;
}
