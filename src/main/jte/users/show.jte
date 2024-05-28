@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <div>${page.getUser().getId()}</div>
    <div>${page.getUser().getName()}</div>
    <%--<div>${page.getUser().getLastName()}</div>--%>
    <div>${page.getUser().getMail()}</div>
`
)