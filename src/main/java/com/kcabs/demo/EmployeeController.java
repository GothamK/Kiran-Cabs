package com.kcabs.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kcabs.dao.EmployeeDao;
import com.kcabs.dao.UserDao;
import com.kcabs.model.Employee;
import com.kcabs.model.User;

@RestController
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	UserDao userdao;


	@RequestMapping(value = "/update/{e_id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("e_id") Integer e_id) {
		ModelAndView model = new ModelAndView("employee/update");

		Employee emp = employeeDao.getEmpById(e_id);
		model.addObject("empForm", emp);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("eForm") Employee employee) {
		employeeDao.add(employee);
		return new ModelAndView("redirect:/recorder/employee/list");
	}

	@RequestMapping(value = "/delete/{e_id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("e_id") Integer e_id) {
		employeeDao.delete(e_id);

		return new ModelAndView("redirect:/recorder/employee/list");
	}

}
