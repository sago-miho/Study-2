package com.example.spring_beauty.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/*
 *  店舗情報リクエストデータ
 */

@Data
public class BeautyForm{
    
    /*
     * ID
     */
    private Integer Id;
    
    /*
     * メーカー名
     */
    @NotEmpty(message = "メーカー名を入力してください")
    private String makerName;
    
    /*
     * 開催期間
     */
    @NotEmpty(message = "期間を入力してください")
    private String period;
    
    /*
     * エリア
     */
    @NotEmpty(message = "エリアを入力してください")
    private String area;
    
    /*
     * 会場名
     */
    @NotEmpty(message = "会場名を入力してください")
    private String placer;
}
