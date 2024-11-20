package com.hexaware.hotpot.repository;

import com.hexaware.hotpot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<User, Long> {
    
}
