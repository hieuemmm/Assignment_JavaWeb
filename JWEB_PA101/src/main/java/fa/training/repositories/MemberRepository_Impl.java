package fa.training.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.entities.Member;
import fa.training.utils.DBconnection;

public class MemberRepository_Impl implements IMemberRepository {

	DBconnection dBconnection = new DBconnection();
	private final String SELECT_BY_MEMBER = "SELECT * from member where member.user_name = ?;";
	private final String INSERT_INTO_MEMBER_REGISTER = "INSERT INTO member(user_name, password, email, created_date) VALUES(?,?,?,?);";
	private final String UPDATE_MEMBER = "UPDATE member SET first_name=?, last_name=? ,phone=?, description=? , update_time=? WHERE user_name=?;";

	@Override
	public Member findByUserName(String username) {
		Member member = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
        	connection = dBconnection.getConnection();
        	preparedStatement = connection.prepareStatement(SELECT_BY_MEMBER);
        	System.out.println(username);
			preparedStatement.setString(1, username.trim());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String userName = resultSet.getString("user_name");
				String passWord = resultSet.getString("password");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				String description = resultSet.getString("description");
				String createdDate = resultSet.getString("created_date");
				String updateTime = resultSet.getString("update_time");
				member = new Member(firstName, lastName, userName, passWord, phone, email, description, createdDate, updateTime);
			}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return member;
	}

	@Override
	public boolean saveRegister(Member member) {
		boolean check = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = dBconnection.getConnection();
        	preparedStatement = connection.prepareStatement(INSERT_INTO_MEMBER_REGISTER);

			preparedStatement.setString(1, member.getUserName());
			preparedStatement.setString(2, member.getPassWord());
			preparedStatement.setString(3, member.getEmail());
			preparedStatement.setString(4, member.getCreatedDate());
			check = preparedStatement.executeUpdate() > 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return check;
	}

	@Override
	public boolean saveEdit(Member member) {
        boolean check = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = dBconnection.getConnection();
        	preparedStatement = connection.prepareStatement(UPDATE_MEMBER);
        	
            preparedStatement.setString(1, member.getFirstName());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setString(3, member.getPhone());
			preparedStatement.setString(4, member.getDescription());
			preparedStatement.setString(5, member.getUpdateTime());
			preparedStatement.setString(6, member.getUserName());
			
			check = preparedStatement.executeUpdate() > 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return check;
	}
}
