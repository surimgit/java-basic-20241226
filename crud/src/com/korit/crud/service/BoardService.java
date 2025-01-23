package com.korit.crud.service;

import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.PostBoardRequestDto;

public interface BoardService {

	void postBoard(PostBoardRequestDto requestDto, String id);
	
	void getBoardList();
	
	void getBoardView(Integer boardNumber);
	
	boolean checkUpdate(Integer boardNumber, String id);
	
	void patchBoard(PatchBoardRequestDto requestDto, Integer boardNumber, String id);
	
	void deleteBoard(Integer boardNumber, String id);
	
}