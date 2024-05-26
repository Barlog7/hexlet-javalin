package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,10,10,10,10,10,10,10,10,10,15,15,16,17,17,17,17,17,17,17,18,18,18,19,19,20,20,20,20,21,23,23,23,24,24,24,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <form action=\"/courses\" method=\"get\">\n        ");
				jteOutput.writeContent("\n        <input type=\"search\" name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n        <input type=\"submit\" value=\"Искать\">\n    </form>\n\n\n    ");
				for (var course : page.getCourses()) {
					jteOutput.writeContent("\n        ");
					jteOutput.writeContent("\n        <h2><a href=\"/courses/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(course.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(course.getName());
					jteOutput.writeContent("</a></h2>\n        <p>");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(course.getDescription());
					jteOutput.writeContent("</p>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				jteOutput.writeContent("\n    <a href=\"https://github.com/Barlog7\">Github link</a>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
