package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.alignment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/alignment")
public class AlignmentController {
    
    @Autowired

    private AlignmentRepository alignmentRepository;

    @GetMapping(path = "")
    public Iterable<Alignment>getAllAlignments() {
        return alignmentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Alignment getAlignments(@PathVariable(value = "id") Integer id) {
        Optional<Alignment> alignment = alignmentRepository.findById(id);
        return alignment.get();
    }
}
