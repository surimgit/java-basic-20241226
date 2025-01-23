package com.korit.crud.vo;

import java.util.Objects;

public class BoardViewVO {

	private String title;
	private String contents;
	private String writeDate;
	private String writerId;
	private String writerNickname;

	public BoardViewVO(String title, String contents, String writeDate, String writerId, String writerNickname) {
		this.title = title;
		this.contents = contents;
		this.writeDate = writeDate;
		this.writerId = writerId;
		this.writerNickname = writerNickname;
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

	public String getWriterNickname() {
		return writerNickname;
	}

	@Override
	public String toString() {
		return "제목 : " + title + "\n작성자 닉네임 : " + writerNickname + "\n작성일 : " + writeDate + "\n내용 : " + contents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contents, title, writeDate, writerNickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardViewVO other = (BoardViewVO) obj;
		return Objects.equals(contents, other.contents) && Objects.equals(title, other.title)
				&& Objects.equals(writeDate, other.writeDate) && Objects.equals(writerNickname, other.writerNickname);
	}
	
}