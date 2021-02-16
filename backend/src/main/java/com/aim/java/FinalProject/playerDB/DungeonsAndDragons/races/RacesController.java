package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.races;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/races")
public class RacesController {
    
    @Autowired

    private RacesRepository racesRepository;

    @GetMapping(path = "")
    public Iterable<Races>getAllRaces(){
        return racesRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Races getRaces(@PathVariable(value = "id") Integer id) {
        Optional<Races> races = racesRepository.findById(id);
        return races.get();
    }

    @PostMapping(path = "/")
    public Races createRaces(@RequestBody Races races) {
        return racesRepository.save(races);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateRaces(@PathVariable(value = "id") Integer id, @RequestBody Races racesDetails) {
        Optional<Races> optionalRaces = racesRepository.findById(id);
        Races races = optionalRaces.get();

        races.setRaceDescription(racesDetails.getRaceDescription());
        races.setRaceDetailUrl(racesDetails.getRaceDetailUrl());
        races.setRaceName(racesDetails.getRaceName());

        racesRepository.save(races);
        return "Updated";

    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteRaces(@PathVariable(value = "id") Integer id) {
        racesRepository.deleteById(id);
        return "Deleted";
    }
}
