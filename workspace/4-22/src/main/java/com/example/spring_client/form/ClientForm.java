package com.example.spring_client.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/*
 *  店舗情報リクエストデータ
 */

@Data
public class ClientForm{
    
    /*
     * ID
     */
    private Integer Id;
    
    /*
     * 店舗名
     */
    @NotEmpty(message = "店舗名を入力してください")
    private String storeName;
    
    /*
     * 稼働形態
     */
    @NotEmpty(message = "稼働形態を入力してください")
    private String workStyle;
    
    /*
     * 店舗住所
     */
    @NotEmpty(message = "店舗住所を入力してください")
    private String storeAddress;
    
    /*
     * 店舗電話番号
     */
    @NotEmpty(message = "店舗電話番号を入力してください")
    private String tellNumber;
}
