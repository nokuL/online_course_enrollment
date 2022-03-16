package rc.course_enrollment.model.practice;

import java.util.List;

public class NewsLetterSEnder {
    private SubscriberDatabase subscriberDatabase;
    private MessagingEngine messagingEngine;

    public NewsLetterSEnder(SubscriberDatabase subscriberDatabase, MessagingEngine messagingEngine) {
        this.subscriberDatabase = subscriberDatabase;
        this.messagingEngine = messagingEngine;
    }

    public void sendNewsLetter(String subject){
        List<String> emails = subscriberDatabase.getSubscribers();
        if(emails.size() == 0){
            throw new RuntimeException();
        }
        messagingEngine.sendEmail(subject, emails);
    }

    public int numberOfSubscribers(){
        return subscriberDatabase.getSubscribers().size();
    }

    public SubscriberDatabase getSubscriberDatabase(){return subscriberDatabase;}

    public MessagingEngine getMessagingEngine(){return messagingEngine; }
}
