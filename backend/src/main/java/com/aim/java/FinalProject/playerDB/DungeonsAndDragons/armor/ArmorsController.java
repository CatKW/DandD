package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.armor;

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
@RequestMapping(path = "/api/armor")
public class ArmorsController {
    
    @Autowired

    private ArmorsRepository armorsRepository;

    @GetMapping(path = "")
    public Iterable<Armors>getAllArmors() {
        return armorsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Armors getArmors(@PathVariable(value = "id") Integer id) {
        Optional<Armors> armors = armorsRepository.findById(id);
        return armors.get();
    }

    @PostMapping(path = "/")
    public Armors createArmors(@RequestBody Armors armors) {
        return armorsRepository.save(armors);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateArmors(@PathVariable(value = "id") Integer id, @RequestBody Armors armorsDetails) {
        Optional<Armors> optionalArmors = armorsRepository.findById(id);
        Armors armors = optionalArmors.get();
        armors.setArmorClasses(armorsDetails.getArmorClasses());
        armors.setAcModifiers(armorsDetails.getAcModifiers());
        armors.setArmorNames(armorsDetails.getArmorNames());
        armors.setArmorTypes(armorsDetails.getArmorTypes());
        armors.setArmorWeights(armorsDetails.getArmorWeights());

        armorsRepository.save(armorsDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteArmors (@PathVariable(value = "id") Integer id) {
        armorsRepository.deleteById(id);
        return "Deleted";
    }
}
