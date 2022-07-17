package Chapter10.service;

import Chapter10.model.User;

public class UserService extends AbstractUserService{
    @Override
    protected boolean validateUser(User user) {
        System.out.println("validating user "+ user.getName());
        return user.getName()!=null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void writeDB(User user) {
        System.out.println("Writing user"+user.getName()+"to DB");
    }
}
