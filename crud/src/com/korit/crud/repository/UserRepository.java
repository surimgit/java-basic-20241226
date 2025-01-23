package com.korit.crud.repository;

import java.util.ArrayList;
import java.util.List;

import com.korit.crud.entity.UserEntity;

// Repository : 데이터베이스 작업을 위한 모듈(레이어)
// 데이터베이스에 삽입, 조회, 수정, 삭제 작업을 처리
public interface UserRepository {
	List<UserEntity> DATABASE_LIST = new ArrayList<>();
	
	void save(UserEntity userEntity);
	boolean existsById(String id);
	UserEntity findById(String id);
	void updateByNickname(String id, String nickname);
	void deleteById(String id);
	void deleteOne(UserEntity userEntity);
}







