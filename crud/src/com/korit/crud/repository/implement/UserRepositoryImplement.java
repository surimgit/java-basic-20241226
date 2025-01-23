package com.korit.crud.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.korit.crud.entity.UserEntity;
import com.korit.crud.repository.UserRepository;

public class UserRepositoryImplement implements UserRepository {

	private final Connection connection;
	
	public UserRepositoryImplement(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean existsById(String id) {
		
		final String SQL = "SELECT * FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// String userId = resultSet.getString(1);
				String userId = resultSet.getString("id");
				if (userId.equals(id)) return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
		
//		for (UserEntity entity: DATABASE_LIST) {
//			if (entity.getId().equals(id)) return true;
//		}
//		return false;
	}

	@Override
	public void save(UserEntity userEntity) {
		
		final String SQL = "INSERT INTO user VALUES (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, userEntity.getId());
			preparedStatement.setString(2, userEntity.getPassword());
			preparedStatement.setString(3, userEntity.getNickname());
			
			preparedStatement.executeUpdate();			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		// DATABASE_LIST.add(userEntity);
	}

	@Override
	public UserEntity findById(String id) {

		UserEntity userEntity = null;
		
		final String SQL = "SELECT * FROM user WHERE id = ?";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String userId = resultSet.getString(1);
				String password = resultSet.getString(2);
				String nickname = resultSet.getString(3);
				
				userEntity = new UserEntity(userId, password, nickname);
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return userEntity;
		
	}

	@Override
	public void updateByNickname(String id, String nickname) {
		
		final String SQL = "UPDATE user SET nickname = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, nickname);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(String id) {
		
		final String SQL = "DELETE FROM user WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public void deleteOne(UserEntity userEntity) {
		String id = userEntity.getId();
		this.deleteById(id);
	}

}





