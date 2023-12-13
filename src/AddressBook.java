import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
    Map<String, Contact> contactsByName;
    Map<String, Contact> contactsByPhoneNumber;
    Trie trieByName;
    Trie trieByPhone;

    public AddressBook() {
        contactsByName = new HashMap<>();
        contactsByPhoneNumber = new HashMap<>();
        trieByName = new Trie();
        trieByPhone = new Trie();
    }

    public void addContact(Contact contact) {
        if (!Validator.isValidContact(contact, contactsByPhoneNumber)) {
            System.out.println("Invalid contact details. Please provide all required information.");
            return;
        }

        String fullName = contact.firstName + " " + contact.lastName;
        contactsByName.put(fullName, contact);
        trieByName.insert(fullName);

        contactsByPhoneNumber.put(contact.phoneNumber, contact);
        trieByPhone.insert(contact.phoneNumber);
    }

    public List<Contact> searchByName(String name) {
        List<String> names = trieByName.search(name);
        return retrieveContacts(names, contactsByName);
    }

    public List<Contact> searchByPhoneNumber(String phoneNumber) {
        List<String> phoneNumbers = trieByPhone.search(phoneNumber);
        return retrieveContacts(phoneNumbers, contactsByPhoneNumber);
    }

    private List<Contact> retrieveContacts(List<String> keys, Map<String, Contact> contactsMap) {
        List<Contact> result = new ArrayList<>();
        for (String key : keys) {
            Contact contact = contactsMap.get(key);
            if (contact != null) {
                result.add(contact);
            }
        }
        return result;
    }

    public void printContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

//        System.out.println("Found " + contacts.size() + " contact(s):");
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.firstName + " " + contact.lastName +
                    ", Address: " + contact.address + ", Phone: " + contact.phoneNumber);
        }
    }
}