package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.players;

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
@RequestMapping(path = "/api/player")
public class PlayersController {
    
    @Autowired
    private PlayersRepository playersRepository;

    @GetMapping(path = "")
    public Iterable<Players> getAllPlayers() {
        return playersRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Players getPlayers(@PathVariable(value = "id") Integer id) {
        Optional<Players> players = playersRepository.findById(id);
        return players.get();
    }

    @PostMapping(path = "/")
    public Players createPlayers(@RequestBody Players players) {
        return playersRepository.save(players);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updatePlayers(@PathVariable(value = "id") Integer id, @RequestBody Players playersDetails) {
        Optional<Players> optionalPlayers = playersRepository.findById(id);

        Players players = optionalPlayers.get();
        players.setFirstName(playersDetails.getFirstName());
        players.setLastName(playersDetails.getLastName());
        players.setAlignment(playersDetails.getAlignment());
        players.setArmors(playersDetails.getArmors());
        players.setCharacterName(playersDetails.getCharacterName());
        players.setPlayerClass(playersDetails.getPlayerClass());
        players.setRaces(playersDetails.getRaces());
        players.setWeapons(playersDetails.getWeapons());

        playersRepository.save(playersDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deletePlayers(@PathVariable(value = "id") Integer id) {
        playersRepository.deleteById(id);
            return "Deleted";
    }
}
