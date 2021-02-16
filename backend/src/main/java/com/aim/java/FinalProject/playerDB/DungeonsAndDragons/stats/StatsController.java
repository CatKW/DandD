package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.stats;

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
@RequestMapping(path = "/api/stats")
public class StatsController {
    
    @Autowired

    private StatsRepository statsRepository;

    @GetMapping(path = "")
    public Iterable<Stats>getAllStats() {
        return statsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Stats getStats(@PathVariable(value = "id") Integer id) {
        Optional<Stats> stats = statsRepository.findById(id);
        return stats.get();
    }

    @PostMapping(path = "/")
    public Stats createStats(@RequestBody Stats stats) {
        return statsRepository.save(stats);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateStats(@PathVariable(value = "id") Integer id, @RequestBody Stats statsDetails) {
        Optional<Stats> optionalStats = statsRepository.findById(id);
        Stats stats = optionalStats.get();

        stats.setCharisma(statsDetails.getCharisma());
        stats.setConstitution(statsDetails.getConstitution());
        stats.setDexterity(statsDetails.getDexterity());
        stats.setStrength(statsDetails.getStrength());
        stats.setWisdom(statsDetails.getWisdom());
        
        statsRepository.save(statsDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteStats(@PathVariable(value = "id") Integer id) {
        statsRepository.deleteById(id);
            return "Deleted";

    }
}
