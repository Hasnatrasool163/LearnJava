package Payroll;

public class PayrollSystemTest {
    public static void main(String[] args) {
        // Current month for bonus calculation
        int currentMonth;

        // Initialize employee array with various employee types
        Employees[] employees = {
                new Salaried_Employee("Kamran", "Ahmad", "111-11-1111", new Date(15, 4, 1990), 10000),
                new Hourly_Employee("Jamal", "Ahmad", "222-22-2222", new Date(29, 10, 1985), 500, 40),
                new Commission_Employee("Sarfraz", "Ahmad", "333-33-3333", new Date(8, 6, 1964), 1000, .6),
                new PieceWorker("Ahmad", "Adnan", "555-55-5555", new Date(25, 4, 1988), 100, 1200)
        };

        java.util.Calendar currentCalendar = java.util.Calendar.getInstance();
        currentMonth = currentCalendar.get(java.util.Calendar.MONTH) + 1;

        for (Employees currentEmployee : employees) {
            System.out.println(currentEmployee); // calls toString

            // Check if this is the birth month
            if (currentEmployee.getBirthDate().getMonth() == currentMonth) {
                double earnings = currentEmployee.earnings() + 100.0;
                System.out.printf("earned $%,.2f\n\n", earnings);
            } else {
                System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings());
            }
        }
    }
}
