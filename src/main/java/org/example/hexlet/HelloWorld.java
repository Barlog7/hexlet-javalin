package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.validation.ValidationException;
import org.apache.commons.text.StringEscapeUtils;

import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.users.BuildUserPage;
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



        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("index.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.get("/users/build", UsersController::build);
        app.get("/users", UsersController::index);
        app.get("/users/{id}", UsersController::show);
        app.post("/users", UsersController::create);
        app.get("/users/{id}/edit", UsersController::edit);
        app.patch("/users/{id}", UsersController::update);
        app.delete("/users/{id}", UsersController::destroy);

        app.get("/courses/build", CoursesController::build);
        app.get("/courses", CoursesController::index);
        app.get("/courses/{id}", CoursesController::show);
        app.post("/courses", CoursesController::create);
        app.get("/courses/{id}/edit", CoursesController::edit);
        app.patch("/courses/{id}", CoursesController::update);
        app.delete("/courses/{id}", CoursesController::destroy);



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

