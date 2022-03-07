import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Invoice extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Double taxRate = 0.067;
		Double shippingCost = 5.00;

		String strSubTotal = (String)request.getSession().getAttribute("total");
		Double subTotal = Double.parseDouble(strSubTotal);
                // Set response content type
                response.setContentType("text/html");

                PrintWriter out=response.getWriter();
                String title="Invoice";
                String docType="<!doctype html public \"-//w3c//dtd html 4.0 "+"transitional//en\">\n";

		out.print(docType+
                "<HTML>\n"+
                        "<HEAD><TITLE>"+"Invoice Page"+"</TITLE></HEAD>\n"+
                        "<BODY bgcolor=\"#f0f0f0\"><CENTER>\n"+
					"<H1 align=\"center\">"+title+"</H1>\n"+
					"<TABLE width=\"35%\" border=\"1\" align=\"center\">");
		
			out.print("<TR>"+
					"<TD align=\"center\">Sub-Total</TD>"+
					"<TD align=\"center\">$"+String.format("%.2f", subTotal)+"</TD>"+
					"</TR>");
			out.print("<TR>"+
				"<TD align=\"center\">Tax</TD>"+
					"<TD align=\"center\">$"+String.format("%.2f", subTotal*taxRate)+"</TD>"+
				"</TR>");

			out.print("<TR>"+
				"<TD align=\"center\">Shipping Cost</TD>"+
					"<TD align=\"center\">$"+String.valueOf(shippingCost)+"</TD>"+
				"</TR>");

			Double total = subTotal+(subTotal*taxRate)+shippingCost;

			out.print("<TR>"+
				"<TD align=\"center\">Total</TD>"+
					"<TD align=\"center\">$"+String.format("%.2f", total)+"</TD>"+
				"</TR>");
		out.println("</TABLE>"+
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