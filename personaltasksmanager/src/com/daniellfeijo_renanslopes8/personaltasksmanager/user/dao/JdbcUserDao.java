package com.daniellfeijo_renanslopes8.personaltasksmanager.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.daniellfeijo_renanslopes8.personaltasksmanager.user.model.Users;
import com.daniellfeijo_renanslopes8.personaltasksmanager.util.ConnectionFactory;

public class JdbcUserDao {
	private final Connection connection;

	public JdbcUserDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public boolean existUser(Users user) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from users where login = ? and password = ?");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				rs.close();
				stmt.close();
				return true;
			}
			rs.close();
			stmt.close();
			return false;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
