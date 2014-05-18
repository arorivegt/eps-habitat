package org.habitatguate.hgerp.util;

public class HTMLUtil {
	
	@SuppressWarnings("unused")
	private static String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

}
