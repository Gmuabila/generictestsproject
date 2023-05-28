package genericclasses.SpringIoc;


import genericclasses.SpringIoc.generic.Address;
import genericclasses.SpringIoc.generic.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Inversion of Control
//Simply put,Inversion of Control (IoC) is a process in which an object defines its dependencies without creating them.
// This object delegates the job of constructing such dependencies to an IoC container.

//Instead of constructing dependencies by itself, an object can retrieve its dependencies from an IoC container.
// All we need to do is provide the container with appropriate configuration metadata.

// Here's a configuration class supplying bean metadata to an IoC container:
    @Configuration
    @ComponentScan(basePackageClasses = Company.class)
    public class Config {
        @Bean
        public Address getAddress() {
            return new Address("High Street", 1000);
        }
}
//The configuration class produces a bean of type Address. It also carries the @ComponentScan annotation,
// which instructs the container to look for beans in the package containing the Company class.
// When a Spring IoC container constructs objects of those types, all the objects are called Spring beans,
// as they are managed by the IoC container.
