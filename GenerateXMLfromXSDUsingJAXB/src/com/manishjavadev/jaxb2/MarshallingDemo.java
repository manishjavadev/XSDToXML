package com.manishjavadev.jaxb2;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

public class MarshallingDemo {
	public static void main(String[] args) {
		try {
			//Address object with proper information
			Address address = new Address();
			address.setState("Karnatka");
			address.setCity("BLR");
			address.setArea("BTM");
			address.setPin(560068);
			
			// 1 Student object created here
			Student student1 = new Student();
			student1.setSid(101);
			student1.setFistName("Rakesh");
			student1.setLastName("Ray");
			student1.setEmail("rakesh@javadev.com");
			student1.setAddress(address);

			// 2nd Student Object created here
			Student student2 = new Student();
			student2.setSid(102);
			student2.setFistName("Sukesh");
			student2.setLastName("Kumar");
			student2.setEmail("sukesh@javadev.com");
			student2.setAddress(address);

			// Object factory is a class generated by xjc command 
			// with this ObjectFactory we will get our top most class
			// see below factory.createStudents(); returning Students Object
			ObjectFactory factory = new ObjectFactory();
			Students students = factory.createStudents();
			students.getStudent().add(student1);
			students.getStudent().add(student2);
			
			//JaxBContext object created here by passing contextRoot
			JAXBContext jaxbContext = JAXBContext
					.newInstance("com.manishjavadev.jaxb2");
			
			
			// Here we are getting JAXBElement<Students> studentsJAXBObj by passing 
			// students object which is created before
			JAXBElement<Students> studentsJAXBObj = factory.createStudents(students);
			
			// Creating Marshaller Object
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			// Setting xml should be formated
			marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
			
			// Finally creating XML using marshal(..) which will take 2 args
			// First JAXBElement<Students> object and filename for xml
			marshaller.marshal(studentsJAXBObj, new FileOutputStream("src/student.xml"));

			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
