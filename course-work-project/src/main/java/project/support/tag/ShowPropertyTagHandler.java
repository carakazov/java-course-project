package project.support.tag;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import lombok.NoArgsConstructor;
import lombok.Setter;
import project.dto.IntellectualPropertyDto;

@NoArgsConstructor
public class ShowPropertyTagHandler extends SimpleTagSupport {
    @Setter
    private IntellectualPropertyDto property;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String base64 = Base64.getEncoder().encodeToString(property.getContent());
        out.write("<div>");
        out.write("<label>");
        out.write("Content:");
        out.write("</label>");
        switch(property.getAttributes().getContentType()) {
            case picture:
                out.write("<img src=\"data:image/png;base64," + base64 + "\"/>");
                break;
            case audio:
                out.write("<audio controls src=\"data:image:/mp3;" + base64 + "\">");
                out.write("</audio>");
                break;
            case video:
                out.write("<video controls src=\"data:image:/mp4;" + base64 + "\">");
                out.write("</video>");
                break;
        }
        out.write("</div>");
    }
}
