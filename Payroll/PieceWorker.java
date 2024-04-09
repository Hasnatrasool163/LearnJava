package Payroll;

class PieceWorker extends Employees {
    private double wage; // wage per piece
    private int pieces; // number of pieces produced

    // Constructor
    public PieceWorker(String firstName, String lastName, String ssn, Date birthDate, double wage, int pieces) {
        super(firstName, lastName, ssn, birthDate);
        this.wage = wage;
        this.pieces = pieces;
    }

    // Set wage
    public void setWage(double wage) {
        this.wage = wage;
    }

    // Return wage
    public double getWage() {
        return wage;
    }

    // Set pieces produced
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    // Return pieces produced
    public int getPieces() {
        return pieces;
    }

    //override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getWage() * getPieces();
    }

    // to string method
    @Override
    public String toString() {
        return String.format("piece worker: %s\n%s: $%,.2f; %s: %d",
                super.toString(), "wage per piece", getWage(), "pieces produced", getPieces());
    }
}
