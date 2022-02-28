package se.nina.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.nina.cruddemo.entity.Villager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VillagerDAOJpaImpl  implements VillagerDAO{

    private EntityManager entityManager;

    @Autowired
    public VillagerDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Villager> findAll() {
        //create a query
        Query theQuery =
                entityManager.createQuery("from Villager");

        //execute query and get result list
        List<Villager> villagers = theQuery.getResultList();

        //return the results
        return villagers;
    }

    @Override
    public Villager findById(int theId) {
        //get villager
        Villager theVillager =
                entityManager.find(Villager.class, theId);
        //return villager

        return theVillager;
    }

    @Override
    public void save(Villager theVillager) {
        //save or update villager
        Villager dbVillager = entityManager.merge(theVillager);

        //update with id from db so we can get generated id for save/insert
        theVillager.setId(dbVillager.getId());

    }

    @Override
    public void deleteById(int theId) {

        //delete object with primary key
        Query theQuery = entityManager.createQuery(
                "delete from Villager where id=:villagerId");
        theQuery.setParameter("villagerId", theId);

        theQuery.executeUpdate();

    }
}
