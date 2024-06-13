@import org.example.hexlet.dto.MainPage
@import static org.example.hexlet.NamedRoutes.sessionsPath
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
<main>
    <h1>Привет, Хекслет!</h1>
<%--    @if(!page.isVisited())
        Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки
    @endif--%>

    @if(page.getCurrentUser() != null)
        Добро пожаловать, ${page.getCurrentUser()}.
        Чтобы разлогиниться, удалите куку JSESSIONID из браузера
    @endif

    <div>
        <%--<h1>Зарегистрироваться</h1>--%>
        <h2><a href="${sessionsPath()}">Зарегистрироваться</a> </h2>
    </div>

</main>
</body>
</html>
