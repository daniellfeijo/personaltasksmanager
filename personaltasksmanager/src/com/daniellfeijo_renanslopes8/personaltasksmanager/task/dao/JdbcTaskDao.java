package com.daniellfeijo_renanslopes8.personaltasksmanager.task.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.daniellfeijo_renanslopes8.personaltasksmanager.model.Task;
import com.daniellfeijo_renanslopes8.personaltasksmanager.util.ConnectionFactory;


public class JdbcTaskDao {
	private final Connection connection;

	public JdbcTaskDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Task task) {
		String sql = "insert into task (description, finished) values (?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, task.getDescription());
			stmt.setBoolean(2, task.isFinished());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void edit(Task task) {
		String sql = "update task set description = ?, finished = ?, finishedDate = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, task.getDescription());
			stmt.setBoolean(2, task.isFinished());
			stmt.setDate(3, task.getFinishedDate() != null ? new Date(
					task.getFinishedDate().getTimeInMillis()) : null);
			stmt.setLong(4, task.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void finish(Long id) {
		if (id == null) {
			throw new IllegalStateException("Id of Task can not be null.");
		}

		String sql = "update task set finished = ?, finishedDate = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(3, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void remove(Task task) {
		if (task.getId() == null) {
			throw new IllegalStateException("Id of task can not be null.");
		}

		String sql = "delete from task where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, task.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Task findById(Long id) {

		if (id == null) {
			throw new IllegalStateException("Id of task can not be null.");
		}

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from task where id = ?");
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populateTask(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Task> list() {
		try {
			List<Task> tasks = new ArrayList<Task>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from task");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona a tarefa na lista
				tasks.add(populateTask(rs));
			}

			rs.close();
			stmt.close();

			return tasks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Task populateTask(ResultSet rs) throws SQLException {
		Task task = new Task();

		// popula o objeto tarefa
		task.setId(rs.getLong("id"));
		task.setDescription(rs.getString("description"));
		task.setFinished(rs.getBoolean("finished"));

		// popula a data de finalizacao da tarefa, fazendo a conversao
		Date data = rs.getDate("finishedDate");
		if (data != null) {
			Calendar finishedDate = Calendar.getInstance();
			finishedDate.setTime(data);
			task.setFinishedDate(finishedDate);
		}
		return task;
	}
}
