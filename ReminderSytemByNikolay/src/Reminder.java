import java.util.Calendar;
import java.util.Objects;

public class Reminder implements Comparable<Reminder> {
    private Calendar expiration;
    private String text;
    private boolean isImportant;
    private boolean isPopped;

    public Reminder(Calendar expiration, String text, boolean isImportant, boolean isPopped) {
        this.expiration = expiration;
        this.text = text;
        this.isImportant = isImportant;
        this.isPopped = isPopped;
    }

    public Calendar getExpiration() {
        return expiration;
    }
    public void setExpiration(Calendar expiration) {
        this.expiration = expiration;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean isImportant() {
        return isImportant;
    }
    public void setImportant(boolean important) {
        isImportant = important;
    }
    public boolean isPopped() {
        return isPopped;
    }
    public void setPopped(boolean popped) {
        isPopped = popped;
    }
    @Override
    public int compareTo(Reminder o) {
        return this.expiration.compareTo(o.expiration);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return expiration.equals(reminder.expiration) && text.equals(reminder.text);
    }
    @Override
    public int hashCode() {
        return Objects.hash(expiration, text);
    }
    @Override
    public String toString() {
        return "Reminder{" +
                "expiration=" + GetFormattedCalendarDate.beautifulDate(expiration) +
                ", text='" + text + '\'' +
                ", isImportant=" + isImportant +
                ", isPopped=" + isPopped +
                '}';
    }
}
