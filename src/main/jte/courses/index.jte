@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
page = page,
content = @`

    <form action="${NamedRoutes.coursesPath()}" method="get">

        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Искать по названию курса">
    </form>

    <form action="${NamedRoutes.coursesPath()}" method="get">

        <input type="search" name="term2" value="${page.getTerm2()}" />
        <input type="submit" value="Искать по описанию курса">
    </form>


    @for(var course : page.getCourses())
        <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
        <p>${course.getDescription()}</p>
    @endfor
`,
footer = @`
    <%--<p>Github link</p>--%>
    <a href="https://github.com/Barlog7">Github link</a>
`
)
