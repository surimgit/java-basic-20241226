package com.korit.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.korit.crud.entity.BoardEntity;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.vo.BoardListVO;
import com.korit.crud.vo.BoardViewVO;

public class BoardRepositoryImplement implements BoardRepository {

	private final Connection connection;
	
	public BoardRepositoryImplement(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(BoardEntity boardEntity) {
		final String SQL = "INSERT INTO board (title, contents, write_date, writer_id) VALUES (?, ?, CURDATE(), ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, boardEntity.getTitle());
			preparedStatement.setString(2, boardEntity.getContents());
			preparedStatement.setString(3, boardEntity.getWriterId());
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<BoardListVO> findAll() {
		
		List<BoardListVO> boardList = new ArrayList<>();
		
		final String SQL = "SELECT B.board_number, B.title, U.nickname, B.write_date FROM board B INNER JOIN user U ORDER BY board_number DESC";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Integer boardNumber = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String writerNickname = resultSet.getString(3);
				String writeDate = resultSet.getString(4);
				
				BoardListVO vo = new BoardListVO(boardNumber, title, writerNickname, writeDate);
				boardList.add(vo);
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public BoardViewVO findById(Integer boardNumber) {
		
		BoardViewVO board = null;
		
		final String SQL = "SELECT B.title, B.contents, B.writer_id, U.nickname, B.write_date FROM board B INNER JOIN user U WHERE B.board_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, boardNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String title = resultSet.getString(1);
				String contents = resultSet.getString(2);
				String writerId = resultSet.getString(3);
				String writerNickname = resultSet.getString(4);
				String writeDate = resultSet.getString(5);
				
				board = new BoardViewVO(title, contents, writerId, writerNickname, writeDate);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return board;
	}
	
	@Override
	public boolean existsById(Integer boardNumber) {
		
		boolean exist = false;
		
		final String SQL = "SELECT * FROM board WHERE board_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, boardNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			exist = resultSet.next();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return exist;
	}

	@Override
	public boolean existsByIdAndBoardNumber(String writerId, Integer boardNumber) {
		boolean exist = false;
		
		final String SQL = "SELECT * FROM board WHERE writer_id = ? AND board_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, writerId);
			preparedStatement.setInt(2, boardNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			exist = resultSet.next();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return exist;
	}
	
	@Override
	public boolean updateByTitleAndContents(Integer boardNumber, String title, String contents) {
		boolean result = false;
		
		final String SQL = "UPDATE board SET title = ?, contents = ? WHERE board_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, contents);
			preparedStatement.setInt(3, boardNumber);
			preparedStatement.executeUpdate();		
			
			result = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean deleteByBoardNumber(Integer boardNumber) {
		boolean result = false;
		
		final String SQL = "DELETE FROM board WHERE board_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, boardNumber);
			preparedStatement.executeUpdate();			
			
			result = true;	
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return result;
	}

}