package com.korit.crud.controller;

import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.PostBoardRequestDto;
import com.korit.crud.vo.BoardViewVO;

public interface BoardController {
	void postBoard(PostBoardRequestDto requestDto);
	void getBoardList();
	void getBoardView(Integer boardNumber);
	boolean checkWriter(Integer boardNumber);
	void updateBoard(PatchBoardRequestDto requestDto, Integer boardNumber);
	void deleteBoard(Integer boardNumber);
}