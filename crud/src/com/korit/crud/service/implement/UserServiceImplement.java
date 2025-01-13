package com.korit.crud.service.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.dto.user.DeleteUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.UserService;

public class UserServiceImplement implements UserService{
	private final UserRepository userRepository;
	
	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void getSignInUserInformation(String id) {
//		유저 정보를 저장소에서 불러오기
		UserEntity userEntity = userRepository.findById(id);
//		데이터에서 가져온 유저 정보의 유효성 검사
		if(userEntity == null) {
			System.out.println("유저 정보가 존재하지 않습니다.");
			return;
		}
		System.out.println("아이디: " + userEntity.getId());
		System.out.println("닉네임: " + userEntity.getNickname());
	}

	@Override
	public void patchSignInUserInformation(PatchSignInUserRequestDto requestDto, String id) {
		boolean existedUser = userRepository.existById(id);
		if(!existedUser) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		String nickname = requestDto.getNickname();
		userRepository.updateByNickname(id, nickname);
		System.out.println("성공했습니다.");
	}

	@Override
	public void deleteSignInUser(DeleteUserRequestDto requestDto, String id) {
		UserEntity entity = userRepository.findById(id);	
		if(entity == null) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if(!entity.getPassword().equals(requestDto.getPassword())) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		userRepository.deleteById(id);
		CrudApplication.SEESSION = null;
		System.out.println("성공했습니다.");
	}
}
