package com.example.spring_client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_client.dto.ClientRequest;
import com.example.spring_client.dto.ClientUpdateRequest;
import com.example.spring_client.entity.ClientEntity;
import com.example.spring_client.repository.ClientRepository;

/* 
 * 店舗情報 Service
 */
@Service
public class ClientService {
    
    /* 
     * 店舗情報 Repository
     */
    
    @Autowired
    private ClientRepository clientRepository;
    
    /*
     * 店舗情報 全検索
     * @return 検索結果
     */
    public List<ClientEntity> searchAll() {
        
        return clientRepository.findAll();
    }
    
    /*
     * 店舗情報詳細検索
     * @param id 検索する店舗ID
     * @return クライアントエンティティ
     */
    public ClientEntity findById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }
    
    /**
     * 店舗情報 新規登録
     * @param  client 店舗情報
     */
    public void create(ClientRequest clientRequest) {
      ClientEntity client = new ClientEntity();
      
      client.setStoreName(clientRequest.getStoreName());
      client.setWorkStyle(clientRequest.getWorkStyle());
      client.setStoreAddress(clientRequest.getStoreAddress());
      client.setTellNumber(clientRequest.getTellNumber());
      
      clientRepository.save(client);
    }
    
    /*
     *　登録情報更新
     *@param client 登録情報
     */
    @Transactional
    public void update(ClientUpdateRequest clientUpdateRequest) {
    ClientEntity client = findById(clientUpdateRequest.getId());
    
    client.setStoreName(clientUpdateRequest.getStoreName());
    client.setWorkStyle(clientUpdateRequest.getWorkStyle());
    client.setStoreAddress(clientUpdateRequest.getStoreAddress());
    client.setTellNumber(clientUpdateRequest.getTellNumber());
  
    clientRepository.save(client);
  }
    
    /**
     * 登録情報 物理削除
     * @param id 店舗ID
     */
    public void delete(Integer id) {
        ClientEntity client = findById(id);
        clientRepository.delete(client);
    }
    
}
    


  

