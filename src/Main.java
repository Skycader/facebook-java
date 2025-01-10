import java.io.IOException;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Facebook facebook = new Facebook();

        boolean run = true;
        while(run) {
            System.out.println(":: Facebook App v0.0.1 by Skycader");
            System.out.println(":: Type help for actions");
            System.out.println(":: My contacts");
            facebook.printContacts();
            System.out.println(":: > ");

            String line = scanner.nextLine();
            String command = line.split("\\s")[0];
            String data = line.contains(" ") ? line.substring(line.indexOf(" ") + 1) : "";
            String name = "";
            String phone = "";
            switch(command) {
                case "help":
                    System.out.println(":: Commands");
                    System.out.println(":: add <name> <phone number> - add contact");
                    System.out.println(":: edit <name> <phone number> - edit contact");
                    System.out.println(":: rem <name> - remove contact");
                    System.out.println(":: get <name> - get a phone number by name ");
                    System.out.println(":: exit - quit the app");
                    System.out.println(":: Press <Enter> to continue");
                    scanner.nextLine();
                    break;
                case "add":
                    name = data.split("\\s")[0];
                    phone = data.split("\\s")[1];
                    facebook.addContact(name,phone);
                    break;
                case "edit":
                    try {
                        name = data.split("\\s")[0];
                        phone = data.split("\\s")[1];
                        facebook.editContact(name,phone);
                    } catch(Exception e) {
                        System.out.println(":: Failed to edit contact");
                        System.out.println(":: Press <Enter to continue>");
                        scanner.nextLine();
                    }
                    break;
                case "get":
                    name = data.split("\\s")[0];
                    phone = facebook.getContact(name);
                    System.out.println(":: " + name + " => " + phone);
                    System.out.println(":: Press <Enter> to continue");
                    scanner.nextLine();
                    break;
                case "rem":
                    try {
                        name = data.split("\\s")[0];
                        facebook.removeContact(name);
                    } catch (Exception e) {
                        System.out.println(":: Failed to remove todo");
                        System.out.println(":: Press <Enter> to continue");
                        scanner.nextLine();
                    }
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println(":: Unknown command");
                    System.out.println(":: Press <Enter> to continue");
                    scanner.nextLine();
                    break;
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

        }


    }
}