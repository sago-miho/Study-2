package com.example.spring_beauty.dto;

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
public class BeautyRequest implements Serializable {
    
    /**
     * メーカー名
     */
    @NotEmpty(message = "メーカー名を入力してください")
    @Size(max = 20, message = "メーカー名は20文字以内で入力してください")
    private String makerName;
    
    /*
     * 開催期間
     */
    @NotEmpty(message = "開催期間を入力してください")
    @Size(max = 20, message = "開催期間は20文字以内で入力してください")
    private String period;
    
    /*
     * エリア
     */
    @NotEmpty(message = "エリアを入力してください")
    @Size(max = 20, message = "エリアは20文字以内で入力してください")
    private String area;
    
    /*
     * 会場名
     */
    @NotEmpty(message = "会場名を入力してください")
    @Size(max = 20, message = "会場名は20文字以内で入力してください")
    private String place;
}