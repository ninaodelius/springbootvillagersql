package se.nina.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.nina.cruddemo.dao.VillagerDAO;
import se.nina.cruddemo.entity.Villager;

import java.util.List;

@Service
public class VillagerServiceImpl implements VillagerService{
    private VillagerDAO villagerDAO;

    @Autowired
    public VillagerServiceImpl(@Qualifier("villagerDAOJpaImpl") VillagerDAO theVillagerDAO) {
        villagerDAO = theVillagerDAO;
    }


    @Override
    @Transactional
    public List<Villager> findAll() {
        return villagerDAO.findAll();
    }

    @Override
    @Transactional
    public Villager findById(int theId) {
        return villagerDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Villager theVillager) {
        villagerDAO.save(theVillager);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        villagerDAO.deleteById(theId);
    }
}
