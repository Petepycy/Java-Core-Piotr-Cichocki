package contacts;

import java.time.LocalDate;

public class Person extends Contact {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public Person(String number) {
        super(number);
    }

    public Person(String number, String name, String surname, LocalDate birthDate, String gender) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public static boolean isCorrectGender(String gender) {
        boolean isTrue = "M".equals(gender) || "F".equals(gender);
        if (!isTrue) System.out.println("Bad gender!");
        return isTrue;
    }

    public static LocalDate isCorrectBirthDate(String birthDate) {
        try {
            return LocalDate.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String info() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + (birthDate == null ? "[no data]": birthDate) + "\n" +
                "Gender: " + (gender == null ? "[no data]": gender) + "\n" +
                super.info();
    }


    @Override
    public String toString() {
        return name + " " + surname;
    }
}