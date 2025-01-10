package com.korit.crud;

import java.util.Scanner;

import com.korit.crud.controller.AuthController;
import com.korit.crud.controller.implement.AuthControllerImplement;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.repository.implement.UserRepositoryImplement;
import com.korit.crud.service.AuthService;
import com.korit.crud.service.implement.AuthServiceImplement;

public class CrudApplication {
	public static void main(String[] args) {
		
		UserRepository userRepository = new UserRepositoryImplement();
		AuthService authService = new AuthServiceImplement(userRepository);
		AuthController authController = new AuthControllerImplement(authService);
			
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("작업: ");
			String request = scanner.nextLine();
			if(request.equals("exit"))break;
			
			if(request.equals("회원가입")) {
				SignUpRequestDto requestDto = new SignUpRequestDto();
				authController.signUp(requestDto);
			}
			
			if(request.equals("로그인")) {
				SignInRequestDto requestDto = new SignInRequestDto();
				authController.signIn(requestDto);
			}
		}
		
		scanner.close();
	}
}