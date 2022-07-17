package Chapter10.service;


import Chapter10.model.User;

public interface EmailProvidcer {
    String getEmail(User user);
}
