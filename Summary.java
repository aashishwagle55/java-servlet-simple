import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Summary extends HttpServlet
{
    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
                // Set response content type
                response.setContentType("text/html");

                PrintWriter out=response.getWriter();
                String title="Summary";
                String docType="<!doctype html public \"-//w3c//dtd html 4.0 "+"transitional//en\">\n";

		out.print(docType+
                "<HTML>\n"+
                        "<HEAD><TITLE>"+"Summary Page"+"</TITLE></HEAD>\n"+
                        "<BODY bgcolor=\"#f0f0f0\"><CENTER>\n"+
					"<H1 align=\"center\">"+title+"</H1>\n"+
					"<FORM action=\"../Invoice\" method=\"POST\">"+
					"<input type=\"submit\" name=\"submit\" value=\"Print\" align=\"center\"/>"+
					"<TABLE width=\"35%\" border=\"1\" align=\"center\">"+
				"<TR>"+
					"<TH>Product</TH>"+
					"<TH>Quantity</TH>"+
					"<TH>Unit Price</TH>"+
					"<TH>Price</TH>"+
				"</TR>\n");
		Enumeration paramNames=request.getParameterNames();
		Double total=0.0;
		while (paramNames.hasMoreElements())
		{
			String paramName=(String )paramNames.nextElement();
			//String []paramValues=request.getParameterValues(paramName);
			String paramValue=(String )request.getParameter(paramName);
			String itemName=paramName.substring(0, paramName.length()-9);
			out.print("<TR>"+
					"<TD align=\"center\">"+itemName+"</TD>"+
					"<TD align=\"center\">"+paramValue+"</TD>");
			int quantity=Integer.parseInt(paramValue);
			String strPrice=(String )request.getSession().getAttribute(itemName+"_price");
			double price=quantity*Double.parseDouble(strPrice);
			out.print(	"<TD align=\"center\">$"+strPrice+"</TD>"+
					"<TD align=\"center\">$"+String.valueOf(price)+"</TD>"+
				"</TR>\n");
			total+=price;
			request.getSession().setAttribute("total", String.valueOf(total));					
		}
		out.println("</TABLE>"+
				"</FORM>"+
				"<CENTER></BODY>"+
			"</HTML>");

				
		request.getSession().invalidate();
	}

	 // Method to handle POST method request.
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
        {
                doGet(request, response);
        }
}
