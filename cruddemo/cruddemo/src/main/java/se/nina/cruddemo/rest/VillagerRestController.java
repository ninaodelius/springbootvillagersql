package se.nina.cruddemo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.nina.cruddemo.dao.VillagerDAO;
import se.nina.cruddemo.entity.Villager;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VillagerRestController {

    private VillagerDAO villagerDAO;

    //inject villager dao , use constructor injection
    @Autowired
    public VillagerRestController(VillagerDAO theVillagerDAO) {
        villagerDAO = theVillagerDAO;
    }

    // expose "/villagers" and return list of villagers

    @GetMapping("/villagers")
    public List<Villager> findAll() {
        return villagerDAO.findAll();
    }

}
