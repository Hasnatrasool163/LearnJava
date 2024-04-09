package Payroll;

// Abstract Employee class
public abstract class Employees {

    String firstName;
    String lastName;
    String ssn;
    private Date birthDate;

    // Constructor
    public Employees(String firstName, String lastName, String ssn, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birthDate = birthDate;
    }
    // Return Date
    public Date getBirthDate() {
        return birthDate;
    }

    // Return first name
    public String getFirstName() {
        return firstName;
    }

    // Return last name
    public String getLastName() {
        return lastName;
    }

    // Return ssn
    public String getSocialSecurityNumber() {
        return ssn;
    }

    // Abstract method overridden by subclasses
    public abstract double earnings();

    // to string
    public String toString() {
        return String.format("%s %s\nsocial security number: %s\nbirth date: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
    }
}


