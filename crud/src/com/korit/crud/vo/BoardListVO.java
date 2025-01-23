package com.korit.crud.vo;

import java.util.Objects;

public class BoardListVO {
	
	private Integer boardNumber;
	private String title;
	private String writerNickname;
	private String writeDate;
	
	public BoardListVO(Integer boardNumber, String title, String writerNickname, String writeDate) {
		this.boardNumber = boardNumber;
		this.title = title;
		this.writerNickname = writerNickname;
		this.writeDate = writeDate;
	}

	public Integer getBoardNumber() {
		return boardNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public String getWriteDate() {
		return writeDate;
	}
	
	@Override
	public String toString() {
		return boardNumber + " / " + title + " / " + writerNickname + " / " + writeDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardNumber, title, writeDate, writerNickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardListVO other = (BoardListVO) obj;
		return Objects.equals(boardNumber, other.boardNumber) && Objects.equals(title, other.title)
				&& Objects.equals(writeDate, other.writeDate) && Objects.equals(writerNickname, other.writerNickname);
	}

}