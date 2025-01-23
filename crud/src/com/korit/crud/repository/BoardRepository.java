package com.korit.crud.repository;

import java.util.List;

import com.korit.crud.entity.BoardEntity;
import com.korit.crud.vo.BoardListVO;
import com.korit.crud.vo.BoardViewVO;

public interface BoardRepository {

	void save(BoardEntity boardEntity);
	
	List<BoardListVO> findAll();
	BoardViewVO findById(Integer boardNumber);
	
	boolean existsById(Integer boardNumber);
	boolean existsByIdAndBoardNumber(String writerId, Integer boardNumber);
	
	boolean updateByTitleAndContents(Integer boardNumber, String title, String contents);
	
	boolean deleteByBoardNumber(Integer boardNumber);
	
}