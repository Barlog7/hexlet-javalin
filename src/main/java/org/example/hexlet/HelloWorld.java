package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

/*public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070); // Стартуем веб-сервер
    }
}*/

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        //app.get("/hello", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            //var page = ctx.queryParam("name");
            var page = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + page + "!");

        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            ctx.result("user ID: " + ctx.pathParam("id"));
            ctx.result("post ID: " + ctx.pathParam("postId"));
        });
       /* app.get("/courses/{id}", ctx -> {
            ctx.result("Course ID: " + ctx.pathParam("id"));
        });
        app.get("/users/{id}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
        });

        app.get("/courses/{courseId}/lessons/{id}", ctx -> {
            ctx.result("Course ID: " + ctx.pathParam("courseId"));
            ctx.result("Lesson ID: " + ctx.pathParam("id"));
        });*/

        app.start(7070);
    }
}
/*    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        // Позже мы разберем эти конструкции подробнее
        var user = UserRepository.find(id) // Ищем пользователя в базе по id
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
    }
}*/
