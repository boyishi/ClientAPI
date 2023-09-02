package com.boyishi.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.boyishi.demo.entities.Client;

@Service
public interface ClientRepository extends JpaRepository<Client, Long> {

}
