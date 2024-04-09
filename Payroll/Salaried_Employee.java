package Payroll;

class Salaried_Employee extends Employees {
    private double weeklySalary;

    // Constructor
    public Salaried_Employee(String firstName, String lastName, String ssn, Date birthDate, double weeklySalary) {
        super(firstName, lastName, ssn, birthDate);
        this.weeklySalary = weeklySalary;
    }

    // Set weekly salary
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    // Return weekly salary
    public double getWeeklySalary() {
        return weeklySalary;
    }

    //  override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    // to string method
    @Override
    public String toString() {
        return String.format("salaried employee: %s\n%s: $%,.2f",
                super.toString(), "weekly salary", getWeeklySalary());
    }
}