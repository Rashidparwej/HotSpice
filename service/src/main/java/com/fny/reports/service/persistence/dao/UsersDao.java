package com.fny.reports.service.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fny.reports.commons.entity.UsersDO;

@Repository
@Service
public class UsersDao {
	final Log LOG = LogFactory.getLog(UsersDao.class);
	public static final String RESPONSE_FAILURE = "FAILURE";
	public static final String RESPONSE_SUCCESS = "SUCCESS";
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	public List<UsersDO> checkUserPresence(String uname,String pass)
	{
	   String sql="select user_id,first_name,last_name,email,uname,pass from users where uname='" + uname + "' and pass='" + pass + "'";
		LOG.info(sql);
		List<UsersDO> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<UsersDO>>() {

			public List<UsersDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UsersDO> empList = new ArrayList<UsersDO>();
				while (rs.next()) {                     
					
					UsersDO emp = new UsersDO(rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email")
							,rs.getString("uname"), rs.getString("pass"),
							rs.getInt("user_id")
							);
					
					empList.add(emp);
				}
				return empList;
			}

		});
		return empList;
	}
	
	public String addDateOfUser(UsersDO user)
	{
		if(user !=null)
		{
		String sql = "INSERT INTO users " +
				"(first_name, last_name, email, uname, pass) VALUES (?, ?, ?, ?, ?)";
					 
			LOG.info(sql);

			jdbcTemplate.update(sql, new Object[] { user.getFirstName(),user.getLastName(),
					user.getEmail(),user.getUserName(),user.getPassword()
				
			});
	return RESPONSE_SUCCESS;
	}
		else 
			return RESPONSE_FAILURE;

}
}
