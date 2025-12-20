package com.example.spring_beauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_beauty.entity.BeautyEntity;

/* 
 * 催事情報 Repository
 */
@Repository
public interface BeautyRepository extends JpaRepository<BeautyEntity, Integer>{
}
