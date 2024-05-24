@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`

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
