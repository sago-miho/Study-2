package com.example.spring_user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.spring_user.entity.UserEntity;
import com.example.spring_user.repository.UserRepository;
import com.example.spring_user.service.UserService;

//テスト環境準備
@SpringBootTest
public class UserServiceTest {
	
	//テスト対象とモックの作成
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;//モックに差し替え
	
	@Test
	void findById_モックを使ってDB依存を回避() {
		//モックが返すエンティティを準備
		UserEntity user = new UserEntity();
		
		user.setId(1);
		user.setName("佐護美歩");
		user.setAddress("愛知県名古屋市北区田幡2丁目12-29");
		user.setPhone("080-6433-1568");
		
		//モックの挙動を設定
		when(userRepository.getOne(1)).thenReturn(user);
		
		//テスト実行
		UserEntity result = userService.findById(1);
		
		//検証
		assertEquals("佐護美歩",result.getName());
		assertEquals("愛知県名古屋市北区田幡2丁目12-29",result.getAddress());
		assertEquals("080-6433-1568",result.getPhone());
		
	}
}
