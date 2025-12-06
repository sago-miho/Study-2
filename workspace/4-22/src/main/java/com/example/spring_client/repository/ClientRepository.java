package com.example.spring_client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_client.entity.ClientEntity;

/* 
 * 店舗情報 Repository
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{
}
