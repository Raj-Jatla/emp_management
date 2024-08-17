package employeedata.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmployeeId;
	private String EmployeeName;
	private String EmployeeEmail;
	private long EmployeeContact;
	private String EmployeePassword;
	
	public Employee() {
		
	}

	public Employee(String employeeName, String employeeEmail, long employeeContact ,String employeePassword) {
		EmployeeName = employeeName;
		EmployeeEmail = employeeEmail;
		EmployeeContact = employeeContact;
		EmployeePassword = employeePassword;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeEmail="
				+ EmployeeEmail + ", EmployeeContact=" + EmployeeContact + "]";
	}


	public int getEmployeeId() {
		return EmployeeId;
	}


	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}


	public String getEmployeeName() {
		return EmployeeName;
	}


	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}


	public String getEmployeeEmail() {
		return EmployeeEmail;
	}


	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}


	public long getEmployeeContact() {
		return EmployeeContact;
	}


	public void setEmployeeContact(long employeeContact) {
		EmployeeContact = employeeContact;
	}


	public String getEmployeePassword() {
		return EmployeePassword;
	}


	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}

}
