package se.nina.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.nina.cruddemo.entity.Villager;

//@RepositoryRestResource(path="residents")
public interface VillagerRepository  extends JpaRepository <Villager, Integer> {
    //no need to write code. get CRUD methods for free.
}
