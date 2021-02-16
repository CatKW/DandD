package com.aim.java.FinalProject.playerDB.DungeonsAndDragons.weapons;

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
@RequestMapping(path = "/api/weapons")
public class WeaponsController {
    
    @Autowired

    private WeaponsRepository weaponsRepository;

    @GetMapping(path = "")
    public Iterable<Weapons>getAllWeapons() {
        return weaponsRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Weapons getWeapons(@PathVariable(value = "id") Integer id) {
        Optional<Weapons> weapons = weaponsRepository.findById(id);
        return weapons.get();
    }

    @PostMapping(path = "/")
    public Weapons createWeapons(@RequestBody Weapons weapons) {
        return weaponsRepository.save(weapons);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateWeapons(@PathVariable(value = "id") Integer id, @RequestBody Weapons weaponsDetails) {
        Optional<Weapons> optionalWeapons = weaponsRepository.findById(id);
        Weapons weapons = optionalWeapons.get();

        weapons.setWeaponsDamage(weaponsDetails.getWeaponsDamage());
        weapons.setWeaponsName(weaponsDetails.getWeaponsName());
        weapons.setWeaponsType(weaponsDetails.getWeaponsType());
        weapons.setWeaponsWeight(weaponsDetails.getWeaponsWeight());

        weaponsRepository.save(weaponsDetails);
        return "Updated";       
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteWeapons(@PathVariable(value = "id") Integer id) {
        weaponsRepository.deleteById(id);
        return "Deleted";
    }
}
