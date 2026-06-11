// Interface
interface NotificationService {
    void sendMessage();
}

// Email Notification Implementation
class EmailNotification implements NotificationService {
    @Override
    public void sendMessage() {
        System.out.println("Email Notification Sent");
    }
}

// SMS Notification Implementation
class SMSNotification implements NotificationService {
    @Override
    public void sendMessage() {
        System.out.println("SMS Notification Sent");
    }
}

// Order Service Class
class OrderService {
    private NotificationService notificationService;

    // Constructor Injection
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Order Confirmed");
        notificationService.sendMessage();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Inject Email Notification
        NotificationService email = new EmailNotification();
        OrderService order1 = new OrderService(email);
        order1.placeOrder();

        System.out.println();

        // Inject SMS Notification
        NotificationService sms = new SMSNotification();
        OrderService order2 = new OrderService(sms);
        order2.placeOrder();
    }
}/*
Create:

Interface
NotificationService

Method:

sendMessage()

Implement:

EmailNotification
SMSNotification

Create:

OrderService
Requirements

Inject notification service using:

Constructor Injection
When order is placed:

Order Confirmed
Notification Sent
Concepts Tested
Dependency Injection
Interface
Loose Coupling

Instructions -
Create Interface NotificationService

    Method:
        sendMessage()


Create Class EmailNotification

    Implement NotificationService

    Override sendMessage()

        Print:
            "Email Notification Sent"


Create Class SMSNotification

    Implement NotificationService

    Override sendMessage()

        Print:
            "SMS Notification Sent"


Create Class OrderService

    Variable:
        NotificationService notificationService

    Constructor(NotificationService notificationService)

        this.notificationService = notificationService

    Method placeOrder()

        Print:
            "Order Confirmed"

        notificationService.sendMessage()


Main Method

    Create EmailNotification object

    Create OrderService object
    Inject EmailNotification through constructor

    Call placeOrder()


    Create SMSNotification object

    Create OrderService object
    Inject SMSNotification through constructor

    Call placeOrder()

*/
