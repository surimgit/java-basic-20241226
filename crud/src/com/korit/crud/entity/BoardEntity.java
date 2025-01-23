package com.korit.crud.entity;

import com.korit.crud.dto.board.PostBoardRequestDto;

public class BoardEntity {

	private Integer boardNumber;
	private String title;
	private String contents;
	private String writeDate;
	private String writerId;
	
	public BoardEntity(Integer boardNumber, String title, String contents, String writeDate, String writerId) {
		this.boardNumber = boardNumber;
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
		this.writerId = writerId;
	}
	
	public BoardEntity(PostBoardRequestDto requestDto, String writerId) {
		this.title = requestDto.getTitle();
		this.contents = requestDto.getContents();
		this.writerId = writerId;
	}

	public Integer getBoardNumber() {
		return boardNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public String getWriterId() {
		return writerId;
	}
	
}