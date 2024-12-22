package com.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotpot.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
