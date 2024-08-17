package employeedata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.Query;
import employeedata.dto.Employee;


@Component
public class EmployeeDao {
	
	@Autowired
	EntityManager em;

	public Employee saveEmployee(Employee emp) {
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}
	
	public Employee findEmployee(int empId) {
		Employee emp = em.find(Employee.class, empId);
		if(emp!=null) {
			return emp;
		}
		else {
			return null;
		}
	}
	
	public Employee deleteEmployee(int empId) {
		Employee emp = em.find(Employee.class, empId);
		if(emp!=null) {
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
			return emp;
		}
		else {
			return null;
		}
	}
	
	public Employee updateEmployee(Employee emp, int empId) {
		Employee dbemployee = em.find(Employee.class, empId);
		if(dbemployee!=null) {
			emp.setEmployeeId(empId);
			em.getTransaction().begin();
			em.merge(emp);
			em.getTransaction().commit();
			return emp;
		}
		return null;
	}
	
	public List<Employee> getAllEmployees(){
		Query query = em.createQuery("select emp from Employee emp");
		List<Employee> employees = query.getResultList();
		if(!employees.isEmpty()) {
			return employees;
		}
		else {
			return null;
		}
	}
	
	public Employee findByEmail(String empEmail) {
		Query query = em.createQuery("select emp from Employee emp where EmployeeEmail=?1");
		query.setParameter(1, empEmail);
		Employee emp = (Employee)query.getSingleResult();
		return emp;
	}
}
