package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.alignment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/alignment")
public class AlignController {
    
    @Autowired

    private AlignRepository alignRepository;

    @GetMapping(path = "")
    public Iterable<Align>getAllAligns() {
        return alignRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Align getAligns(@PathVariable(value = "id") Integer id) {
        Optional<Align> align = alignRepository.findById(id);
        return align.get();
    }
}
