package com.korit.crud.controller;

import com.korit.crud.dto.user.DeleteUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserController {
	void getSignInUserInformation();
	
	void patchSignInUserInformation(PatchSignInUserRequestDto requestDto);

	void deleteSignInUser(DeleteUserRequestDto requestDto);
}
