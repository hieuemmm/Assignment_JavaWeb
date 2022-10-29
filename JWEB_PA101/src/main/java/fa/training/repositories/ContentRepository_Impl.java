package fa.training.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Content;
import fa.training.utils.DBconnection;

public class ContentRepository_Impl implements IContentRepository {
	DBconnection dBconnection = new DBconnection();
	private final String SELECT_ALL_CONTENT = "select * from content where user_name = ?";
	private final String INSERT_INTO_CONTENT ="insert into Content(title,brief,content,created_date,user_name) values (?,?,?,?,?)";
	
	@Override
	public List<Content> findAllByUser(String userName) {
		List<Content> contentList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
        	connection = dBconnection.getConnection();
        	preparedStatement = connection.prepareStatement(SELECT_ALL_CONTENT);
        	preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getDate("created_date"));
				int contentID = resultSet.getInt("id_content");
				String title = resultSet.getString("title");
				String brief = resultSet.getString("brief");
				String content = resultSet.getString("content");
				String createdDate = resultSet.getString("created_date");
				String updateTime = resultSet.getString("update_time");
				String userNameDB = resultSet.getString("user_name");
				Content content1 = new Content(contentID, title, brief, content, createdDate, updateTime, userNameDB);
				contentList.add(content1);
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
		return contentList;
	}

	@Override
	public boolean saveContent(Content content) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean check = false;
        try {
        	connection = dBconnection.getConnection();
        	preparedStatement = connection.prepareStatement(INSERT_INTO_CONTENT);
        	
			preparedStatement.setString(1, content.getTitle());
			preparedStatement.setString(2, content.getBrief());
			preparedStatement.setString(3, content.getContent());
			preparedStatement.setString(4, content.getCreatedDate());
			preparedStatement.setString(5, content.getUseName());
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
