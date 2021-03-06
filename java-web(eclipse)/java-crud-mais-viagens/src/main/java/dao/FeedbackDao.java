package dao;

import model.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;

public class FeedbackDao implements CRUD{
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Feedback feedback){
		sql = "INSERT INTO feedback VALUES (NULL, ?, ?)";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, feedback.getData());
			preparedStatement.setString(2, feedback.getDescricao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct insert on database.");
			
		}catch(SQLException e) {
			System.out.println("--Incorrect insert on database." + e.getMessage());
		}
	}
	
	public static List<Feedback> find(String pesquisa){
		
		sql = String.format("SELECT * FROM feedback WHERE dataFeedback like '%s%%' OR descricao like '%s%%' ", pesquisa,pesquisa);
		List <Feedback> feedbacks = new ArrayList<Feedback>();
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql); 
			
			
			while(resultSet.next()) {
				
				Feedback feedback = new Feedback();
				
				feedback.setId_feedback(resultSet.getInt("id_feedback"));
				feedback.setData(resultSet.getString("dataFeedback"));
				feedback.setDescricao(resultSet.getString("descricao"));
				
				feedbacks.add(feedback);
				
			}
			
			System.out.println("--Correct find feedbacks");
			return feedbacks;
			
		}catch(SQLException e) {
			
			System.out.println("--Incorrect find feedbacks. "+ e.getMessage());
			return null;
			
		}
		
	}
	
	public static Feedback findByPk(int id_feedback){
		
		sql = String.format("SELECT * FROM feedback WHERE id_feedback = %d ", id_feedback);
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql); 
			
			Feedback feedback = new Feedback();
			
			while(resultSet.next()) {
				
				feedback.setId_feedback(resultSet.getInt("id_feedback"));
				feedback.setData(resultSet.getString("dataFeedback"));
				feedback.setDescricao(resultSet.getString("descricao"));
				
			}
			
			System.out.println("--Correct find by pk feedbacks");
			return feedback;
			
		}catch(SQLException e) {
			
			System.out.println("--Incorrect find by pk feedbacks. "+ e.getMessage());
			return null;
			
		}
	}
	
	public static void update(Feedback feedback){
		
		sql = "UPDATE feedback SET dataFeedback=?, descricao=? WHERE id_feedback=?";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, feedback.getData());
			preparedStatement.setString(2, feedback.getDescricao());
			preparedStatement.setInt(3, feedback.getId_feedback());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct update on database.");
			
		}catch(SQLException e) {
			System.out.println("--Incorrect update on database." + e.getMessage());
		}
		
	}
	
	public static void delete(int feedbackId){
		sql = "DELETE FROM feedback WHERE id_feedback = ?";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,feedbackId); 
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct delete on feedback.");
			
		}catch(SQLException e) {
			System.out.println("--Incorrect delete on feedback. " + e.getMessage());
		}
	}

}
