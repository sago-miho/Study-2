package com.example.spring_beauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_beauty.dto.BeautyRequest;
import com.example.spring_beauty.dto.BeautyUpdateRequest;
import com.example.spring_beauty.entity.BeautyEntity;
import com.example.spring_beauty.repository.BeautyRepository;
/* 
 * 店舗情報 Service
 */
@Service
public class BeautyService {
    
    /* 
     * 催事情報 Repository
     */
    
    @Autowired
    private BeautyRepository beautyRepository;
    
    /*
     * 催事情報 全検索
     * @return 検索結果
     */
    public List<BeautyEntity> searchAll() {
        
        return beautyRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }
    
    /*
     * 催事情報詳細検索
     * @param id 検索する催事ID
     * @return 美容事業エンティティ
     */
    public BeautyEntity findById(Integer id) {
        return beautyRepository.findById(id).orElse(null);
    }
    
    /**
     * 催事情報 新規登録
     * @param  beauty 店舗情報
     */
    public void create(BeautyRequest beautyRequest) {
      BeautyEntity beauty = new BeautyEntity();
      
      beauty.setMakerName(beautyRequest.getMakerName());
      beauty.setPeriod(beautyRequest.getPeriod());
      beauty.setArea(beautyRequest.getArea());
      beauty.setPlace(beautyRequest.getPlace());
      
      beautyRepository.save(beauty);
    }
    
    /*
     *　登録情報更新
     *@param beauty 登録情報
     */
    @Transactional
    public void update(BeautyUpdateRequest beautyUpdateRequest) {
    BeautyEntity beauty = findById(beautyUpdateRequest.getId());
    
    beauty.setMakerName(beautyUpdateRequest.getMakerName());
    beauty.setPeriod(beautyUpdateRequest.getPeriod());
    beauty.setArea(beautyUpdateRequest.getArea());
    beauty.setPlace(beautyUpdateRequest.getPlace());
  
    beautyRepository.save(beauty);
  }
    
    /**
     * 登録情報 物理削除
     * @param id 店舗ID
     */
    public void delete(Integer id) {
        BeautyEntity beauty = findById(id);
        beautyRepository.delete(beauty);
    }
    
}