package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
		getJspBody().invoke(null);
		getJspBody().invoke(null);
	}
}
