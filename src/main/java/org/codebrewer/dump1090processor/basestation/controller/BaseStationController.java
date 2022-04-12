package org.codebrewer.dump1090processor.basestation.controller;

import java.util.ArrayList;
import java.util.List;

import org.codebrewer.dump1090processor.basestation.entity.Aircraft;
import org.codebrewer.dump1090processor.basestation.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aircraft")
public class BaseStationController {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public BaseStationController(AircraftRepository aircraftRepository) {
        super();
        this.aircraftRepository = aircraftRepository;
    }

    @GetMapping("/all")
    List<Aircraft> getAllAircraft() {
        List<Aircraft> result = new ArrayList<>();

        aircraftRepository.findAll().forEach(result::add);

        return result;
    }

}
