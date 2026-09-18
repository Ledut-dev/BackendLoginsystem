package controllers;


import entities.User;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import services.UserService;

import java.util.List;

public class UserController {

    static UserService userService = new UserService();

    public static void setRoutes(JavalinConfig config){
        config.routes.get("/", ctx -> ctx.redirect("/login.html"));
        config.routes.post("/login", ctx -> login(ctx));
        config.routes.post("/createUser", ctx -> createUser(ctx));
        config.routes.get("/userList", ctx -> showUserList(ctx));
        config.routes.get("/finduser", ctx -> findUser(ctx));

    }

    public static void login(Context ctx){
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = userService.login(username, password);
        if (user != null && user.getUsername().equalsIgnoreCase("Ledut")){
            ctx.redirect("/admin.html");
        }
        else if (user != null){
            ctx.redirect("/welcome.html");
        }
        else{
            ctx.status(404);
            ctx.result("Fejl: Forkert brugernavn eller adgangskode");
        }
    }

    public static void createUser(Context ctx){
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        User user = userService.createUser(username, password);
        if (user != null){
            ctx.redirect("/welcome.html");
        }
        else{
            ctx.status(404);
            ctx.result("Error: User with that username already exists");
        }
    }

    public static void showUserList(Context ctx){
        List<User> userList = userService.getUserList();

        ctx.attribute("userList", userList);
        ctx.render("templates/userlist.html");
    }

    public static void findUser(Context ctx){
        String username = ctx.queryParam("username");
        User user = userService.getUser(username);

        if (user != null){
            ctx.attribute("user", user);
            ctx.render("templates/userinfo.html");
        }
        else ctx.result("User with username " + username + " does not exist");
    }

}
