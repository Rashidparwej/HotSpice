package com.fny.reports.controller;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fny.reports.commons.entity.ItemDO;
import com.fny.reports.commons.entity.OrderSummaryDO;
import com.fny.reports.service.persistence.dao.OrderDetailDao;
import com.fny.reports.service.persistence.dao.OrderSummaryDao;
import com.fny.reports.service.persistence.dao.UpdateItemDao;
import com.fny.reports.service.persistence.dao.UpdateOrderStatusDao;

@Controller
@RequestMapping("/api")
public class HomeController {


	@Autowired
	private UpdateOrderStatusDao updateOrderStatusDao;

	@Autowired
	private UpdateItemDao updateItemDao;

	@Autowired
	private OrderDetailDao orderDetailsDao;
	
	@Autowired
	private OrderSummaryDao orderSummaryDao;
	
	private static final Log LOG = LogFactory.getLog(HomeController.class);

	//private PaymentSuccessDO paymentSuccessDo;
                                                   
	public HomeController() {                      
		System.out.println("Bean created");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		System.out.println("Invoked home");
		return "index";
	}

	
	// return list;
	@RequestMapping(value="/updateItems", method = RequestMethod.GET)
	public String update() {
		System.out.println("Invoked home");
		return "UpdateItem";
	}

	@RequestMapping(value="/orderdetail",method= RequestMethod.GET)
	public ModelAndView orderdetails() throws SQLException
	{
		ModelAndView modelAndView=new ModelAndView("OrderDetails");
		 List<OrderSummaryDO> orderSummary=orderSummaryDao.queryForOrderDetails();
		 modelAndView.addObject("orderSummary", orderSummary);

		return modelAndView;
	}
	
	@RequestMapping(value="/updateorderstatus",method= RequestMethod.GET)
	public ModelAndView updateOrder()
	{
		ModelAndView modelAndView=new ModelAndView("UpdateOrderStatus");
		List<Integer> orders=updateOrderStatusDao.getOrderId();
		modelAndView.addObject("orders",orders);
		return modelAndView;
	}                                                   
	@RequestMapping(value="/addItem",method= RequestMethod.POST)
	public void addItem(@RequestParam("itemId") Integer itemId, @RequestParam("categoryId") Integer categoryId,
			@RequestParam("name") String name,@RequestParam("cost")Integer cost)
	{
		ItemDO item =new ItemDO();
		item.setCategoryId(categoryId);
		item.setCost(cost);
		item.setName(name);
		item.setItemId(itemId);
		updateItemDao.insert(item);                  
	}
	@RequestMapping(value="/removeItem",method= RequestMethod.POST)
	public ModelAndView removeItem()
	{
		ModelAndView modelAndView=new ModelAndView("categoryWiseSku");
                                                     
		return modelAndView;                      
	}
	@RequestMapping(value="/updateStatusDb",method= RequestMethod.POST)
	public void updateStatusDb(@RequestParam("orderId") Integer orderId, @RequestParam("status") String status)
	{
		orderDetailsDao.update(orderId,status);
		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login1(@RequestParam("username") String username, @RequestParam("password") String password){
		
		return null;
	}
	

	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String login(@RequestParam("firstname") String firstname, @RequestParam("lastName") String lastName,
			 @RequestParam("userName") String userName, @RequestParam("password") String password){
		
		return null;
	}
	@RequestMapping(value="/adminPanel", method = RequestMethod.GET)
	public String adminPanel() {
    		System.out.println("Invoking dashboard links");
			return "adminPanel";
		
	}
	
}
