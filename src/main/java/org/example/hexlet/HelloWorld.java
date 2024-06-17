package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.NamedRoutes.sessionsPath;

import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) throws SQLException {

/*        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }

        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });*/

        /*var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });*/

        Javalin app = null;
        try {
            app = getApp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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



/*        app.get("/", ctx -> {
            //var visited = Boolean.valueOf(ctx.cookie("visited"));
            //var page = new MainPage(visited);
            ctx.render("index.jte", model("page", page));
            //ctx.cookie("visited", String.valueOf(true));
        });*/

        app.get("/", ctx -> {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            ctx.render("index.jte", model("page", page));
        });

        app.get(sessionsPath(), SessionsController::build);
        app.post(sessionsPath(), SessionsController::create);

        app.get("/users/build", UsersController::build);
        app.get("/users", UsersController::index);
        app.get("/users/{id}", UsersController::show);
        app.post("/users", UsersController::create);
        app.get("/users/{id}/edit", UsersController::edit);
        app.patch("/users/{id}", UsersController::update);
        //app.delete("/users/{id}", UsersController::destroy);

        app.get("/courses/build", CoursesController::build);
        app.get("/courses", CoursesController::index);
        app.get("/courses/{id}", CoursesController::show);
        app.post("/courses", CoursesController::create);
        app.get("/courses/{id}/edit", CoursesController::edit);
        app.patch("/courses/{id}", CoursesController::update);
        //app.delete("/courses/{id}", CoursesController::destroy);


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

    public static Javalin getApp() throws Exception {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        // Получаем путь до файла в src/main/resources
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        // Получаем соединение, создаем стейтмент и выполняем запрос
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        return app;


    }
}

