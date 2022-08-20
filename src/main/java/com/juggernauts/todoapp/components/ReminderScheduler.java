//package com.juggernauts.todoapp.components;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.juggernauts.todoapp.models.Reminder;
//import com.juggernauts.todoapp.models.Task;
//import com.juggernauts.todoapp.services.MailService;
//import com.juggernauts.todoapp.services.ReminderService;
//
///**
// * The component for scheduling reminder notifications
// * @author Jacob
// */
//@Component
//public class ReminderScheduler {
//    private static final Logger logger = LogManager.getLogger(ReminderScheduler.class);
//
//    @Autowired private ReminderService reminderService;
//    @Autowired private MailService mailService;
//
//    /**
//     * Schedules a reminder notifier under the given task
//     * The task will run every 10 seconds
//     */
//    @Scheduled(cron="*/10 * * * * *")
//    public void scheduleReminderNotifier() {
//        List<Reminder> outdatedReminders = reminderService.getAllOutdatedReminders();
//        if (outdatedReminders.isEmpty()) return;
//
//        logger.info("running scheduleReminderNotifier cron job");
//
//        List<Reminder> deleteReminders = new ArrayList<>();
//        Task reminderTask;
//        String to, subject, text;
//
//        for (Reminder reminder : outdatedReminders) {
//            reminderTask = reminder.getTask();
//
//            // send an email to the user to remind them of their task 😊
//            to = reminderTask.getUser().getEmail();
//            subject = "Your Habitu.al Task Reminder";
//            text = String.format("Your %s task is at %s.", reminderTask.getName(), reminderTask.getCompleteBy());
//            mailService.sendEmail(to, subject, text);
//
//            // if repeatEvery isn't null, then this is a repeatable reminder
//            if (reminder.getRepeatEvery() != null) {
//                // add the seconds to the remindBy date
//                // * must convert seconds to milliseconds
//                reminder.getRemindBy().setTime(reminder.getRemindBy().getTime() + reminder.getRepeatEvery() * 1000);
//
//                // this saves the reminder
//                reminderService.addReminder(reminder);
//            } else {
//                // queue reminder for later deletion since it's not repeatable
//                deleteReminders.add(reminder);
//            }
//
//            logger.info("reminded {} of {}", reminderTask.getUser().getEmail(), reminderTask.getName());
//        }
//
//        // delete all the non-repeatable outdated reminders
//        reminderService.deleteReminders(deleteReminders);
//        logger.info("deleted {} reminders", deleteReminders.size());
//    }
//}