// inheritance + encapsulation + composition + array example 
import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    private String title;
    private String author;
    private int itemId;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    abstract public void display();
}

class Book extends LibraryItem {
    private String ISBN;

    public Book(int itemId, String title, String author, String ISBN) {
        super(itemId, title, author);
        this.ISBN = ISBN;
    }

    @Override
    public void display() {
        System.out.println("Book ID: " + getItemId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + ISBN);
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(int itemId, String title, String author, int issueNumber) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public void display() {
        System.out.println("Magazine ID: " + getItemId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Issue: " + issueNumber);
    }
}

class Loan {
    private LibraryItem item;
    private LocalDate dueDate;
    private boolean isReturned;

    public Loan(LibraryItem item, LocalDate dueDate) {
        this.item = item;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public void markAsReturned() {
        this.isReturned = true;
    }

    public boolean isOverdue(LocalDate checkDate) {
        return checkDate.isAfter(dueDate) && !isReturned;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void display() {
        item.display();
        System.out.println("Due Date: " + dueDate + ", Returned: " + (isReturned ? "Yes" : "No"));
    }
}

class Library {
    private LibraryItem[] items;
    private Loan[] loans;
    private int nextItemId;
    private int itemsCount;
    private int loansCount;

    public Library() {
        items = new LibraryItem[10]; // initial size
        loans = new Loan[10]; // initial size
        nextItemId = 1;
        itemsCount = 0;
        loansCount = 0;
    }

    private void resizeItemsArrayIfNeeded() {
        if (itemsCount >= items.length) {
            LibraryItem[] newItems = new LibraryItem[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
    }

    private void resizeLoansArrayIfNeeded() {
        if (loansCount >= loans.length) {
            Loan[] newLoans = new Loan[loans.length * 2];
            System.arraycopy(loans, 0, newLoans, 0, loans.length);
            loans = newLoans;
        }
    }

    public void addLibraryItem(LibraryItem item) {
        resizeItemsArrayIfNeeded();
        items[itemsCount++] = item;
    }

    public LibraryItem getLibraryItem(int itemId) {
        for (int i = 0; i < itemsCount; i++) {
            if (items[i].getItemId() == itemId) {
                return items[i];
            }
        }
        return null;
    }

    public void loanItem(int itemId, LocalDate dueDate) {
        LibraryItem item = getLibraryItem(itemId);
        if (item != null) {
            resizeLoansArrayIfNeeded();
            loans[loansCount++] = new Loan(item, dueDate);
            System.out.println("Item loaned successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public void returnItem(int itemId) {
        for (int i = 0; i < loansCount; i++) {
            if (loans[i].getItem().getItemId() == itemId && !loans[i].isOverdue(LocalDate.now())) {
                loans[i].markAsReturned();
                System.out.println("Item returned successfully.");
                return;
            }
        }
        System.out.println("Item not found or already overdue.");
    }

    public void listLibraryItems() {
        for (int i = 0; i < itemsCount; i++) {
            items[i].display();
        }
    }

    public void listLoans() {
        for (int i = 0; i < loansCount; i++) {
            loans[i].display();
        }
    }

    public int generateItemId() {
        return nextItemId++;
    }
}

public class LibrarySystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Loan Item");
            System.out.println("4. Return Item");
            System.out.println("5. List All Items");
            System.out.println("6. List All Loans");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMagazine();
                    break;
                case 3:
                    loanItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    listItems();
                    break;
                case 6:
                    listLoans();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select 1-7.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();
        Book book = new Book(library.generateItemId(), title, author, ISBN);
        library.addLibraryItem(book);
        System.out.println("Book added successfully.");
    }

    private static void addMagazine() {
        System.out.print("Enter magazine title: ");
        String title = scanner.nextLine();
        System.out.print("Enter magazine author: ");
        String author = scanner.nextLine();
        System.out.print("Enter issue number: ");
        int issueNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Magazine magazine = new Magazine(library.generateItemId(), title, author, issueNumber);
        library.addLibraryItem(magazine);
        System.out.println("Magazine added successfully.");
    }

    private static void loanItem() {
        System.out.print("Enter item ID to loan: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        library.loanItem(itemId, LocalDate.now().plusWeeks(2)); // Assume 2 weeks loan period
        System.out.println("Loan processed.");
    }

    private static void returnItem() {
        System.out.print("Enter item ID to return: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        library.returnItem(itemId);
    }

    private static void listItems() {
        library.listLibraryItems();
    }

    private static void listLoans() {
        library.listLoans();
    }
}
