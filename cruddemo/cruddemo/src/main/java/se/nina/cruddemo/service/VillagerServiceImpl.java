package se.nina.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.nina.cruddemo.dao.VillagerRepository;
import se.nina.cruddemo.entity.Villager;

import java.util.List;
import java.util.Optional;

@Service
public class VillagerServiceImpl implements VillagerService{

    private VillagerRepository villagerRepository;

    @Autowired
    public VillagerServiceImpl(VillagerRepository theVillagerRepository) {
        villagerRepository = theVillagerRepository;
    }


    @Override
    public List<Villager> findAll() {
        return villagerRepository.findAll();
    }

    @Override
    public Villager findById(int theId) {
        Optional<Villager> result = villagerRepository.findById(theId);

        Villager theVillager = null;

        if (result.isPresent()) {
            theVillager = result.get();
        }
        else {
            //if we didn't find the villager
            throw new RuntimeException("Did not find villager id - " + theId);
        }

        return theVillager;
    }

    @Override
    public void save(Villager theVillager) {
        villagerRepository.save(theVillager);
    }

    @Override
    public void deleteById(int theId) {
        villagerRepository.deleteById(theId);
    }
}
