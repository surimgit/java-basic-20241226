package com.korit.crud.controller.implement;

import com.korit.crud.CrudApplication;
import com.korit.crud.controller.BoardController;
import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.PostBoardRequestDto;
import com.korit.crud.service.BoardService;

public class BoardControllerImplement implements BoardController {
	
	private final BoardService boardService;
	
	public BoardControllerImplement(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public void postBoard(PostBoardRequestDto requestDto) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		boardService.postBoard(requestDto, id);
	}

	@Override
	public void getBoardList() {
		boardService.getBoardList();
	}

	@Override
	public void getBoardView(Integer boardNumber) {
		boardService.getBoardView(boardNumber);
	}

	@Override
	public boolean checkWriter(Integer boardNumber) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return false;
		}
		return boardService.checkUpdate(boardNumber, id);
	}

	@Override
	public void updateBoard(PatchBoardRequestDto requestDto, Integer boardNumber) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		if (requestDto == null) {
			System.out.println("오류가 발생했습니다.");
			return;
		}
		if (!requestDto.validate()) return;
		
		boardService.patchBoard(requestDto, boardNumber, id);
	}

	@Override
	public void deleteBoard(Integer boardNumber) {
		String id = CrudApplication.SESSION;
		if (id == null) {
			System.out.println("로그인이 되어있지 않습니다.");
			return;
		}
		boardService.deleteBoard(boardNumber, id);
	}

}