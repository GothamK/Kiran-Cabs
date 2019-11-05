package com.kcabs.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kcabs.dao.AttendanceDao;
import com.kcabs.dao.CarDocsDao;
import com.kcabs.dao.CarInsurancesDao;
import com.kcabs.dao.CarsDao;
import com.kcabs.dao.EmergencyContactsDao;
import com.kcabs.dao.EmployeeDao;
import com.kcabs.dao.EmployeeInsuranceDao;
import com.kcabs.dao.FinesDao;
import com.kcabs.dao.InterStatePermissionsDao;
import com.kcabs.dao.MonthlySalaryDao;
import com.kcabs.dao.NetGainsDao;
import com.kcabs.dao.PaymentsDao;
import com.kcabs.dao.ServiceRecordsDao;
import com.kcabs.dao.TripDao;
import com.kcabs.dao.UserDao;
import com.kcabs.model.Attendance;
import com.kcabs.model.CarDocs;
import com.kcabs.model.CarInsurances;
import com.kcabs.model.Cars;
import com.kcabs.model.EmergencyContacts;
import com.kcabs.model.Employee;
import com.kcabs.model.EmployeeInsurance;
import com.kcabs.model.Fines;
import com.kcabs.model.InterStatePermissions;
import com.kcabs.model.MonthlySalary;
import com.kcabs.model.NetGains;
import com.kcabs.model.Payments;
import com.kcabs.model.ServiceRecords;
import com.kcabs.model.Trip;
import com.kcabs.model.User;
import com.kcabs.service.UserService;

@RestController
@Controller
@RequestMapping(value="/admin")

public class DeleteContoller 
{

	@Autowired
	 UserService userService;
	 Trip trip;
	 MonthlySalary ms;
	 Payments pay;
	 Fines fines; 
	 ServiceRecords sr;
	 @Autowired
	 AttendanceDao atd;
	 @Autowired
	 CarDocsDao cdd;
	 @Autowired
	 CarInsurancesDao cid;
	 @Autowired
	 CarsDao cd;
	 @Autowired
	 EmergencyContactsDao ecd;
	 @Autowired
	 EmployeeDao ed;
	 @Autowired
	 EmployeeInsuranceDao eid;
	 @Autowired
	 FinesDao fd;
	 @Autowired
	 InterStatePermissionsDao ispd;
	 @Autowired
	 MonthlySalaryDao msd;
	 @Autowired
	 NetGainsDao ngd;
	 @Autowired
	 PaymentsDao pd;
	 @Autowired
	 ServiceRecordsDao srd;
	 @Autowired
	 TripDao td;
	 @Autowired
	 UserDao ud;
	 
	 	@Autowired
	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	    {
	        this.jt = jdbcTemplate;
	    }
	 
	 
	 @Autowired
	 JdbcTemplate jt;
	 
	 
	 @RequestMapping(value="/contacts/delete/{contact_no}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("emp_id") String contact_no){
	  ecd.delete(contact_no);
	  
	  return new ModelAndView("redirect:/recorder/contacts/list");
	 }
	 
	 @RequestMapping(value="/einsurance/delete/{ins_no}", method=RequestMethod.GET)
	 public ModelAndView delei(@PathVariable("ins_no") Integer ins_no){
	  eid.delete(ins_no);
	  
	  return new ModelAndView("redirect:/recorder/einsurance/list");
	 }
	 
	 
	 @RequestMapping(value="/isp/delete/{p_no}", method=RequestMethod.GET)
	 public ModelAndView delisp(@PathVariable("p_no") Integer p_no){
	  ispd.delete(p_no);
	  
	  return new ModelAndView("redirect:/recorder/isp/list");
	 }
	 
	 
	 @RequestMapping(value="/trips/delete/{trip_id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("emp_id") Integer trip_id){
	 td.deleteTrip(trip_id);
	  
	  return new ModelAndView("redirect:/recorder/trips/list");
	 }
	 
	 //Service, Salary, Fines, Employee, Cars, Trips, Net Gains, Car Docs, Attendance
	// 


}
