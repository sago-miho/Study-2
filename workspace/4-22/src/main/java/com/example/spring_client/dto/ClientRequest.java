package com.example.spring_client.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 店舗情報 リクエストデータ
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class ClientRequest implements Serializable {
    
    /**
     * 店舗名
     */
    @NotEmpty(message = "店舗名を入力してください")
    @Size(max = 20, message = "店舗名は20文字以内で入力してください")
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
    @Size(max = 50, message = "住所は50文字以内で入力してください")
    private String storeAddress;
    
    /*
     * 店舗電話番号
     */
    @NotEmpty(message = "店舗電話番号を入力してください")
    private String tellNumber;
}