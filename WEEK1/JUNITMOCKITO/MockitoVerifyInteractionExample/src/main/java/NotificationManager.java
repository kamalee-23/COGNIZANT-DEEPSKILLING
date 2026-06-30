public class NotificationManager {

    private NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {

        this.notificationService = notificationService;

    }

    public void notifyUser() {

        notificationService.sendNotification("Order Confirmed");

    }

}