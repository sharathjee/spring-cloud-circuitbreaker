package com.discover;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import java.io.StringWriter;

public class JaxMarshallerDemo
{
    public static void main(String args[]){
        Employee employee = new Employee(1, "Lokesh", "Gupta", new Department(101, "IT"));

        jaxbObjectToJSON(employee);
    }

    private static void jaxbObjectToJSON(Employee employee)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // To format JSON
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Set JSON type
            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            //Print JSON String to Console
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(employee, sw);
            System.out.println(sw.toString());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
