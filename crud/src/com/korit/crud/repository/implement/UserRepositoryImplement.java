package com.korit.crud.repository.implement;

import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository {

	@Override
	public boolean existById(String id) {
		for(UserEntity entity : DATABASE_LIST) {
			if(entity.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void save(UserEntity userEntity) {
		DATABASE_LIST.add(userEntity);
	}

	@Override
	public UserEntity findById(String id) {
		for(UserEntity entity : DATABASE_LIST) {
			if(entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}

}
