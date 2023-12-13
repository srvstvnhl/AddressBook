import java.util.List;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        AddressBook addressBook = new AddressBook();
//
//        // Adding contacts
//        addressBook.addContact(new Contact("John", "Doe", "123 Main St", "1234567890"));
//        addressBook.addContact(new Contact("John", "Boe", "1234 Main St", "1354567890"));
//        addressBook.addContact(new Contact("Jane", "Smith", "456 Elm St", "9876543210"));
//        addressBook.addContact(new Contact("Alice", "Johnson", "789 Oak St", "1112223334"));
//
//        // Searching by name
//        List<Contact> searchResultByName = addressBook.searchByName("Jo");
//        System.out.println("SEARCHED BY NAME: ");
//        addressBook.printContacts(searchResultByName);
//
//        // Searching by phone number
//        List<Contact> searchResultByPhone = addressBook.searchByPhoneNumber("1");
//        System.out.println("SEARCHED BY Phone Number: ");
//        addressBook.printContacts(searchResultByPhone);
//    }



//    NOTE: If need to use it as CLI- Application. Please use this main. Above one was for Mock Data, this one is for CLI.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to the Address Book CLI!");

        boolean running = true;
        while (running) {
            System.out.println("\nEnter a command (add, search name, search number, exit):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();

                    addressBook.addContact(new Contact(firstName, lastName, address, phoneNumber));
                    System.out.println("Contact added successfully!");
                    break;

                case "search name":
                    System.out.println("Enter name to search:");
                    String nameQuery = scanner.nextLine();
                    List<Contact> nameSearchResult = addressBook.searchByName(nameQuery);
                    addressBook.printContacts(nameSearchResult);
                    break;

                case "search number":
                    System.out.println("Enter phone number to search:");
                    String numberQuery = scanner.nextLine();
                    List<Contact> numberSearchResult = addressBook.searchByPhoneNumber(numberQuery);
                    addressBook.printContacts(numberSearchResult);
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command!");
            }
        }
    }

}
