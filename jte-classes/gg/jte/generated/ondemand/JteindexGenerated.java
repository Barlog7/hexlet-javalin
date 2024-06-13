package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
import static org.example.hexlet.NamedRoutes.sessionsPath;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,18,18,19,19,19,21,21,24,25,25,25,25,25,25,25,25,25,31,31,31,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hello Hexlet!</title>\n</head>\n<body>\n<main>\n    <h1>Привет, Хекслет!</h1>\n");
		jteOutput.writeContent("\n\n    ");
		if (page.getCurrentUser() != null) {
			jteOutput.writeContent("\n        Добро пожаловать, ");
			jteOutput.setContext("main", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent(".\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\n    ");
		}
		jteOutput.writeContent("\n\n    <div>\n        ");
		jteOutput.writeContent("\n        <h2><a");
		var __jte_html_attribute_0 = sessionsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Зарегистрироваться</a> </h2>\n    </div>\n\n</main>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
