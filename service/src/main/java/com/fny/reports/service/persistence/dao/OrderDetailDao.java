package com.fny.reports.service.persistence.dao;

import javax.sql.DataSource;

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

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public void update(Integer orderId,String status)
	{
		
		LOG.info("inside update order status");
	//	String sql="update hotspice.order_details set status=? where order_id=?";
		LOG.info("sql");
		this.jdbcTemplate.update(
                "update hotspice.order_details set status=? where order_id=?", 
                status, orderId);
		//jdbcTemplate.update(sql, "status","orderId");
	   
	}
	
	
}
