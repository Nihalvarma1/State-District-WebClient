package com.ust.StateServices.repository;

import com.ust.StateServices.dto.ResponseDto;
import com.ust.StateServices.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepo extends JpaRepository<State,String> {
    State findByStatecode(String statecode);
}
