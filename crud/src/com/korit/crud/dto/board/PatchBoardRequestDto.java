package com.korit.crud.dto.board;

import java.util.Scanner;

public class PatchBoardRequestDto {
	
	private String title;
	private String contents;
	
	public PatchBoardRequestDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("제목 : ");
		this.title = scanner.nextLine();
		System.out.print("내용 : ");
		this.contents = scanner.nextLine();
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}
	
	public boolean validate() {
		if (!isNotNull() || !titleValidate() || !contentsValidate()) {
			System.out.println("모두 입력해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotNull() {
		return title != null && contents != null;
	}
	
	private boolean titleValidate() {
		return !title.isBlank();
	}
	
	private boolean contentsValidate() {
		return !contents.isBlank();
	}
	
}