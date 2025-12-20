package com.example.spring_beauty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/* 
 * 催事情報 Entity 
 */

@Data
@Entity
@Table(name = "beauty")
public class BeautyEntity {
    
    /*
     *  ID 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    /* 
     * メーカー名
     */
    @Column(name = "maker_name")
    private String makerName;
    
    /* 
     * 開催期間
     */
    @Column(name = "period")
    private String period;
    
    /* 
     * エリア
     */
    @Column(name = "area")
    private String area;
    
    /* 
     * 会場名
     */
    @Column(name = "place")
    private String place;
    
}