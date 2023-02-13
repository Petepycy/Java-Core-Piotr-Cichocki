package contacts;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class PhoneBook {
    private static final Scanner scanner = new Scanner(System.in);
    List<Contact> contacts;
    private final ContactFactory contactFactory = new ContactFactory();
    private final Set<String> personFields = new HashSet<>(Arrays.asList("name", "surname", "birth", "gender", "number"));
    private final Set<String> orgFields = new HashSet<>(Arrays.asList("address", "number"));

    public PhoneBook() {
        if (SerializationUtils.isExist()) {
            try {
                contacts = (List<Contact>) SerializationUtils.deserialize();
            } catch (IOException | ClassNotFoundException e) {
                this.contacts = new ArrayList<>();
            }
            return;
        }
        this.contacts = new ArrayList<>();
    }

    public void addContact() {
        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();
        contacts.add(contactFactory.createContact(type));
        System.out.println("The record added.\n");
        save();
    }

    public void remove(int i) {
        if (count() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        contacts.remove(i - 1);
        System.out.println("The record removed!\n");
        save();
    }

    public void edit(int i) {
        if (count() == 0) {
            System.out.println("No records to edit!\n");
            return;
        }
        Contact contact = contacts.get(i - 1);
        if (contact instanceof Person) {
            editPerson((Person) contact);
        }
        else if (contact instanceof Organization) {
            editOrganization((Organization) contact);
        }

        contact.setLastEdit(LocalDateTime.now());
        save();

    }

    private void editPerson(Person contact) {
        String field = getPersonFieldName();
        System.out.printf("Enter %s: ", field);
        String value = scanner.nextLine();
        switch (field) {
            case "name" -> contact.setName(value);
            case "surname" -> contact.setSurname(value);
            case "birth" -> contact.setBirthDate(Person.isCorrectBirthDate(value));
            case "gender" -> contact.setGender(Person.isCorrectGender(value) ? value : null);
            case "number" -> contact.setNumber(Contact.isCorrectNumber(value) ? value : null);
        }
    }

    private void editOrganization(Organization contact) {
        String field = getOrganizationFieldName();
        System.out.printf("Enter %s: ", field);
        String value = scanner.nextLine();
        switch (field) {
            case "address" -> contact.setAddress(value);
            case "number" -> contact.setNumber(Contact.isCorrectNumber(value) ? value : null);
        }
    }

    public int count() {
        return contacts.size();
    }

    public void printCount() {
        System.out.printf("The Phone Book has %d records.%n", count());
    }

    public void info(int i) {
        if (count() == 0) {
            System.out.println("No records to show info!\n");
            return;
        }
        //i = getRecordNumber("Enter index to show info: ");
        System.out.println(contacts.get(i - 1).info());
    }

    public void printList() {
        IntStream.range(0, contacts.size())
                .forEach(i -> System.out.println(i + 1 + ". " + contacts.get(i).toString()));
    }

    private int getRecordNumber(String msg) {
        printList();
        System.out.print(msg);
        int i = 0;
        do {
            try {
                i = Integer.parseInt(scanner.next());
                if (i < 1 || i > count()) throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Please, enter correct number!");
            }
        } while (i == 0);
        return i;
    }

    private String getPersonFieldName() {
        while (true) {
            System.out.print("Select a field (name, surname, birth, gender, number): ");
            String field = scanner.nextLine().toLowerCase();
            if (personFields.contains(field)) return field;
            System.out.println("Incorrect field. Try again.");
        }
    }

    private String getOrganizationFieldName() {
        while (true) {
            System.out.print("Select a field (address, number): ");
            String field = scanner.nextLine().toLowerCase();
            if (orgFields.contains(field)) return field;
            System.out.println("Incorrect field. Try again.");
        }
    }

    public void search() {
        System.out.print("Enter search query: ");
        String searchQuery = scanner.nextLine().toLowerCase();
        int z = 0;
        int i = 0;
        int j = 1;
        for (var contact : contacts) {
            if (contact.toString().toLowerCase().contains(searchQuery) || contact.getNumber().contains(searchQuery)) {
                z++;
            }
        }
        System.out.printf("Found %d results: %n", z);
        for (var contact : contacts) {
            if (contact.toString().toLowerCase().contains(searchQuery) || contact.getNumber().contains(searchQuery)) {
                System.out.println(j + ". " + contact);
                j++;
            }
        }
        System.out.println();
        System.out.print("[search] Enter action ([number], back, again):");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("back")) {
            return;
        } else if (choice.equals("again")) {
            search();
            System.out.println();
        } else {
            try {
                i = Integer.parseInt(choice);
                if (i < 1 || i > count()) throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Please, enter correct number!");
            }
            info(i);
            //System.out.println();
            record(i);
        }
    }

    public void record(int i) {
        System.out.print("[record] Enter action (edit, delete, menu):");
        String action = scanner.nextLine().toLowerCase();
        switch (action) {
            case "edit" -> {
                edit(i);
                info(i);
                record(i);
            }
            case "delete" -> {
                remove(i);
                record(i);
            }
            case "menu" -> System.out.println();
        }
    }

    public void list() {
        printList();
        System.out.println();
        System.out.print("[list] Enter action ([number], back):");
        String action = scanner.nextLine().toLowerCase();
        int i = 0;
        if (action.equals("back")) {
            return;
        } else {
            try {
                i = Integer.parseInt(action);
                if (i < 1 || i > count()) throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Please, enter correct number!");
            }
            info(i);
            record(i);
        }
    }

    private void save() {
        if (SerializationUtils.isExist()){
            try {
                SerializationUtils.serialize(contacts);
            } catch (Exception e) {
                System.out.println("Err while saving");
                e.printStackTrace();
            }
        }
        System.out.println("Saved");
    }
}