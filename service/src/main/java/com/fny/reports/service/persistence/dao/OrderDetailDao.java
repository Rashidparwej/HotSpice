package com.fny.reports.service.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fny.reports.commons.entity.CategoryDO;
import com.fny.reports.commons.entity.ItemDetailDO;
import com.fny.reports.commons.entity.MyOrdersDO;
import com.fny.reports.commons.entity.OrderDetailsDO;

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
	public void insert(Integer userId,Integer itemId,Integer quant)
	{
		
		String sql = "INSERT INTO order_details " +
				"(item_id,user_id,qnt) VALUES (?, ?, ?)";
					 LOG.info("inside order detail update");
					 System.out.println("inside order detail update");
			LOG.info(sql);
		System.out.println(sql);
			jdbcTemplate.update(sql, new Object[] { itemId,
					userId,quant  
					
			});
					
	}

	public Integer itemIdFromItem(String itemName) {
		
	     try {
	    	 LOG.info("inside getting itemid from item");
	    	 System.out.println("nside getting itemid from item");
	         String sql = "select item_id from item where name ='"+ itemName + "'";
	         System.out.println(sql);

	         LOG.info(sql);
	         Integer id= jdbcTemplate.queryForObject(sql, Integer.class);
	         LOG.info(id);
	         System.out.println(id);
	         return id;
	         
	    } 
	    catch (EmptyResultDataAccessException e) {
	       if(LOG.isDebugEnabled()){
	           LOG.debug(e);
	       }
	    }
	     return 0;
			}
	
	 public List <OrderDetailsDO> getMyOrder(Integer userId)
	 {
		 String sql="SELECT order_id,status FROM hotspice.order_details where user_id='"+ userId + "'";

		    
			List<OrderDetailsDO> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<OrderDetailsDO>>() {

				public List<OrderDetailsDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<OrderDetailsDO> empList = new ArrayList<OrderDetailsDO>();
					while (rs.next()) {

						OrderDetailsDO emp = new OrderDetailsDO(rs.getInt("order_id"),rs.getString("status"));
						
						empList.add(emp);
					}
					return empList;
				}

			});

			return empList;
		}

	public void updateStats(Integer orderId) {
		
		this.jdbcTemplate.update(
                "update hotspice.order_details set status='Cancel' where order_id=?", 
                orderId);
	}
	 }

