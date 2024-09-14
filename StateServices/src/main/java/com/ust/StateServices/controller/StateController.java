package com.ust.StateServices.controller;

import com.ust.StateServices.dto.ResponseDto;
import com.ust.StateServices.model.State;
import com.ust.StateServices.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @PostMapping("/addstate")
    public ResponseEntity<State> addState(@RequestBody State state) {
        return ResponseEntity.ok(stateService.addState(state));
    }
    @GetMapping("/getallstates")
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(stateService.getAllStates());
    }

    @GetMapping("/getstate/{statecode}")
    public ResponseEntity<ResponseDto> getState(@PathVariable String statecode) {
        ResponseDto res = stateService.getState(statecode);
        return ResponseEntity.ok(res);
    }
}
