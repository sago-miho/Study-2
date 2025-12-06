package com.example.spring_client.controller;

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

import com.example.spring_client.dto.ClientRequest;
import com.example.spring_client.dto.ClientUpdateRequest;
import com.example.spring_client.entity.ClientEntity;
import com.example.spring_client.service.ClientService;

/*
 *  店舗情報 Controller 
*/
@Controller
public class ClientController {

    /*
     * 店舗情報 Service
     */

//使用クラスのインスタンス化   
    @Autowired
    ClientService clientService;

    /*
     * 店舗情報一覧画面を表示
     * @param model Model
     * @Return 店舗情報一覧画面のHTML
     */
    @GetMapping("/client/list")
    public String clientList(Model model) {
        // クライアントテーブルのデータをすべて取得するメゾットを呼び出す。
       List<ClientEntity> clientlist = clientService.searchAll();
        // 取得したクライアントデータの情報を画面側で利用できるようにmodelへ格納する。
        model.addAttribute("clientlist", clientlist);
        return "/client/list";
    }

    /*
     * 追加登録画面を表示
     * @param model Model
     * @return 店舗情報一覧画面
     */

    @GetMapping("/client/add")
    public String clientAdd(Model model) {
        model.addAttribute("clientRequest", new ClientRequest());
        return "client/add";}
    

    /**
     * 店舗情報新規登録
     * @param clientRequest リクエストデータ
     * @param model Model
     * @return 店舗情報一覧画面
     */
    @PostMapping("/client/create")
    public String create(@Validated @ModelAttribute ClientRequest clientRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {

        // 入力チェックエラーの場合
          List<String> errorList = new ArrayList<String>();
          for (ObjectError error : result.getAllErrors()) {
            errorList.add(error.getDefaultMessage());
            
            model.addAttribute("clientRequest",clientRequest);
            
            //エラー判定後の画面遷移
              model.addAttribute("validationError", errorList);
              
              return "client/add";}
          }
          
      
      // 追加情報の登録
      clientService.create(clientRequest);
      return "redirect:/client/list";
    }
      
    
    /**
     * 店舗情報詳細画面を表示
     * @param id 表示する店舗ID
     * @param model Model
     * @return ユーザー情報詳細画面
     */
    @GetMapping("/client/{id}")
    public String clientData(@PathVariable Integer id, Model model) {
      ClientEntity client = clientService.findById(id);
      model.addAttribute("clientData", client);
      return "client/view";
    }
   
    /**
     * 店舗情報編集画面を表示
     * @param id 表示する店舗ID
     * @param model Model
     * @return 編集画面
     */
    @GetMapping("/client/{id}/edit")
    public String clientEdit(@PathVariable Integer id, Model model) {
    	
    	/**
    	 * 編集対象の店舗情報を取得
    	 */
    	 ClientEntity client = clientService.findById(id);
    	 
    	// 編集画面用のDTOに格納
    	    ClientUpdateRequest clientUpdateRequest = new ClientUpdateRequest();
    	    clientUpdateRequest.setId(client.getId());
    	    clientUpdateRequest.setStoreName(client.getStoreName());
    	    clientUpdateRequest.setWorkStyle(client.getWorkStyle());
    	    clientUpdateRequest.setStoreAddress(client.getStoreAddress());
    	    clientUpdateRequest.setTellNumber(client.getTellNumber());
    	    model.addAttribute("clientUpdateRequest", clientUpdateRequest);
    	    return "client/edit";
    	  }
    	    
    /**
     * 登録情報更新
     * @param clientRequest リクエストデータ
     * @param model Model
     * @return 登録情報詳細画面
     */
    @RequestMapping("/client/update")
    public String clientUpdate(@Validated @ModelAttribute ClientUpdateRequest clientUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	
        	List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
              
              model.addAttribute("validationError", errorList);
              return "client/edit";
            } 
          }
        
     // ユーザー情報の更新
        clientService.update(clientUpdateRequest);
        return String.format("redirect:/client/%d", clientUpdateRequest.getId());
        
      }
    
    /**
     * 登録情報削除
     * @param id 表示する店舗ID
     * @param model Model
     * @return 店舗情報詳細画面
     */
    @GetMapping("/client/{id}/delete")
    
    public String clientDelete(@PathVariable Integer id, Model model) {
    	
    	// 登録情報の削除
        clientService.delete(id);
        return "redirect:/client/list";
    }
    }
    
    	   
    

