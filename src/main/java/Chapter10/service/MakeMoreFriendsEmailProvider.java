package Chapter10.service;


import Chapter10.model.User;

public class MakeMoreFriendsEmailProvider implements EmailProvidcer {

    @Override
    public String getEmail(User user) {
        return "'Make More Friends' email for " + user.getName();
    }
}
