package krishna.dao;

import krishna.dto.Student;

public interface IStudentDao {

	public String save(String sname, Integer sage, String saddress);

	public Student findById(Integer sid);

	public String updateStudent(Student student);

	public String delete(Integer sid);

	
}
