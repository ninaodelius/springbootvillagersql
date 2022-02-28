package se.nina.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.nina.cruddemo.entity.Villager;

public interface VillagerRepository  extends JpaRepository <Villager, Integer> {
    //no need to write code. get CRUD methods for free.
}
