@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
content = @`
    <div>${page.getCourse().getName()}</div>
    <div>${page.getCourse().getDescription()}</div>
`
)