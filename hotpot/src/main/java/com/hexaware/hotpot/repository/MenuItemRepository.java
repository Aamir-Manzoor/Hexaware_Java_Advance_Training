package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.models.MenuItem;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    
}
