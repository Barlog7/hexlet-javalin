@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
page = page,
content = @`

    @for(var user : page.getUsers())
    <%--<div>${course.getName()}</div>--%>
        <%--<h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>--%>
        <h2><a href="${NamedRoutes.usersPath(user.getId())}">${user.getName()}</a></h2>
        <p>${user.getMail()}</p>
    @endfor
`,
footer = @`
<%--<p>Github link</p>--%>
    <a href="https://github.com/Barlog7">Github link</a>
`
)