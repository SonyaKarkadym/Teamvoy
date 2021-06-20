package com.example.demo.dao;

import com.example.demo.models.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ClientOrderDao extends JpaRepository<ClientOrder,Integer> {
}
