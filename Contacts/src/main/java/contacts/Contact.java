package contacts;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Contact {

    @Serial
    private static final long serialVersionUID = 1L;
    protected String number;
    protected LocalDateTime created;
    protected LocalDateTime lastEdit;

    protected Contact(String number) {
        this.number = number;
        this.created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.lastEdit = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean hasNumber() {
        return number != null;
    }

    public String info() {
        return "Number: " + number + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + lastEdit + "\n";
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public static boolean isCorrectNumber(String number) {
        Pattern pattern = Pattern.compile("\\+?(\\(\\w+\\)|\\w+[ -](\\(\\w{2,}\\))|\\w+)([ -]\\w{2,})*");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) System.out.println("Wrong number format!");
        return matcher.matches();
    }

    @Override
    public String toString() {
        return hasNumber() ? number : "[no number]";
    }
}