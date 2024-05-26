package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,13,13,19,19,19,20,20,22,22,22,24,24,27,27,27,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <title>Hexlet Javalin Example</title>\n</head>\n<body>\n<p>\n    ");
		jteOutput.writeContent("\n    <h2>Курсы</h2>\n    <a href=\"/courses\">Courses</a>\n    <h2>Пользователи</h2>\n    <a href=\"/users\">Users</a>\n</p>\n");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n");
		if (footer != null) {
			jteOutput.writeContent("\n    <div class=\"footer\">\n        ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\n    </div>\n");
		}
		jteOutput.writeContent("\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
