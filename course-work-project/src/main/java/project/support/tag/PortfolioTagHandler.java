package project.support.tag;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import lombok.NoArgsConstructor;
import lombok.Setter;
import project.dto.UserDto;

@NoArgsConstructor
public class PortfolioTagHandler extends SimpleTagSupport {
    @Setter
    private UserDto portfolioOwner;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String base64 = Base64.getEncoder().encodeToString(portfolioOwner.getPortfolio());
        out.write("<div>");
        out.write("<a download=\"portfolio.pdf\" href=\"data:application/octet-stream;base64,\"" + base64 + ">Download portfolio</a>");
        out.write("</div>");
    }
}
