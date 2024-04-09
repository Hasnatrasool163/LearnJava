package Payroll;

class Base_Plus_Commission_Employee extends Commission_Employee {
    private double baseSalary; // base salary per week

    // Constructor
    public Base_Plus_Commission_Employee(String firstName, String lastName, String ssn, Date birthDate, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, ssn, birthDate, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    // Set base salary
    public void setBaseSalary(double salary) {
        this.baseSalary = salary;
    }

    // Return base salary
    public double getBaseSalary() {
        return baseSalary;
    }

    // override method earnings in CommissionEmployee
    @Override
    public double earnings() {
        return getBaseSalary() * 1.10 + super.earnings(); // Add 10% to base salary
    }

    // to string method
    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f",
                "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}
