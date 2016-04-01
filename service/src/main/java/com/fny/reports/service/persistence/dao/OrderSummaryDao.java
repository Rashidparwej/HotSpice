package com.fny.reports.service.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fny.reports.commons.entity.OrderSummaryDO;

@Repository
@Service
public class OrderSummaryDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public List<OrderSummaryDO> queryForOrderDetails() throws SQLException
	{
		String sql="SELECT order_id,CONCAT(u.first_name,u.last_name) as CUSTOMER_NAME,email,i.name as DISH_NAME,cost,od.qnt as QUANTITY,status,created_date"+
				" FROM hotspice.order_details as od inner join users as u on od.user_id=u.user_id"+
				" inner join item as i on i.item_id=od.item_id"+
				" inner join category as c on c.category_id=i.category_id order by created_date";
		
		
		                                            
		List<OrderSummaryDO> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<OrderSummaryDO>>() {

			public List<OrderSummaryDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<OrderSummaryDO> empList = new ArrayList<OrderSummaryDO>();
				while (rs.next()) {

					OrderSummaryDO emp = new OrderSummaryDO(rs.getInt("order_id"),rs.getString("CUSTOMER_NAME"),
							rs.getString("email"),rs.getString("DISH_NAME"),rs.getInt("cost"),rs.getInt("QUANTITY"),rs.getString("status"),
							rs.getString("created_date")
							);
					
					empList.add(emp);
				}
				return empList;
			}

		});

		return empList;
	}
	
}
