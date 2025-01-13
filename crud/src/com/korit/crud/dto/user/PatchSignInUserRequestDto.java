package com.korit.crud.dto.user;

import java.util.Scanner;

public class PatchSignInUserRequestDto {
	private String nickname;
	
	public PatchSignInUserRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("닉네임: ");
		this.nickname = scanner.nextLine();
	}
	
	public boolean validate() {
		if(!isNotNull()) {
			System.out.println("모두 입력해주세요");
			return false;
		}
		if(!nicknameValidate()) {
			System.out.println("닉네임은 비어있거나 공백으로만 구성될 수는 없습니다");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return nickname != null;
	}
	
	private boolean nicknameValidate() {
		return !nickname.isBlank();
	}

	public String getNickname() {
		return nickname;
	}
}