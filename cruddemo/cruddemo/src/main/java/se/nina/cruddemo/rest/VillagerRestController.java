package se.nina.cruddemo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.nina.cruddemo.entity.Villager;
import se.nina.cruddemo.service.VillagerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VillagerRestController {

    private VillagerService villagerService;

    //inject villager dao , use constructor injection
    @Autowired
    public VillagerRestController(VillagerService theVillagerService) {
        villagerService = theVillagerService;
    }

    // expose "/villagers" and return list of villagers

    @GetMapping("/villagers")
    public List<Villager> findAll() {
        return villagerService.findAll();
    }

    //add mapping for GET /villager/{villagerid}
    @GetMapping("/villagers/{villagerId}")
    public Villager getVillager(@PathVariable int villagerId) {

        Villager theVillager = villagerService.findById(villagerId);

        if (theVillager == null) {
            throw new RuntimeException("Villager id not found" + villagerId);

        }
        return theVillager;
    }

    //add mapping for post /villagers - add new villager

    @PostMapping("/villagers")
    public Villager addVillager(@RequestBody Villager theVillager) {

        theVillager.setId(0);
        villagerService.save(theVillager);

        return  theVillager;
    }

    // add mapping for put /villagers - update existing villager

    @PutMapping("/villagers")
    public Villager updateVillager(@RequestBody Villager theVillager) {

        villagerService.save(theVillager);

        return theVillager;
    }

    //add mapping for delete /villagers/{villagerId} - delete villager

    @DeleteMapping("/villagers/{villagerId}")
    public String deleteVillager(@PathVariable int villagerId) {
        Villager tempVillager = villagerService.findById(villagerId);

        //throw exception if null

        if (tempVillager == null) {
            throw new RuntimeException("Villager Id not found - " + villagerId);
        }
        villagerService.deleteById(villagerId);

        return "Deleted villager Id - " + villagerId;
    }
}

