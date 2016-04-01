package com.fny.reports.service.persistence.dao;

import java.sql.ResultSet;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

@Repository
@Service
public class UpdateOrderStatusDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public List<Integer> getOrderId()
	{
		String sql="select order_id from order_details";
        
		List<Integer> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<Integer>>() {

			public List<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Integer> empList = new ArrayList<Integer>();
				while (rs.next()) {

					Integer emp = new Integer(rs.getString("order_id"));
					
					empList.add(emp);
				}
				return empList;
			}

		});

		return empList;
	
}
}
