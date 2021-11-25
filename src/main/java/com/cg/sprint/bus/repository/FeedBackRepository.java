package com.cg.sprint.bus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.bus.model.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer>{

}
