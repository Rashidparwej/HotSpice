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

import com.fny.reports.commons.entity.CategoryDO;
import com.fny.reports.commons.entity.ItemDO;
import com.fny.reports.commons.entity.ItemDetailDO;
import com.fny.reports.commons.entity.MyOrdersDO;
import com.fny.reports.commons.entity.OrderDetailsDO;
import com.fny.reports.commons.entity.OrderSummaryDO;
import com.fny.reports.commons.entity.UsersDO;
import com.fny.reports.service.persistence.dao.ItemDetailsDao;
import com.fny.reports.service.persistence.dao.OrderDetailDao;
import com.fny.reports.service.persistence.dao.OrderSummaryDao;
import com.fny.reports.service.persistence.dao.UpdateItemDao;
import com.fny.reports.service.persistence.dao.UpdateOrderStatusDao;
import com.fny.reports.service.persistence.dao.UsersDao;

@Controller
@RequestMapping("/api")
public class HomeController {

	public static final String RESPONSE_FAILURE = "FAILURE";
	public static final String RESPONSE_SUCCESS = "SUCCESS";

	@Autowired
	private UpdateOrderStatusDao updateOrderStatusDao;

	@Autowired
	private UpdateItemDao updateItemDao;

	@Autowired
	private OrderDetailDao orderDetailsDao;
	
	@Autowired
	private OrderSummaryDao orderSummaryDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private ItemDetailsDao itemDetailsDao;
	
	
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
		@RequestMapping(value="/SignUp", method = RequestMethod.GET)
		public String SignUp() {
			System.out.println("Invoked home");
			return "SignUp";
		}

	// return list;
	@RequestMapping(value="/updateItems", method = RequestMethod.GET)
	public String update() {
		System.out.println("Invoked home");
		return "UpdateItem";
	}

	
	@RequestMapping(value="/deleteItemDb", method = RequestMethod.POST)
	public String deleteItem(@RequestParam("itemId") Integer itemId) {
		
		itemDetailsDao.delete(itemId);
		return "Welcome";
	 
	}
	@RequestMapping(value="/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem() {
		ModelAndView modelAndView=new ModelAndView("DeleteItem");
		 List<ItemDetailDO> listOfItems=itemDetailsDao.getItemIds();
		 modelAndView.addObject("listOfItems", listOfItems);

		return modelAndView;
	
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
		item.setItemId(itemId);
		item.setCategoryId(categoryId);
		item.setCost(cost);                        
		item.setName(name);
		updateItemDao.insert(item);                  
	}
	
	@RequestMapping(value="/updateStatusDb",method= RequestMethod.POST)
	public void updateStatusDb(@RequestParam("orderId") Integer orderId, @RequestParam("status") String status)
	{
		orderDetailsDao.update(orderId,status);
		
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("uname") String uname, @RequestParam("pass") String pass){
	
		List<UsersDO> userData=usersDao.checkUserPresence(uname, pass);
		List<CategoryDO> dishType=itemDetailsDao.getDishType();
		//List<MyOrdersDO> myorder = orderDetailsDao.getMyOrder(userData.get(0).getUserId());
		ModelAndView modelAndView=new ModelAndView("PlaceOrder");		 
		 modelAndView.addObject("userData", userData);
		 modelAndView.addObject("dishType",dishType);
		/* if(myorder.size()>0)
		 modelAndView.addObject("myorder",myorder);
	
	if(userData.size()==0)
	 {
		 ModelAndView modelAndView1=new ModelAndView("errorPage");
		 return modelAndView1;

	 }*/
		 return modelAndView;

	}
	

	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signup(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email, @RequestParam("uname") String uname, @RequestParam("pass") String pass){
		
		UsersDO user =new UsersDO();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setUserName(uname);
        user.setPassword(pass);                     
		if(usersDao.addDateOfUser(user)==RESPONSE_SUCCESS)
		{
			return "start";
	    }
		else
			return "errorPage";
	}

	@RequestMapping(value="/orderItem", method = RequestMethod.POST)
	public ModelAndView orderItem(
		 @RequestParam("itemType") String itemType,@RequestParam("userId") Integer userId){
		
		 List<ItemDetailDO> listOfItems=itemDetailsDao.getItemType(itemType);
		 LOG.info(listOfItems);
		 UsersDO user=new UsersDO();
		 user.setUserId(userId);
		 ModelAndView modelAndView=new ModelAndView("makeOrder");
		 modelAndView.addObject("listOfItems", listOfItems);
		 modelAndView.addObject("user",user);
	     //List<OrderDetailsDO> orderHistory=orderDetailsDao.getMyOrder(userId);
	     
		 return modelAndView;
		
	}
	@RequestMapping(value="/orderConfirmed",method= RequestMethod.POST)
	public ModelAndView orderConfirmed(@RequestParam("userId") Integer userId,
			@RequestParam("item") String item,
			@RequestParam("quant") Integer quant)
	{
		ModelAndView modelAndView=new ModelAndView("Success");
		Integer itemId=orderDetailsDao.itemIdFromItem(item);
		orderDetailsDao.insert(userId, itemId, quant); 
		return modelAndView;                      
	}
	@RequestMapping(value="/adminPanel", method = RequestMethod.GET)
	public String adminPanel() {
    		System.out.println("Invoking dashboard links");
			return "adminPanel";
		
	}
	
}
