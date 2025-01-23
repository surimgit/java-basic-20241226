package com.korit.crud.service.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.UserService;

public class UserServiceImplement implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void getSignInUser(String id) {
		// 유저 정보를 저장소에서 불러오기
		UserEntity userEntity = userRepository.findById(id);
		if (userEntity == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		System.out.println("아이디 : " + userEntity.getId() + " / 닉네임 : " + userEntity.getNickname());
	}

	@Override
	public void patchSignInUser(PatchSignInUserRequestDto requestDto, String id) {
		boolean existedUser = userRepository.existsById(id);
		if (!existedUser) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		String nickname = requestDto.getNickname();
		userRepository.updateByNickname(id, nickname);
		System.out.println("성공했습니다.");
	}

	@Override
	public void deleteSignInUser(DeleteSignInUserRequestDto requestDto, String id) {
		UserEntity userEntity = userRepository.findById(id);
		if (userEntity == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		String password = requestDto.getPassword();
		String existPassword = userEntity.getPassword();
		if (!existPassword.equals(password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		userRepository.deleteOne(userEntity);
		CrudApplication.SESSION = null;
		System.out.println("성공했습니다.");
	}

}






