@import gg.jte.Content
@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.BasePage
@param Content content
@param Content footer = null
@param BasePage page = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">

</head>
<body>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>--%>
<p>
    <%--<a href="/users">Users</a>--%>
    <h2>Курсы</h2>
    <a href="${NamedRoutes.coursesPath()}">Courses</a>
    <h2>Пользователи</h2>
    <a href="${NamedRoutes.usersPath()}">Users</a>
</p>

@if(page != null && page.getFlash() != null)
    @if(page.getStatus().equals("ok"))
        <div class="alert alert-success" role="alert">
            ${page.getFlash()}
        </div>
    @else
        <div class="alert alert-danger" role="alert">
            ${page.getFlash()}
        </div>

    @endif
    <p>${page.getFlash()}</p>
@endif

${content}
@if (footer != null)
    <div class="footer">
        ${footer}
    </div>
@endif
</body>
</html>
