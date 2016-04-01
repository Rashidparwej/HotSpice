package com.fny.reports.service.persistence.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class OrderDetailDao {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	private static final Log LOG = LogFactory.getLog(OrderDetailDao.class);
	
	public void update(Integer orderId,String status)
	{
		String sql="update hotspice.order_details set status=? where order_id=?";
		LOG.info("sql");
		jdbcTemplate.update(sql, "status","orderId");
	   
	}
	
}
