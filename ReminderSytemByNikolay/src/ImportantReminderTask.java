import java.util.concurrent.TimeUnit;

public class ImportantReminderTask implements Runnable {
    private Reminder reminder;

    public ImportantReminderTask(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" You have a reminder " + reminder.getText());
            if (i == 0 || i == 1) {
                System.out.println(" You have an important message ");
            } else {
                System.out.println(" Second call , pay attention it is important");
            }
        }
    }
}