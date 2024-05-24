package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;

import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        Course course1 = new Course("первый курс", "изучение основ Java");
        course1.setId(1);
        Course course2 = new Course("втрой курс", "изучение SQL");
        course2.setId(2);
        Course course3 = new Course("третий курс", "изучение html");
        course3.setId(3);
        //CoursePage coursePage = new CoursePage(List.of(course1,course2,course3), "Список курсов");

        app.get("/courses", ctx -> {
            var courses = List.of(course1,course2,course3);
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = new Course("","");
            switch (id) {
                case "1":
                    course = course1;
                    break;
                case "2":
                    course = course2;
                    break;
                default:
                    course = course3;
                    break;
            }
            //var course = "/* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */";
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.start(7070);
    }

}
 /*       var app = Javalin.create(config -> {
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

        app.get("/", ctx -> ctx.render("index.jte"));

*/
/*        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = *//* Курс извлекается из базы данных *//*
                    // Предполагаем, что у курса есть метод getName()
                    ctx.result("<h1>" + course.getName() + "</h1>");
        });*/


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

/*        app.start(7070);
    }
}*/
/*    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        // Позже мы разберем эти конструкции подробнее
        var user = UserRepository.find(id) // Ищем пользователя в базе по id
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
    }
}*/
