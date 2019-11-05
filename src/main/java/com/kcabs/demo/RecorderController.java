package com.kcabs.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kcabs.dao.EmployeeDao;
import com.kcabs.model.Employee;
import com.kcabs.model.Trip;
import com.kcabs.model.User;
import com.kcabs.service.TripService;
import com.kcabs.service.UserService;

@RestController

@RequestMapping(value="/recorder")

public class RecorderController 
{
	@Autowired EmployeeDao ed;
	@Autowired	UserService userService;
	@Autowired	TripService tripService;
	@Autowired	JdbcTemplate jt;
	
	@Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
    {
        this.jt = jdbcTemplate;
    }	
	
	@RequestMapping(value="/record/{id}")
	public ModelAndView rec(@PathVariable("id") String id){
		ModelAndView model = new ModelAndView("record");  
		model.addObject(id);
		return model;
	}	
	
	@RequestMapping(value="/records")
	public ModelAndView rec(){
		ModelAndView model = new ModelAndView("records");  
		return model;
	}
	
	 @RequestMapping(value="/attendance/list", method=RequestMethod.GET)
	 public ModelAndView listat(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM attendance"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/cardocs/list", method=RequestMethod.GET)
	 public ModelAndView listcd(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM car_docs"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/carins/list", method=RequestMethod.GET)
	 public ModelAndView listci(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM car_insurances"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/cars/list", method=RequestMethod.GET)
	 public ModelAndView listcar(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM cars"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/contacts/list", method=RequestMethod.GET)
	 public ModelAndView listcon(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM emergency_contacts"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/employee/list", method=RequestMethod.GET)
	 public ModelAndView listemp(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM employee"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/einsurance/list", method=RequestMethod.GET)
	 public ModelAndView listei(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM e_insurance"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/fines/list", method=RequestMethod.GET)
	 public ModelAndView listf(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM fines"));
	  
	  return model;
	 }
	 @RequestMapping(value="/isp/list", method=RequestMethod.GET)
	 public ModelAndView listisp(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM interstate_permissions"));
	  
	  return model;
	 }
	 @RequestMapping(value="/salary/list", method=RequestMethod.GET)
	 public ModelAndView listsal(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM monthly_salary"));
	  
	  return model;
	 }
	 @RequestMapping(value="/net/list", method=RequestMethod.GET)
	 public ModelAndView listnet(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM net_gains"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/payments/list", method=RequestMethod.GET)
	 public ModelAndView listp(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM payments"));
	  
	  return model;
	 }
	 @RequestMapping(value="/service/list", method=RequestMethod.GET)
	 public ModelAndView listser(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM service_records"));
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/user/list", method=RequestMethod.GET)
	 public ModelAndView list(){
	  ModelAndView model = new ModelAndView("user/user_page");
	  
	  List<User> list = userService.list();
	  model.addObject("listUser", list);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/trips/list", method=RequestMethod.GET)
	 public ModelAndView listt(){
	  ModelAndView model = new ModelAndView("glist");	  
	  model.addObject("obj", jt.queryForList("SELECT * FROM trips"));
	  
	  return model;
	 }
	
	 @RequestMapping(value="/trips/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("trips/form");
	  
	  Trip trip = new Trip();
	  model.addObject("form", trip);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/trips/add", method=RequestMethod.POST)
	 public ModelAndView addpost(@ModelAttribute("form") Trip trip){
	   tripService.addTrip(trip);
	  
	  return new ModelAndView("redirect:/trips/list");
	 }
	 
	 @RequestMapping(value="/trips/update/{trip_id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("trip_id") Integer trip_id){
	  ModelAndView model = new ModelAndView("trips/form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/trips/update", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("trform") Trip trip, Model j)
	 {
		  Integer i = trip.getTrip_id();
		  Integer prev = jt.queryForObject("Select rating from trips where trip_id =" +i,Integer.class);
		  Integer curr = trip.getRating();
	      tripService.updateTrip(trip);
	      Integer b =tripService.findDrivIdByTripId(i).getDriv_no();
		  Employee e = ed.getEmpById(b);
		  jt.update("UPDATE employee set avg_rating = ? where e_id = ?",(e.getAvg_rating() * e.getNo_of_ratings() + (curr-prev))/(e.getNo_of_ratings()),b);
		  j.addAttribute("trip_id",i);	   
	  
	  return new ModelAndView("redirect:/trips/list");
	 }
	 
	 @RequestMapping(value="/delete/{trip_id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("trip_id") Integer trip_id){
	  tripService.deleteTrip(trip_id);
	  
	  return new ModelAndView("redirect:/trips/list");
	 }
	
	@RequestMapping(value="/page/get", method=RequestMethod.GET)
	public ModelAndView searchPage(@RequestParam("id") String id, Model j) {
		return new ModelAndView("redirect:/recorder/record/"+id); 
	}
}
