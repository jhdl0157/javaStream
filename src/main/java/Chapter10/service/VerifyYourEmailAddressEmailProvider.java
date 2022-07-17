package Chapter10.service;


import Chapter10.model.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvidcer {
    @Override
    public String getEmail(User user) {
        return "Verify Your Email Address email for "+user.getName() ;
    }
}
