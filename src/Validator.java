import java.util.Map;

class Validator {
    public static boolean isValidContact(Contact contact, Map<String, Contact> contactsByPhoneNumber) {
        return !contact.firstName.isEmpty() && !contact.lastName.isEmpty() &&
                !contact.address.isEmpty() && !contact.phoneNumber.isEmpty() &&
                isPhoneNumberValid(contact.phoneNumber) &&
                !isDuplicatePhoneNumber(contact.phoneNumber, contactsByPhoneNumber);
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }

    private static boolean isDuplicatePhoneNumber(String phoneNumber, Map<String, Contact> contactsByPhoneNumber) {
        return contactsByPhoneNumber.containsKey(phoneNumber);
    }
}
