package com.example.spring_beauty.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 催事情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BeautyUpdateRequest extends BeautyRequest implements Serializable {
	
		/*
		 * ID
		 */
		private Integer Id;

		}
