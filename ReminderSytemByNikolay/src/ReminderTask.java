import java.util.Calendar;
import java.util.Set;

public class ReminderTask implements Runnable {
    private Set<Reminder> reminders;
    private boolean isWorking;

    public ReminderTask(Set<Reminder> reminders) {
        this.reminders = reminders;
        this.isWorking = true;
    }

    public Set<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(Set<Reminder> reminders) {
        this.reminders = reminders;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public void run() {
        while (isWorking) {
            Calendar now = Calendar.getInstance();
            for (Reminder reminder : reminders) {
                if (!reminder.isPopped()) {
                    if (reminder.getExpiration().before(now)) {
                        reminder.setPopped(true);
                        System.out.println("You have a new reminder " +reminder.getText()+GetFormattedCalendarDate.beautifulDate(reminder.getExpiration()));
                        if (reminder.isImportant()) {
                            new Thread(new ImportantReminderTask(reminder)).start();
                        } else {
                            reminder.setPopped(true);
                            System.out.printf("you have a reminder %s%s%n", reminder.getText(), GetFormattedCalendarDate.beautifulDate(reminder.getExpiration()));
                        }
                    }
                }

            }
        }
    }
}