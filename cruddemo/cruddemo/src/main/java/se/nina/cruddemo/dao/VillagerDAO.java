package se.nina.cruddemo.dao;

import se.nina.cruddemo.entity.Villager;

import java.util.List;

public interface VillagerDAO {

    public List<Villager> findAll();

    public Villager findById(int theId);

    public void save(Villager theVillager);

    public void deleteById(int theId);



}
