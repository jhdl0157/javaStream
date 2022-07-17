package Chapter10.service;

import Chapter10.model.User;

public abstract class AbstractUserService {
    protected abstract boolean validateUser(User user);
    protected abstract void writeDB(User user);
    public void createUser(User user){
        if(validateUser(user)){
            writeDB(user);
        }else{
            System.out.println("Cannot create user");
        }
    }
}
