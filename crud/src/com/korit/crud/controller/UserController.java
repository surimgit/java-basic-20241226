package com.korit.crud.controller;

import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserController {
	void getSignInUser();
	void patchSignInUser(PatchSignInUserRequestDto requestDto);
	void deleteSignInUser(DeleteSignInUserRequestDto requestDto);
}





