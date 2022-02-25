package se.nina.cruddemo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.nina.cruddemo.entity.Villager;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VillagerDAOHibernateImpl implements VillagerDAO{


    //define field for entitymanager

    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public VillagerDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Villager> findAll() {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a quesry
        Query<Villager> theQuery =
                currentSession.createQuery("from Villager", Villager.class);


        //execute query and get result list
    List<Villager> villagers = theQuery.getResultList();


        //return the results

        return villagers;
    }
}
