package com.example.spring_client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/* 
 * 店舗情報 Entity 
 */

@Data
@Entity
@Table(name = "client")
public class ClientEntity {
    
    /*
     *  ID 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer id;
    
    /* 
     * 店舗名
     */
    @Column(name = "store_name")
    private String storeName;
    
    /* 
     * 稼働形態 
     */
    @Column(name = "work_style")
    private String workStyle;
    
    /* 
     * 店舗住所
     */
    @Column(name = "store_address")
    private String storeAddress;
    
    /* 
     * 店舗電話番号
     */
    @Column(name = "tell_number")
    private String tellNumber;

	
	
    
}