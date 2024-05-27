@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`

    <form action="/courses" method="get">

        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Искать">
    </form>

    <form action="/courses" method="get">

        <input type="search" name="term2" value="${page.getTerm2()}" />
        <input type="submit" value="Искать">
    </form>


    @for(var course : page.getCourses())
        <%--<div>${course.getName()}</div>--%>
        <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
        <p>${course.getDescription()}</p>
    @endfor
`,
footer = @`
    <%--<p>Github link</p>--%>
    <a href="https://github.com/Barlog7">Github link</a>
`
)
