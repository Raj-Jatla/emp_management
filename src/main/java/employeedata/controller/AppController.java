package employeedata.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import employeedata.dao.EmployeeDao;
import employeedata.dto.Employee;

@Controller
public class AppController {
	
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView modelandview  =  new ModelAndView();
		modelandview.setViewName("signup.jsp");
		modelandview.addObject("emp", new Employee());
		return modelandview;
	}
	
	@RequestMapping("/savemployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		dao.saveEmployee(emp);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email,@RequestParam String password,HttpServletRequest req) {
		Employee emp = dao.findByEmail(email);
		if(emp!=null) {
			if(emp.getEmployeePassword().equals(password)) {
				HttpSession session = req.getSession();
				return new ModelAndView("redirect:/home");
			}
			else {
				return new ModelAndView("login.jsp");
			}
		}
		else {
			return new ModelAndView("login.jsp");
		}
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelandview  =  new ModelAndView();
		modelandview.setViewName("addemployee.jsp");
		modelandview.addObject("emp", new Employee());
		return modelandview;
	}
	
	@RequestMapping("/addemployee")
	public ModelAndView addEmployee(@ModelAttribute Employee emp) {
		dao.saveEmployee(emp);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.getAllEmployees());
		return modelandview;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		dao.deleteEmployee(id);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.getAllEmployees());
		return modelandview;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editEmployee(@RequestParam int id) {
		Employee emp = dao.findEmployee(id);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("edit.jsp");
		modelandview.addObject("emp", emp);
		return modelandview;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateEmployee(@ModelAttribute Employee emp,@RequestParam int id) {
		dao.updateEmployee(emp, id);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.getAllEmployees());
		return modelandview;
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.getAllEmployees());
		return modelandview;
	}
	
}
