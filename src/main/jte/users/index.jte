@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`

    @for(var user : page.getUsers())
    <%--<div>${course.getName()}</div>--%>
        <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
        <p>${user.getMail()}</p>
    @endfor
`,
footer = @`
<%--<p>Github link</p>--%>
    <a href="https://github.com/Barlog7">Github link</a>
`
)