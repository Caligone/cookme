package dao.instance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UserModelBean;

public class UserDao {

	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;

	public UserDao(String DB_HOST, String DB_PORT, String DB_NAME,
			String DB_USER, String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}

	public void addUser(UserModelBean user) {
		// Cr�ation de la requ�te
		java.sql.PreparedStatement query;
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			// Creation de l'�l�ment de requ�te
            // Executer puis parcourir les r�sultats
            String sql = "INSERT INTO User (firstname, lastname, age, email, login, pwd) VALUES(?,?,?,?,?,?)";
            query = connection.prepareStatement(sql);
            query.setString(1, user.getFirstname());
            query.setString(2, user.getLastname());
            query.setInt(3, user.getAge());
            query.setString(4, user.getEmail());
            query.setString(5, user.getLogin());
            query.setString(6, user.getPwd());
            System.out.println(sql);
			int rs = query.executeUpdate();
			query.close();
			connection.close();

/*
			// Executer puis parcourir les r�sultats
			String sql = "INSERT INTO `User` (`firstname`, `lastname`, `age`, `email`, `login`, `pwd`) VALUES ('"
					+ user.getFirstname()
					+ "', '"
					+ user.getLastname()
					+ "', '"
                    + user.getAge()
                    + "', '"
                    + user.getEmail()
                    + "', '"
					+ user.getLogin()
					+ "', '"
					+ user.getPwd() + "');";
            query = connection.prepareStatement(sql);
            query.setString(1, user.getFirstname());
            query.setString(2, user.getLastname());
            query.setInt(3, user.getAge());
            query.setString(4, user.getEmail());
            query.setString(5, user.getLogin());
            query.setString(6, user.getFirstname());
			int rs = query.executeUpdate(sql);
			*/
			query.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserModelBean> getAllUser() {
		// return value
		ArrayList<UserModelBean> userList = new ArrayList<UserModelBean>();

		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			// Cr�ation de la requ�te
			java.sql.Statement query;

			// Creation de l'�l�ment de requ�te
			query = connection.createStatement();

			// Executer puis parcourir les r�sultats
			java.sql.ResultSet rs = query
					.executeQuery("SELECT * FROM User");
			while (rs.next()) {
				// Cr�ation de l'utilisateur
				UserModelBean user = new UserModelBean(
						rs.getString("lastname"), rs.getString("firstname"), rs.getString("email"),
						rs.getInt("age"), rs.getString("login"),
						rs.getString("pwd"));
				System.out.println("User : " + user);

				// ajout de l'utilisateur r�cup�r� � la liste
				userList.add(user);
			}
			rs.close();
			query.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public UserModelBean checkUser(String login, String pwd) {
		try {
			// create connection
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"
					+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			// Cr�ation de la requ�te
			java.sql.Statement query;

			// Creation de l'�l�ment de requ�te
			query = connection.createStatement();

			// Executer puis parcourir les r�sultats
			java.sql.ResultSet rs = query
					.executeQuery("SELECT * FROM User where login='"
							+ login + "' and pwd='" + pwd + "';");

			if (!rs.next()) {
				return null;
			} else {
				// Cr�ation de l'utilisateur
				UserModelBean user = new UserModelBean(
				rs.getString("lastname"), rs.getString("firstname"), rs.getString("email"),
				rs.getInt("age"), rs.getString("login"),
				rs.getString("pwd"));
				System.out.println("User Login : " + user);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
