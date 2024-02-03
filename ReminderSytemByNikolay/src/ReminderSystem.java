import java.util.*;

public class ReminderSystem {
    private Set<Reminder> reminders;
    private ReminderTask reminderTask;

    public ReminderSystem() {
        reminders = new HashSet<>();
        this.reminderTask = new ReminderTask(reminders);
        Thread thread = new Thread(reminderTask);
        thread.setDaemon(true);
        thread.start();
    }

    public void menu() {
        System.out.println("""
                Welcome to reminderSystem, let's make some reminders\s
                Please choose from 3 options below\s
                Press 1 to make a new reminder\s
                Press 2 to show all reminders\s
                Press 3 to end a program \s""");
    }
    public void beginReminderSystem() {
        Scanner scanner = new Scanner(System.in);
        while (reminderTask.isWorking()) {
            menu();
            int choice;
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addNewReminder(scanReminder(scanner));
                case 2 -> showAllReminders();
                case 3 -> this.reminderTask.setWorking(false);
                default -> System.out.println("Dear client you have entered the wrong number,please try again");
            }
        }
    }

    private Reminder scanReminder(Scanner scanner) {
        System.out.println("Welcome to reminderSystem  ");
        System.out.println("Please enter the text of your task");
        String text = scanner.next();
        System.out.println("Please enter the year");
        int year = scanner.nextInt();
        System.out.println("Please enter number of the month");
        int month = scanner.nextInt() - 1;
        System.out.println("Please enter dayOfMonth ");
        int dayOfMonth = scanner.nextInt();
        System.out.println("Please enter hours of the day ");
        int hours = scanner.nextInt();
        System.out.println("Please enter the minutes");
        int minutes = scanner.nextInt();
        System.out.println("Please choose true or false if the reminder is important");
        boolean isImportant = scanner.nextBoolean();

        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date.set(Calendar.HOUR, hours);
        date.set(Calendar.MINUTE, minutes);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return new Reminder(date, text, isImportant, false);
    }

    public void addNewReminder(Reminder r) {
        reminders.add(r);
    }

    public void showAllReminders() {
        List<Reminder> sortedReminders = new ArrayList<>(reminders);
        Collections.sort(sortedReminders);
        for (Reminder reminder : sortedReminders) {
            System.out.println(reminder);
        }

    }

}

