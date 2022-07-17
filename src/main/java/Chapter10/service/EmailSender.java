package Chapter10.service;


import Chapter10.model.User;

public class EmailSender {
    private EmailProvidcer emailProvider;

    public EmailSender setEmailProvider(EmailProvidcer emailProvidcer) {
        this.emailProvider = emailProvidcer;
        return this;
    }

    public void sendEmail(User user) {
        String email = emailProvider.getEmail(user);
        System.out.println("Sending " + email);
    }

}
