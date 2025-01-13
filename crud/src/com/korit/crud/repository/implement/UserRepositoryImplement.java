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

	@Override
	public void updateByNickname(String id, String nickname) {
		for(UserEntity entity : DATABASE_LIST) {
			if(entity.getId().equals(id)){
				entity.setNickname(nickname);
			}
		}
	}

	@Override
	public void deleteById(String id) {
		UserEntity userEntity = null;
		
		for(UserEntity entity : DATABASE_LIST) {
			if(entity.getId().equals(id)) {
				userEntity = entity;
			}
		}
		DATABASE_LIST.remove(userEntity);
	}

	@Override
	public void deleteOne(UserEntity userEntity) {
		DATABASE_LIST.remove(userEntity);
	}
}
