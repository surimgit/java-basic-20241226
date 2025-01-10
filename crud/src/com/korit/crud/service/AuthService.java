package com.korit.crud.service;

import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;

// Service: 실제 비즈니스 로직이 구현되는 모듈
// 직전 비즈니스로직 결과에 대한 데이터 검증, 다음 비즈니스 로직을 위한 데이터 검증
// 데이터 베이스를 활용한 데이터 검증, 각종 연산 및 로직
public interface AuthService {
//	회원가입
	void signUp(SignUpRequestDto requestDto);
	
//	로그인
	void signIn(SignInRequestDto requestDto);
}
