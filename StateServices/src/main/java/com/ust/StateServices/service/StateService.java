package com.ust.StateServices.service;

import com.ust.StateServices.dto.ResponseDto;
import com.ust.StateServices.model.State;

import java.util.List;

public interface StateService {
    State addState(State state);
    ResponseDto getState(String statecode);
//    ResponseDto getDistrict(String statecode);
    List<State> getAllStates();
}

