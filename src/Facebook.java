import java.util.HashMap;

public class Facebook {
    private final HashMap<String, String> contacts = new HashMap<String,String>();

    public void addContact(String name, String phoneNumber) {
        this.contacts.put(name,phoneNumber);
    }

    public void editContact(String name, String phoneNumber) {
        this.contacts.put(name,phoneNumber);
    }

    public String getContact(String name) {
        return this.contacts.get(name);
    }

    public void removeContact(String name) {
        this.contacts.remove(name);
    }

    public void printContacts() {
       for (String key : contacts.keySet()) {
           System.out.println(key + " => " + contacts.get(key));
       }
    }
}