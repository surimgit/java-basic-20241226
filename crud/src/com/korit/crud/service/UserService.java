package com.korit.crud.service;

import com.korit.crud.dto.user.DeleteUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserService {
	void getSignInUserInformation(String id);
	
	void patchSignInUserInformation(PatchSignInUserRequestDto requestDto, String id);

	void deleteSignInUser(DeleteUserRequestDto requestDto, String id);
}