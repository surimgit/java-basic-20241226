package com.korit.crud.service;

import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserService {
	void getSignInUser(String id);
	void patchSignInUser(PatchSignInUserRequestDto requestDto, String id);
	void deleteSignInUser(DeleteSignInUserRequestDto requestDto, String id);
}









