package services;

import entities.User;
import factories.UserFactory;

import java.util.List;

public class UserService {

    List<User> userList;

    public UserService(){
        UserFactory userFactory = new UserFactory();
        userList = userFactory.createUsers(10);
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(String username){
        User user = null;

        for (User u : userList){
            if(u.getUsername().equalsIgnoreCase(username)){
                user = u;
            }
        }

        return user;
    }

    public List<User> getUserList(){
        return this.userList;
    }

    public User login(String username, String password){
        User user = null;

        for (User u : userList){
            if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)){
                user = u;
            }

        }

        return user;
    }

    public User createUser(String username, String password){
        for (User u : userList) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Error: User with that username already exists");
                return null;
            }
        }
        User user = new User(username, password);
        addUser(user);
        return user;
    }

    public boolean validatePassword(String password){
        boolean isPasswordValid = false;

        if (password.length() >= 8 && password.length() <=15){
            if(password.matches("[A-Z0-9]") && password.matches("[^a-zA-Z0-9]")){
                isPasswordValid = true;
            }
        }

        return isPasswordValid;
    }


}
