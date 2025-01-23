package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.UserController;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.service.UserService;

public class UserControllerImplement implements UserController {

	private final UserService userService;
	
	public UserControllerImplement(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void getSignInUser() {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		userService.getSignInUser(id);
	}

	@Override
	public void patchSignInUser(PatchSignInUserRequestDto requestDto) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		userService.patchSignInUser(requestDto, id);
	}

	@Override
	public void deleteSignInUser(DeleteSignInUserRequestDto requestDto) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		userService.deleteSignInUser(requestDto, id);
	}

}




