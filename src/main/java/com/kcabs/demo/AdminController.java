package com.kcabs.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

public class AdminController 
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
	 
	 
	 @RequestMapping(value="/attendance/add", method=RequestMethod.GET)
	 public ModelAndView addat(){
	  ModelAndView model = new ModelAndView("attendance/form");
	  
	  Attendance at = new Attendance();
	  model.addObject("atForm", at);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/attendance/add", method=RequestMethod.POST)
	 public ModelAndView addatp(@ModelAttribute("atForm") Attendance at){
	   atd.add(at.getDate(),at.getEmp_id(), at.getLeaves_taken());
	  
	  return new ModelAndView("redirect:/recorder/attendance/list");
	 }
	 
	 
	 
	 @RequestMapping(value="/user/add", method=RequestMethod.GET)
	 public ModelAndView add(){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = new User();
	  model.addObject("userForm", user);
	  
	  return model;
	 }
	 @RequestMapping(value="/register", method=RequestMethod.GET)
	 public ModelAndView register(){
	  ModelAndView model = new ModelAndView("user/user_form");
	  
	  User user = new User();
	  model.addObject("userForm", user);
	  
	  return model;
	 }
	 @RequestMapping(value="/user/add", method=RequestMethod.POST)
	 public ModelAndView add(@ModelAttribute("userForm") User user){
	   userService.add(user);
	  
	  return new ModelAndView("redirect:/recorder/user/list");
	 }
	 
//	 @RequestMapping(value="/save", method=RequestMethod.POST)
//	 public ModelAndView save(@ModelAttribute("userForm") User user){
//	   userService.updateUser(user);
//	  return new ModelAndView("redirect:/user/list");
//	 }
	 
	 @RequestMapping(value="/user/delete/{username}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("username") String username){
	  userService.delete(username);
	  
	  return new ModelAndView("redirect:/recorder/user/list");
	 }
	 

	 
	 @RequestMapping(value="/cardocs/add", method=RequestMethod.GET)
	 public ModelAndView addcd(){
	  ModelAndView model = new ModelAndView("cardocs/form");
	  
	  CarDocs cd = new CarDocs();
	  model.addObject("cdForm", cd);
	  
	  return model;
	 }
	 @RequestMapping(value="/cardocs/add", method=RequestMethod.POST)
	 public ModelAndView addcdp(@ModelAttribute("cdForm") CarDocs cd){
	   cdd.add(cd.getRegistration_no(), cd.getPoll_check(), cd.getPoll_expiry(), cd.getI_no());
	  
	  return new ModelAndView("redirect:/recorder/cardocs/list");
	 }
	 
	 @RequestMapping(value="/carins/add", method=RequestMethod.GET)
	 public ModelAndView addci(){
	  ModelAndView model = new ModelAndView("carins/form");
	  CarInsurances ci1 = new CarInsurances(); 
	  model.addObject("ciForm", ci1);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/carins/add", method=RequestMethod.POST)
	 public ModelAndView addcip(@ModelAttribute("ciForm") CarInsurances ci2){
	  cid.add(ci2.getI_no(), ci2.getI_agent(), ci2.getI_amount(), ci2.getI_start(), ci2.getI_end());
	  
	  return new ModelAndView("redirect:/recorder/carins/list");
	 }
	 
	 @RequestMapping(value="/cars/add", method=RequestMethod.GET)
	 public ModelAndView addc(){
	  ModelAndView model = new ModelAndView("cars/form");
	  Cars c = new Cars(); 
	  model.addObject("cForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/cars/add", method=RequestMethod.POST)
	 public ModelAndView addcp(@ModelAttribute("cForm") Cars c){
	  cd.add(c.getRegistration_no(), c.getCompany(), c.getDist_travelled(), c.getSelling_price(), c.getModel(), c.getActive(), c.getCost_price(), c.getColour(), c.getCapacity(), c.getPurchase_date(), c.getFuel());
	  
	  return new ModelAndView("redirect:/recorder/cars/list");
	 }
	 
	 @RequestMapping(value="/contacts/add", method=RequestMethod.GET)
	 public ModelAndView addcon(){
	  ModelAndView model = new ModelAndView("contacts/form");
	  EmergencyContacts c = new EmergencyContacts(); 
	  model.addObject("contForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/contacts/add", method=RequestMethod.POST)
	 public ModelAndView addcp(@ModelAttribute("contForm") EmergencyContacts ec){
	  ecd.add(ec.getContact_no(),ec.getContact_name(), ec.getRelation(), ec.getE_id());
	  
	  return new ModelAndView("redirect:/recorder/contacts/list");
	 }
	 
		@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
		public ModelAndView addEmp() {
			ModelAndView model = new ModelAndView("employee/form");

			Employee employee = new Employee();
			model.addObject("empForm", employee);

			return model;
		}

		@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
		public ModelAndView addpost(@ModelAttribute("empForm") Employee emp) {
			ed.add(emp);

			return new ModelAndView("redirect:/recorder/employee/list");
		}
	 
	 @RequestMapping(value="/einsurance/add", method=RequestMethod.GET)
	 public ModelAndView addei(){
	  ModelAndView model = new ModelAndView("einsurance/form");
	  EmployeeInsurance c =new EmployeeInsurance(); 
	  model.addObject("eiForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/einsurance/add", method=RequestMethod.POST)
	 public ModelAndView addeip(@ModelAttribute("eiForm") EmployeeInsurance c){
	  eid.add(c.getIns_no(), c.getIns_provider(), c.getBeneficiary(), c.getRelation(), c.getIns_type(), c.getIns_amount(), c.getEmp_id());
	  
	  return new ModelAndView("redirect:/recorder/einsurance/list");
	 }
	 
	 @RequestMapping(value="/fines/add", method=RequestMethod.GET)
	 public ModelAndView addf(){
	  ModelAndView model = new ModelAndView("fines/form");
	  Fines c =new Fines(); 
	  model.addObject("fForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/fines/add", method=RequestMethod.POST)
	 public ModelAndView addf(@ModelAttribute("fForm") Fines c){
	  fd.add(c.getOffence(), c.getFined_amount(), c.getConsequences(), c.getRegn_no(), c.getDate(), c.getDriv_id());
	  
	  return new ModelAndView("redirect:/recorder/fines/list");
	 }
	 
	 @RequestMapping(value="/isp/add", method=RequestMethod.GET)
	 public ModelAndView addisp(){
	  ModelAndView model = new ModelAndView("isp/form");
	  InterStatePermissions c =new InterStatePermissions(); 
	  model.addObject("ispForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/isp/add", method=RequestMethod.POST)
	 public ModelAndView addf(@ModelAttribute("ispForm") InterStatePermissions c){
	  ispd.add(c.getP_no(), c.getPlace1(), c.getPlace2(), c.getS_date(), c.getP_tax(), c.getE_date(), c.getReg_no());
	  
	  return new ModelAndView("redirect:/recorder/isp/list");
	 }
	 
	 @RequestMapping(value="/salary/add", method=RequestMethod.GET)
	 public ModelAndView addms(){
	  ModelAndView model = new ModelAndView("salary/form");
	  MonthlySalary c =new MonthlySalary(); 
	  model.addObject("salForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/salary/add", method=RequestMethod.POST)
	 public ModelAndView addmsp(@ModelAttribute("salForm") MonthlySalary c){
	 msd.add(c.getCalculated_amount(), c.getDate(), c.getEmp_id());
	  
	  return new ModelAndView("redirect:/recorder/salary/list");
	 }
	 
	 @RequestMapping(value="/net/add", method=RequestMethod.GET)
	 public ModelAndView addnet(){
	  ModelAndView model = new ModelAndView("net/form");
	  NetGains c =new NetGains(); 
	  model.addObject("netForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/net/add", method=RequestMethod.POST)
	 public ModelAndView addnetp(@ModelAttribute("netForm") NetGains c){
	  ngd.add(c);
	  
	  return new ModelAndView("redirect:/recorder/net/list");
	 }
	 
	 @RequestMapping(value="/service/add", method=RequestMethod.GET)
	 public ModelAndView addser(){
	  ModelAndView model = new ModelAndView("service/form");
	  ServiceRecords c =new ServiceRecords(); 
	  model.addObject("serForm", c);
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/service/add", method=RequestMethod.POST)
	 public ModelAndView addserp(@ModelAttribute("serForm") ServiceRecords c){
	 srd.add(c.getS_center(), c.getS_cost(), c.getS_type(), c.getReg_no(), c.getDate());
	  
	  return new ModelAndView("redirect:/recorder/service/list");
	 }
	 
	 //Update
	 
	    @RequestMapping(value="/attendance/update/{emp_id}/{date}",method = RequestMethod.GET)  
	    public ModelAndView editAt(@PathVariable int emp_id, @PathVariable String date){  
	        Attendance p = new Attendance();
	        p.setEmp_id(emp_id);
	        p.setDate(date);
	        ModelAndView m1 = new ModelAndView("/attendance/update");
	        m1.addObject("atuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/attendance/update",method = RequestMethod.POST)  
	    public ModelAndView editser(@ModelAttribute("atuForm") Attendance a){  
	        atd.update(a);
	        return new ModelAndView("redirect:/recorder/attendance/list"); 
	    }  
	    
	    //CarDocs Update
	    @RequestMapping(value="/cardocs/update/{registration_no}",method = RequestMethod.GET)  
	    public ModelAndView editcdu(@PathVariable String registration_no){  
	        CarDocs p = new CarDocs();
	        p.setRegistration_no(registration_no);
	        ModelAndView m1 = new ModelAndView("/cardocs/update");
	        m1.addObject("cduForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/cardocs/update",method = RequestMethod.POST)  
	    public ModelAndView editcdup(@ModelAttribute("cduForm")CarDocs a){  
	        cdd.update(a);
	        return new ModelAndView("redirect:/recorder/cardocs/list"); 
	    }  
	    
	    @RequestMapping(value="/carins/update/{i_no}",method = RequestMethod.GET)  
	    public ModelAndView editciu(@PathVariable String i_no){  
	        CarInsurances p = new CarInsurances();
	        p.setI_no(i_no);
	        ModelAndView m1 = new ModelAndView("/carins/update");
	        m1.addObject("ciuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/carins/update",method = RequestMethod.POST)  
	    public ModelAndView editciup(@ModelAttribute("cduForm")CarInsurances a){  
	        cid.update(a);
	        return new ModelAndView("redirect:/recorder/carins/list"); 
	    }  
	    
	    @RequestMapping(value="/cars/update/{registration_no}",method = RequestMethod.GET)  
	    public ModelAndView editcu(@PathVariable String registration_no){  
	        Cars p = new Cars();
	        p.setRegistration_no(registration_no);
	        ModelAndView m1 = new ModelAndView("/cars/update");
	        m1.addObject("cuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/cars/update",method = RequestMethod.POST)  
	    public ModelAndView editcup(@ModelAttribute("cuForm")Cars a){  
	        cd.update(a);
	        return new ModelAndView("redirect:/recorder/cars/list"); 
	    } 
	    
	    @RequestMapping(value="/contacts/update/{contact_no}",method = RequestMethod.GET)  
	    public ModelAndView editconu(@PathVariable String contact_no){  
	        EmergencyContacts p = new EmergencyContacts();
	        p.setContact_no(contact_no);
	        ModelAndView m1 = new ModelAndView("/contacts/update");
	        m1.addObject("conuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/contacts/update",method = RequestMethod.POST)  
	    public ModelAndView editconup(@ModelAttribute("conuForm")EmergencyContacts a){  
	        ecd.update(a);
	        return new ModelAndView("redirect:/recorder/contacts/list"); 
	    } 
	    
	    @RequestMapping(value="/einsurance/update/{contact_no}",method = RequestMethod.GET)  
	    public ModelAndView editeiu(@PathVariable Integer ins_no){  
	        EmployeeInsurance p = new EmployeeInsurance();
	        p.setIns_no(ins_no);
	        ModelAndView m1 = new ModelAndView("/einsurance/update");
	        m1.addObject("eiuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/einsurance/update",method = RequestMethod.POST)  
	    public ModelAndView editeiup(@ModelAttribute("eiuForm")EmployeeInsurance a){  
	        eid.update(a);
	        return new ModelAndView("redirect:/recorder/einsurance/list"); 
	    }
	    
	    @RequestMapping(value="/fines/update/{fine_id}",method = RequestMethod.GET)  
	    public ModelAndView editf(@PathVariable Integer fine_id){  
	        Fines p = new Fines();
	        p.setFine_id(fine_id);
	        ModelAndView m1 = new ModelAndView("/fines/update");
	        m1.addObject("fuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/fines/update",method = RequestMethod.POST)  
	    public ModelAndView editfup(@ModelAttribute("fuForm")Fines a){  
	        fd.update(a);
	        return new ModelAndView("redirect:/recorder/fines/list"); 
	    }
	    
	    @RequestMapping(value="/isp/update/{p_no}",method = RequestMethod.GET)  
	    public ModelAndView editisp(@PathVariable Integer p_no){  
	    	InterStatePermissions p = new InterStatePermissions();
	        p.setP_no(p_no);
	        ModelAndView m1 = new ModelAndView("/isp/update");
	        m1.addObject("ispuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/isp/update",method = RequestMethod.POST)  
	    public ModelAndView editispp(@ModelAttribute("ispuForm")InterStatePermissions a){  
	        ispd.update(a);
	        return new ModelAndView("redirect:/recorder/isp/list"); 
	    }
	    
	    @RequestMapping(value="/employee/update/{e_id}",method = RequestMethod.GET)  
	    public ModelAndView editemp(@PathVariable Integer e_id){  
	    	Employee p = new Employee();
	        p.setE_id(e_id);
	        ModelAndView m1 = new ModelAndView("/employee/update");
	        m1.addObject("empuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/employee/update",method = RequestMethod.POST)  
	    public ModelAndView editempp(@ModelAttribute("empuForm")Employee a){  
	        ed.update(a);
	        return new ModelAndView("redirect:/recorder/employee/list"); 
	    }
	    
	    @RequestMapping(value="/net/update/{date}",method = RequestMethod.GET)  
	    public ModelAndView editnet(@PathVariable String date){  
	    	NetGains p =new NetGains();
	        p.setDate(date);
	        ModelAndView m1 = new ModelAndView("/net/update");
	        m1.addObject("nuForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/net/update",method = RequestMethod.POST)  
	    public ModelAndView editnetp(@ModelAttribute("nuForm")NetGains a){  
	        ngd.update(a);
	        return new ModelAndView("redirect:/recorder/net/list"); 
	    }
	    
	    @RequestMapping(value="/salary/update/{sal_id}",method = RequestMethod.GET)  
	    public ModelAndView editsal(@PathVariable Integer sal_id){  
	    	MonthlySalary p =new MonthlySalary();
	        p.setSal_id(sal_id);
	        ModelAndView m1 = new ModelAndView("/salary/update");
	        m1.addObject("saluForm",p);
	        return m1;
	    }   
	    
	    @RequestMapping(value="/salary/update",method = RequestMethod.POST)  
	    public ModelAndView editsalp(@ModelAttribute("saluForm")MonthlySalary a){  
	        msd.update(a);
	        return new ModelAndView("redirect:/recorder/salary/list"); 
	    }
	      
	      
	 
	    
	    @RequestMapping(value="/service/update/{ser_id}",method = RequestMethod.GET)  
	    public ModelAndView edit(@PathVariable int ser_id){  
	        ServiceRecords s =new ServiceRecords();
	        s.setSer_id(ser_id);
	        ModelAndView m1 = new ModelAndView("/service/update");
	        m1.addObject("seruForm",s);
	        return m1;

	    }   
	    
	    @RequestMapping(value="/service/update",method = RequestMethod.POST)  
	    public ModelAndView editser(@ModelAttribute("seruForm") ServiceRecords s){  
	        srd.update(s);
	        return new ModelAndView("redirect:/recorder/service/list"); //will redirect to viewemp request mapping  
	    }  

		 
		 @PostMapping("/update")
		 public  ModelAndView update(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("newp") String newp)     
		 {
		  //ModelAndView model = new ModelAndView("user/user_page");

		  userService.update(newp,username,password);
		  return new ModelAndView("redirect:/user/list");
		 }
		 
		 @RequestMapping("/update/{id}")
		 public ModelAndView password_change(@PathVariable int id, Model m) {
			 m.addAttribute("id",id);
			 return new ModelAndView("/user/user_update");
		 }


			
	    

	 
	 
	 
//        ServiceRecords p=new ServiceRecords();
//        Payments temp = pd.getPaymentByPID(payment_id);
	 
	 
	 
	 

	
}
