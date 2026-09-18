package factories;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public UserFactory(){

    }

    public List<User> createUsers(int amount){
        List<User> userList = new ArrayList<>();

        for(int i = 0; i<amount; i++){
            userList.add(new User("brugernavn" + i, "password" + i));
        }
        userList.add(new User("Ledut", "PasswordYEP"));

        return userList;
    }
}
