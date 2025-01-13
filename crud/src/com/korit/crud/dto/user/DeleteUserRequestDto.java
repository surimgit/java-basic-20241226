package com.korit.crud.dto.user;

import java.util.Scanner;

public class DeleteUserRequestDto {

	private String password;
	
	public DeleteUserRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("비밀번호: ");
		this.password = scanner.nextLine();
	}
	
	
	public boolean validate() {
		if(!isNotNull()) {
			System.out.println("전부 입력하세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return password != null;
	}


	public String getPassword() {
		return password;
	}
}
