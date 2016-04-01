package com.fny.reports.service.persistence.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fny.reports.commons.entity.ItemDO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@Repository
@Service
public class UpdateItemDao{
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	private static final Log LOG = LogFactory.getLog(UpdateItemDao.class);

	public void insert(ItemDO item){
			
		String sql = "INSERT INTO item " +
			"(item_id, category_id, name, cost) VALUES (?, ?, ?, ?)";
				 
		LOG.info(sql);
		
		jdbcTemplate.update(sql, new Object[] { item.getCategoryId(),
			item.getCost(),item.getItemId(),item.getName()  
			
		});
				
	}
}
