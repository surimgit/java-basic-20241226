package com.korit.crud.service.implement;

import java.util.List;

import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.PostBoardRequestDto;
import com.korit.crud.entity.BoardEntity;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.service.BoardService;
import com.korit.crud.vo.BoardListVO;
import com.korit.crud.vo.BoardViewVO;

public class BoardServiceImplement implements BoardService {
	
	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	
	public BoardServiceImplement(
			BoardRepository boardRepository,
			UserRepository userRepository
	) {
		this.boardRepository = boardRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void postBoard(PostBoardRequestDto requestDto, String id) {
		boolean isExistUser = userRepository.existsById(id);
		if (!isExistUser) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		BoardEntity boardEntity = new BoardEntity(requestDto, id);
		boardRepository.save(boardEntity);
		System.out.println("작성에 성공했습니다.");
	}

	@Override
	public void getBoardList() {
		List<BoardListVO> list = boardRepository.findAll();
		System.out.println("게시물 번호 / 게시물 제목 / 작성자 닉네임 / 작성일");
		for (BoardListVO board: list) System.out.println(board);
	}

	@Override
	public void getBoardView(Integer boardNumber) {
		BoardViewVO board = boardRepository.findById(boardNumber);
		if (board == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		System.out.println(board);
	}

	@Override
	public boolean checkUpdate(Integer boardNumber, String id) {
		BoardViewVO board = boardRepository.findById(boardNumber);
		if (board == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return false;
		}
		boolean isWriter = board.getWriterId().equals(id);
		if (!isWriter) {
			System.out.println("권한이 없습니다.");
			return false;
		}
		
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContents());
		
		return true;
	}

	@Override
	public void patchBoard(PatchBoardRequestDto requestDto, Integer boardNumber, String id) {
		String title = requestDto.getTitle();
		String contents = requestDto.getContents();
		boardRepository.updateByTitleAndContents(boardNumber, title, contents);
		System.out.println("수정에 성공했습니다.");
	}

	@Override
	public void deleteBoard(Integer boardNumber, String id) {
		BoardViewVO board = boardRepository.findById(boardNumber);
		if (board == null) {
			System.out.println("존재하지 않는 게시물입니다.");
			return;
		}
		boolean isWriter = board.getWriterId().equals(id);
		if (!isWriter) {
			System.out.println("권한이 없습니다.");
			return;
		}
		boardRepository.deleteByBoardNumber(boardNumber);
		System.out.println("삭제에 성공했습니다.");
	}

}