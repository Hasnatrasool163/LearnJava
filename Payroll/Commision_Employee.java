package Payroll;

class Commission_Employee extends Employees {
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    // Constructor
    public Commission_Employee(String firstName, String lastName, String ssn, Date birthDate, double grossSales, double commissionRate) {
        super(firstName, lastName, ssn, birthDate);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // Set gross sales
    public void setGrossSales(double sales) {
        this.grossSales = sales;
    }

    // Return gross sales
    public double getGrossSales() {
        return grossSales;
    }

    // Set commission rate
    public void setCommissionRate(double rate) {
        this.commissionRate = rate;
    }

    // Return commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    // to string method
    @Override
    public String toString() {
        return String.format("commission employee: %s\n%s: $%,.2f; %s: %.2f",
                super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
    }
}
