import controllers.UserController;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

public class Main {


    public static void main(String[] args){

        var app = Javalin.create(config ->{
            config.fileRenderer(new JavalinThymeleaf());
            UserController.setRoutes(config);
            config.staticFiles.add("/public");
        }).start(7070);
//        UserService userService = new UserService();
//        System.out.println(userService.getUser("brugernavn0"));
//
//        for (User u : userService.getUserList()){
//            System.out.println(u.toString());
//        }
//        System.out.println(userService.login("brugernavn0","password0").toString());
//        userService.login("brugernavn1","password0");
//
//        userService.createUser("Lukas", "passwordsarehard");
//        userService.createUser("Lukas", "passwordsarehard");
    }
}
