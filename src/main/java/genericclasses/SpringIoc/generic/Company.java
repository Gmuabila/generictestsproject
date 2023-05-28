package genericclasses.SpringIoc.generic;

import org.springframework.stereotype.Component;

//@Component is an annotation that allows Spring to automatically detect our custom beans.
//In other words, without having to write any explicit code, Spring will:
// •	Scan our application for classes annotated with @Component
// •	Instantiate them and inject any specified dependencies into them
// •	Inject them wherever needed
//However, most developers prefer to use the more specialized stereotype annotations to serve this function.


@Component
public class Company {
    public Address address;

    public Company(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

//Instead of constructing dependencies by itself, an object can retrieve its dependencies from an IoC container.
// All we need to do is to provide the container with appropriate configuration metadata.
