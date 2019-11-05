package com.kcabs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kcabs.dao.EmployeeDao;
import com.kcabs.dao.TripDao;
import com.kcabs.model.Employee;
import com.kcabs.model.Trip;
import com.kcabs.model.User;
import com.kcabs.service.TripService;

@RestController
@RequestMapping
public class WelcomeController
{
	
	
	@Autowired
	TripDao td; 
	@Autowired
	EmployeeDao ed;
	
	Employee e;
	
	@Autowired
	TripService tripService;
	
	@Autowired
	JdbcTemplate jt;
	
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
    {
        this.jt = jdbcTemplate;
    }
	
	
	
	@RequestMapping(value="")
	public ModelAndView list(){
		  ModelAndView model = new ModelAndView("Homepage");
		  
		  return model;
		 }
	
	@RequestMapping(value=  "/login\\?error")
	public ModelAndView loginerr(){
		  ModelAndView model = new ModelAndView("loginerr");
		  
		  return model;
		 }
	@RequestMapping(value="/login" )
	public ModelAndView login(){
		  ModelAndView model = new ModelAndView("login");
		  
		  return model;
		 }
	@RequestMapping(value="/logoutcomplete")
	public ModelAndView logout(){
		  ModelAndView model = new ModelAndView("logoutpage");
		  
		  return model;
		 }
	
	@RequestMapping(value="/managers")
	public ModelAndView managers()
	{
		ModelAndView model = new ModelAndView("managers");
		return model;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		ModelAndView model = new ModelAndView("/user/user_form");
		User user = new User(); 
		model.addObject("userForm",user);
		return model;
	}
	
	
	
	 @PostMapping("/trips/rate")
	 public  ModelAndView update(@RequestParam("trip_id") Integer trip_id, @RequestParam("charges") Integer charges, @RequestParam("rating") Integer rating)     
	 {
	  td.rateTrips(trip_id,charges,rating);
	  Integer a = td.findDrivIdByTripId(trip_id).getDriv_no();
	  jt.update("UPDATE employee set no_of_ratings=?, avg_rating = ? where e_id=?",e.getNo_of_ratings() +1 ,(e.getAvg_rating() * e.getNo_of_ratings() + rating)/(e.getNo_of_ratings()+1),a);
	  
	  return new ModelAndView("redirect:/trips/list");
	 }
	 
	 @GetMapping("/trips/rate/{trip_id}")
	 public ModelAndView update(@PathVariable int trip_id, Model k) {
		 k.addAttribute("trform",trip_id);
		 return new ModelAndView("/trips/ratingform");		 
	 }
	 
	 
	 
	 
	
//	@RequestMapping()
	
	
	
}
