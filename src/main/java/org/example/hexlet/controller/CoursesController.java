package org.example.hexlet.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class CoursesController {
    public static void index(Context ctx) {
        var courses = CourseRepository.getEntities();

        //var flash = (String) ctx.consumeSessionAttribute("flash");
        // Добавляем flash в определение CoursesPage
        //var page = new CoursesPage(courses, term, flash);


        var page = new CoursesPage(courses, "courses", "", "");
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setStatus(ctx.consumeSessionAttribute("status"));
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
        //ctx.render("courses/build.jte");
    }

    public static void create(Context ctx) {
        /*var name = ctx.formParam("name");
        var email = ctx.formParam("email");*/
        var name = ctx.formParam("name").trim();
        var description = ctx.formParam("description").trim().toLowerCase();

        //var password = ctx.formParam("password");

        var course = new Course(name, description);
        CourseRepository.save(course);
        ctx.sessionAttribute("flash", "Course has been created!");
        ctx.sessionAttribute("status", "ok");
        ctx.redirect(NamedRoutes.coursesPath());
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/edit.jte", model("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name").trim();
        var description = ctx.formParam("description").trim().toLowerCase();

        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        course.setName(name);
        course.setDescription(description);
        CourseRepository.save(course);
        ctx.redirect(NamedRoutes.coursesPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
