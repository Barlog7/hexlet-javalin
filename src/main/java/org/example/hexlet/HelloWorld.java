package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        Course course1 = new Course("первый курс", "изучение основ Java");
        CourseRepository.save(course1);
        //course1.setId(1);
        Course course2 = new Course("второй курс", "изучение SQL");
        CourseRepository.save(course2);
        //course2.setId(2);
        Course course3 = new Course("третий курс", "изучение html");
        CourseRepository.save(course3);
        //course3.setId(3);

        User user1 = new User("Ivanov", "ivanov@mail.com", "123");
        UserRepository.save(user1);
        //CourseRepository.save(course);
        //user1.setId(1L);
        User user2 = new User("Petrov", "pertov@ya.ru", "ert");
        UserRepository.save(user2);
        //user2.setId(2L);
        User user3 = new User("Marova", "marova@ya.ru", "111111");
        UserRepository.save(user3);
        //user3.setId(3L);
        //CoursePage coursePage = new CoursePage(List.of(course1,course2,course3), "Список курсов");

        app.get("/courses", ctx -> {
            //var coursesAll = List.of(course1,course2,course3);
            var coursesAll =CourseRepository.getEntities();
            var header = "Курсы по программированию";
            var term = ctx.queryParam("term");
            var term2 = ctx.queryParam("term2");
            List<Course> courses;
            List<Course> coursesTemp;
            if (term != null) {
                coursesTemp = fitlerCourse(coursesAll, term);
            } else {
                coursesTemp = new ArrayList<>(coursesAll);
            }
            if (term2 != null) {
                courses = fitlerCourseDesc(coursesTemp, term2);
            } else {
                courses = new ArrayList<>(coursesTemp);
            }
            var page = new CoursesPage(courses, header, term, term2);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });

        app.get("/users", ctx -> {
            var users =UserRepository.getEntities();
            //var users = List.of(user1,user2,user3);
            var header = "Пользователи";
            var page = new UsersPage(users, header);
            ctx.render("users/index.jte", model("page", page));
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



        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            var user = new User("","", "");
            switch (id) {
                case "1":
                    user = user1;
                    break;
                case "2":
                    user = user2;
                    break;
                default:
                    user = user3;
                    break;
            }
            //var course = "/* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */";
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/users_security/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.result("result is " + escapedId);
        });

        app.post("/users", ctx -> {
/*            var name = ctx.formParam("name");
            //var lastname = ctx.formParam("lastname");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");*/
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");

            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.post("/courses", ctx -> {
/*            var name = ctx.formParam("name");
            //var lastname = ctx.formParam("lastname");
            var email = ctx.formParam("email");
            var password = ctx.formParam("password");*/
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim().toLowerCase();

            Course course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });



        app.start(7070);
    }
    public static List<Course> fitlerCourse(List<Course> courses, String seek) {
        //ArrayList<Course> findCourses;
        return courses.stream().filter(c -> c.getName().contains(seek)).toList();
       /* for (var course : courses) {
            course.getDescription().contains(seek);
        }*/

    }

    public static List<Course> fitlerCourseDesc(List<Course> courses, String seek) {
        //ArrayList<Course> findCourses;
        return courses.stream().filter(c -> c.getDescription().contains(seek)).toList();
       /* for (var course : courses) {
            course.getDescription().contains(seek);
        }*/

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
