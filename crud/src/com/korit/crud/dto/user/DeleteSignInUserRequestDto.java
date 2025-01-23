package com.korit.crud.dto.user;

import java.util.Scanner;

public class DeleteSignInUserRequestDto {

	private String password;
	
	public DeleteSignInUserRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("비밀번호 : ");
		this.password = scanner.nextLine();
	}

	public String getPassword() {
		return password;
	}
	
	public boolean validate() {
		if (!isNotNull()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return password != null;
	}
	
}







