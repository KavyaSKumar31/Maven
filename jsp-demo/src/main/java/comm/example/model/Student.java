package comm.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
	private String fName;
	private String lName;
	private String subject;
	private int age;
	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", subject=" + subject + ", age=" + age + "]";
	}
	
	

}
