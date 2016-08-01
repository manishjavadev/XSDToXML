package com.manishjavadev.jaxb2;

import java.io.FileInputStream;
import java.util.List;
import javax.xml.bind.*;

public class UNMarshallingDemo {
	public static void main(String[] args) {
		try {

			// JaxBContext object created here by passing contextRoot
			JAXBContext jaxbContext = JAXBContext
					.newInstance("com.manishjavadev.jaxb2");

			// Creating Unmarshaller Object
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			// Creating FileInputStream object
			FileInputStream fis = new FileInputStream("src/student.xml");

			// Finally reading XML using unmarshal(.) which will take 1 args
			// Which is nothing but FileInputStream object
			JAXBElement<Students> unmarshalledObject = (JAXBElement<Students>) unmarshaller
					.unmarshal(fis);

			// From unmarshalledObject.getValue(); we will get Student Object
			Students studentsObj = unmarshalledObject.getValue();
			List<Student> stuObj = (List<Student>) studentsObj.getStudent();

			// Displaying the record
			for (Student student : stuObj) {
				System.out.println(student);
			}
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
