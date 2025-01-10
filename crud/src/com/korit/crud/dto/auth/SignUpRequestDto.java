package com.korit.crud.dto.auth;

import java.util.Scanner;

// DTO (Data Transfer Object): 모듈간 데이터 전송을 위한 객체
public class SignUpRequestDto {
	private String id;
	private String password;
	private String passwordCheck;
	private String nickname;
	
	public SignUpRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디 : ");
		this.id = scanner.nextLine();
		System.out.print("비밀번호 : ");
		this.password = scanner.nextLine();
		System.out.print("비밀번호 확인 : ");
		this.passwordCheck = scanner.nextLine();
		System.out.print("닉네임 : ");
		this.nickname = scanner.nextLine();
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getNickname() {
		return nickname;
	}

	@Override
	public String toString() {
		return "SignUpRequestDto [id=" + id + ", password=" + password + ", passwordCheck=" + passwordCheck
				+ ", nickname=" + nickname + "]";
	}
	
	public boolean validate() {
		if (!isNotNull()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		if (!idValidate()) {
			System.out.println("아이디는 6자 이상이어야 합니다.");
			return false;
		}
		if (!passwordValidate()) {
			System.out.println("비밀번호는 8자 이상이어야 합니다.");
			return false;
		}
		if (!passwordCheckValidate()) {
			System.out.println("비밀번호가 서로 일치하지 않습니다.");
			return false;
		}
		if (!nicknameValidate()) {
			System.out.println("닉네임은 비어있거나 공백으로만 구성할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	private boolean idValidate() {
		return id.length() >= 6;
	}
	
	private boolean passwordValidate() {
		return password.length() >= 8;
	}
	
	private boolean passwordCheckValidate() {
		return password.equals(passwordCheck);
	}
	
	private boolean nicknameValidate() {
		return !nickname.isBlank();
	}
	
	private boolean isNotNull() {
		return id != null && password != null && passwordCheck != null && nickname != null;
	}
	
}





