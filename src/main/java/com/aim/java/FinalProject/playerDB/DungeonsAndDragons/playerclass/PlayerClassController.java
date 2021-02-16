package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.playerclass;

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
@RequestMapping(path = "/api/playerclass")
public class PlayerClassController {

    @Autowired

    private PlayerClassRepository playerClassRepository;

    @GetMapping(path = "")
    public Iterable<PlayerClass>getAllPlayerClasses() {
        return playerClassRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public PlayerClass getPlayerClass(@PathVariable(value = "id") Integer id) {
        Optional<PlayerClass> playerClass = playerClassRepository.findById(id);
        return playerClass.get();
    }

    @PostMapping(path = "/")
    public PlayerClass createPlayerClasses(@RequestBody PlayerClass playerClass) {
        return playerClassRepository.save(playerClass);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updatePlayerClasses(@PathVariable(value = "id") Integer id, @RequestBody PlayerClass playerClassDetails) {
        Optional<PlayerClass> optionalPlayerClass = playerClassRepository.findById(id);
        PlayerClass playerClass = optionalPlayerClass.get();

        playerClass.setPlayerclassDesc(playerClassDetails.getPlayerclassDesc());
        playerClass.setPlayerclassName(playerClassDetails.getPlayerclassName());
        playerClass.setPlayerclassUrl(playerClassDetails.getPlayerclassUrl());

        playerClassRepository.save(playerClassDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deletePlayerClass(@PathVariable(value = "id") Integer id) {
        playerClassRepository.deleteById(id);
            return "Deleted";
        
    }
    
}
