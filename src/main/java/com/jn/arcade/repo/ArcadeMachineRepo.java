package com.jn.arcade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jn.arcade.entity.ArcadeMachine;

@Repository
public interface ArcadeMachineRepo extends JpaRepository<ArcadeMachine, Long>{

}