package com.korit.crud.controller;

import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;

// 클라이어트와 서버간의 접점에 해당
// 요청(입력)에 대한 검증, 응답(출력)에 대한 검증 및 분기 처리

// 인증 인가 작업(회원가입, 로그인)
// DIP에 의해 의존성을 추상화에 의존하기 위해 인터페이스로 먼저 정의

public interface AuthController {
	// 회원가입
	void signUp(SignUpRequestDto requestDto);
	
	// 로그인
	void signIn(SignInRequestDto requestDto);
	
}
