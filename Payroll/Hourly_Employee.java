package Payroll;

class Hourly_Employee extends Employees {
    private double wage; // wage per hour
    private double hours; // hours worked for week

    // Constructor
    public Hourly_Employee(String firstName, String lastName, String ssn, Date birthDate, double wage, double hours) {
        super(firstName, lastName, ssn, birthDate);
        this.wage = wage;
        this.hours = hours;
    }

    // Set wage
    public void setWage(double wage) {
        this.wage = wage;
    }

    // Return wage
    public double getWage() {
        return wage;
    }

    // Set hours worked
    public void setHours(double hours) {
        this.hours = hours;
    }

    // Return hours worked
    public double getHours() {
        return hours;
    }

    //  override abstract method earnings in Employee
    @Override
    public double earnings() {
        if (getHours() <= 40) { // no overtime
            return getWage() * getHours();
        } else {
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
    }

    // to string method
    @Override
    public String toString() {
        return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
                super.toString(), "hourly wage", getWage(), "hours worked", getHours());
    }
}