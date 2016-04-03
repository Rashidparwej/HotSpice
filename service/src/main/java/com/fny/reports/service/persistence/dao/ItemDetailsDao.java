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

import com.fny.reports.commons.entity.CategoryDO;
import com.fny.reports.commons.entity.ItemDO;
import com.fny.reports.commons.entity.ItemDetailDO;

@Repository
@Service
public class ItemDetailsDao {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	private static final Log LOG = LogFactory.getLog(ItemDetailsDao.class);

	public List<CategoryDO> getDishType()
	{
	String sql="select * from hotspice.category";
    
	List<CategoryDO> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<CategoryDO>>() {

		public List<CategoryDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<CategoryDO> empList = new ArrayList<CategoryDO>();
			while (rs.next()) {

				CategoryDO emp = new CategoryDO(rs.getInt("category_id"),rs.getString("name"));
				
				empList.add(emp);
			}
			return empList;
		}

	});

	return empList;
}

	public List<ItemDetailDO> getItemType(String category)
	{
		
	 String sql="select item_id,name from item where category_id in("+
	 "select category_id from category where name = '" + category + "')";
    LOG.info(sql);
	List<ItemDetailDO> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<ItemDetailDO>>() {

		public List<ItemDetailDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<ItemDetailDO> empList = new ArrayList<ItemDetailDO>();
			while (rs.next()) {

				ItemDetailDO emp = new ItemDetailDO(rs.getInt("item_id"),rs.getString("name"));
				
				empList.add(emp);
			}
			return empList;
		}

	});

	return empList;
	}

	public List<ItemDetailDO> getItemIds()
	{
		
	 String sql="select item_id,name from item ";
    LOG.info(sql);
	List<ItemDetailDO> empList = this.jdbcTemplate.query(sql, new ResultSetExtractor<List<ItemDetailDO>>() {

		public List<ItemDetailDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<ItemDetailDO> empList = new ArrayList<ItemDetailDO>();
			while (rs.next()) {

				ItemDetailDO emp =new ItemDetailDO(rs.getInt("item_id"),rs.getString("name"));
				
				empList.add(emp);
			}
			return empList;
		}

	});

	return empList;
	}
	
	public void delete(Integer itemId)
	{
		this.jdbcTemplate.update(
                "delete from item where item_id=?", 
                itemId);
	}
	
}
