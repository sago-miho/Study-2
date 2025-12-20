package com.example.spring_beauty.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_beauty.dto.BeautyRequest;
import com.example.spring_beauty.dto.BeautyUpdateRequest;
import com.example.spring_beauty.entity.BeautyEntity;
import com.example.spring_beauty.service.BeautyService;

/*
 *  美容事業スケジュール Controller 
*/
@Controller
public class BeautyController {

    /*
     * 店舗情報 Service
     */

//使用クラスのインスタンス化   
    @Autowired
    BeautyService BeautyService;

    /*
     * 美容事業催事スケジュール画面を表示
     * @param model Model
     * @Return 美容事業催事スケジュール画面のHTML
     */
    @GetMapping("/beauty/list")
    public String beautyList(Model model) {
        // クライアントテーブルのデータをすべて取得するメゾットを呼び出す。
       List<BeautyEntity> beautylist = BeautyService.searchAll();
        // 取得したクライアントデータの情報を画面側で利用できるようにmodelへ格納する。
        model.addAttribute("beautylist", beautylist);
        return "/beauty/list";
    }

    /*
     * 追加登録画面を表示
     * @param model Model
     * @return美容事業催事スケジュール 画面
     */

    @GetMapping("/beauty/add")
    public String beautyAdd(Model model) {
        model.addAttribute("beautyRequest", new BeautyRequest());
        return "beauty/add";}
    

    /**
     * 催事情報新規登録
     * @param beautyRequest リクエストデータ
     * @param model Model
     * @return 店舗情報一覧画面
     */
    @PostMapping("/beauty/create")
    public String create(@Validated @ModelAttribute BeautyRequest beautyRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {

        // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
            errorList.add(error.getDefaultMessage());
            
            model.addAttribute("beautyRequest",beautyRequest);
            
            //エラー判定後の画面遷移
              model.addAttribute("validationError", errorList);
              
              return "beauty/add";}
          }
          
      
      // 追加情報の登録
      BeautyService.create(beautyRequest);
      return "redirect:/beauty/list";
    }
      
    
    /**
     * 詳細画面を表示
     * @param id 表示する催事ID
     * @param model Model
     * @return スケジュール詳細画面
     */
    @GetMapping("/beauty/{id}")
    public String beautyData(@PathVariable Integer id, Model model) {
      BeautyEntity beauty = BeautyService.findById(id);
      model.addAttribute("beautyData", beauty);
      return "beauty/view";
    }
   
    /**
     * 編集画面を表示
     * @param id 表示する催事ID
     * @param model Model
     * @return 編集画面
     */
    @GetMapping("/beauty/{id}/edit")
    public String beautyEdit(@PathVariable Integer id, Model model) {
    	
    	/**
    	 * 編集対象の催事情報を取得
    	 */
    	 BeautyEntity beauty = BeautyService.findById(id);
    	 
    	// 編集画面用のDTOに格納
    	    BeautyUpdateRequest beautyUpdateRequest = new BeautyUpdateRequest();
    	    beautyUpdateRequest.setId(beauty.getId());
    	    beautyUpdateRequest.setMakerName(beauty.getMakerName());
    	    beautyUpdateRequest.setPeriod(beauty.getPeriod());
    	    beautyUpdateRequest.setArea(beauty.getArea());
    	    beautyUpdateRequest.setPlace(beauty.getPlace());
    	    model.addAttribute("beautyUpdateRequest", beautyUpdateRequest);
    	    return "beauty/edit";
    	  }
    	    
    /**
     * 登録情報更新
     * @param beautyRequest リクエストデータ
     * @param model Model
     * @return 登録情報詳細画面
     */
    @RequestMapping("/beauty/update")
    public String beautyUpdate(@Validated @ModelAttribute BeautyUpdateRequest beautyUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	
        	List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
              
              model.addAttribute("validationError", errorList);
              return "beauyt/edit";
            } 
          }
        
     // 催事情報の更新
        BeautyService.update(beautyUpdateRequest);
        return String.format("redirect:/beauty/%d", beautyUpdateRequest.getId());
        
      }
    
    /**
     * 登録情報削除
     * @param id 表示する催事ID
     * @param model Model
     * @return 催事情報詳細画面
     */
    @GetMapping("/beauty/{id}/delete")
    
    public String beautyDelete(@PathVariable Integer id, Model model) {
    	
    	// 登録情報の削除
        BeautyService.delete(id);
        return "redirect:/beauty/list";
    }
    }
    