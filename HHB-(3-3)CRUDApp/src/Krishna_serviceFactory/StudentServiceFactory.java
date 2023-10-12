package Krishna_serviceFactory;

import krishna.service.IStudentservice;
import krishna.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private StudentServiceFactory() {

	}

	private static IStudentservice studentService = null;

	public static IStudentservice getStudentService() {
		
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}
