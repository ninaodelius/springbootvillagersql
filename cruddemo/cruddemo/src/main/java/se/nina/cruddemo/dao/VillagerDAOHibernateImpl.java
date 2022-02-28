/*package se.nina.cruddemo.dao;

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

    @Override
    public Villager findById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the villager
        Villager theVillager =
                currentSession.get(Villager.class, theId);
        //return the villager

        return theVillager;
    }

    @Override
    public void save(Villager theVillager) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //save employee
        currentSession.saveOrUpdate(theVillager);

    }

    @Override
    public void deleteById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Villager where id=:villagerId"
                );
        theQuery.setParameter("villagerId", theId);

        theQuery.executeUpdate();
    }
}
*/