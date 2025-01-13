package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.UserController;
import com.korit.crud.dto.user.DeleteUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.service.UserService;

public class UserControllerImplement implements UserController {
	private final UserService userService;
	
	public UserControllerImplement(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void getSignInUserInformation() {
//		로그인 유저 아이디 받아오기
		String id = CrudApplication.SEESSION;
		
//		유효성 검사
		if(id == null) {
			System.out.println("로그인이 되어 있지 않습니다.");
			return;
		}
		
		userService.getSignInUserInformation(id);
	}

	@Override
	public void patchSignInUserInformation(PatchSignInUserRequestDto requestDto) {
		String id = CrudApplication.SEESSION;
		if(id == null) {
			System.out.println("로그인이 되어 있지 않습니다.");
			return;
		}
		if(requestDto == null) {
			System.out.println("닉네임을 다시 입력해주세요");
			return;
		}
		if(!requestDto.validate()) return;         
		
		userService.patchSignInUserInformation(requestDto, id);
	}

	@Override
	public void deleteSignInUser(DeleteUserRequestDto requestDto) {
		String id = CrudApplication.SEESSION;		
		if(id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
		}
		if(requestDto == null) {
			System.out.println("비밀번호를 다시 입력해주세요");
			return;
		}
		
		if(!requestDto.validate()) return;  
		
		userService.deleteSignInUser(requestDto, id);
	}
}
