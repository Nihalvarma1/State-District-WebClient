package com.ust.StateServices.service;

import com.ust.StateServices.dto.DistrictDto;
import com.ust.StateServices.dto.ResponseDto;
import com.ust.StateServices.dto.StateDto;
import com.ust.StateServices.model.State;
import com.ust.StateServices.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepo repo;
    @Autowired
    private WebClient.Builder webClientBuilder;
    @Override
    public State addState(State state) {

        return repo.save(state);
    }
    @Override
    public ResponseDto getState(String statecode){
        ResponseDto responseDto = new ResponseDto();
        State state = repo.findByStatecode(statecode);
        StateDto stateDto = mapToState(state);

        List<DistrictDto> districtDtoList = webClientBuilder.baseUrl("http://localhost:9098")
                .build()
                .get()
                .uri("/district/getdistrictbystatecode/"+state.getStatecode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<DistrictDto>>(){})
                .block();

        return responseDto;

    }
    /*
     @Override
    public FullResponse getState(String scode) {
        FullResponse res=new FullResponse();
        State state=repo.findByScode(scode);

        Statedto statedto=entityToDto(state);

        List<Districtdto> dirstictList=webClientBuilder.baseUrl("http://localhost:9098")
                .build()
                .get()
                .uri("/district/getDistrictsByScode/"+state.getScode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Districtdto>>(){})
                .block();

        res.setStateDto(statedto);
        res.setDistrictDto(dirstictList);
        return res;
    }
     */

    @Override
    public List<State> getAllStates(){
        return repo.findAll();
    }

    private StateDto mapToState(State state) {
        StateDto dto=new StateDto();
        dto.setStatecode(state.getStatecode());
        dto.setStatename(state.getStatename());
        return dto;
    }

//    @Override
//    public ResponseDto getDistrictsByStateCode(String statecode) {
//        return repo.findByStatecode(statecode);
//    }
}

/*
@Override
    public ResponseDto getAirline(String airlinecode) {
        ResponseDto responseDto = new ResponseDto();
        Airline airline = repo.findByAirlinecode(airlinecode).orElseThrow(() -> new RuntimeException("Airline not found"));
        Airlinedto airlineDto = mapToAirline(airline);

        List<Flightdto> flightdtoList = webClient.get()
                .uri("http://localhost:9098/flights/" + airline.getAirlinecode())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Flightdto>>() {}).block();

        responseDto.setAirline(airlineDto);
        responseDto.setFlight(flightdtoList);

        return responseDto;
    }

    private Airlinedto mapToAirline(Airline airline) {
        Airlinedto dto=new Airlinedto();
        dto.setAirlinename(airline.getAirlinename());
        dto.setAirlinecode(airline.getAirlinecode());
        dto.setCountry(airline.getCountry());
        dto.setHeadquarters(airline.getHeadquarters());
        dto.setCeo(airline.getCeo());
        dto.setFoundedYear(airline.getFoundedYear());
        dto.setHubAirport(airline.getHubAirport());
        dto.setWebsite(airline.getWebsite());
        dto.setFleetSize(airline.getFleetSize());
        return dto;
    }
 */