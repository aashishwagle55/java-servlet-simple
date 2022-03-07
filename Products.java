import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Products extends HttpServlet
{
	public String []products = {"pencils", "paper", "notebook", "souvenier"};
	public Double []price = {4.99, 2.99, 3.99, 4.99};
	public boolean []selected = {false, false, false, false};
	public int []quantity = {0,0,0,0};

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Your Order";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0"+"transitional//en\">\n";

		out.print(docType+
			"<HTML>\n"+
				"<HEAD><TITLE>Order Page</TITLE></HEAD>\n"+
				"<BODY bgcolor=\"#f0f0f0\"><CENTER>\n"+
					"<H1 align=\"center\">"+title+"</H1>\n"+
					"<FORM action=\"../Summary\" method=\"POST\">"+
					"<TABLE width=\"35%\" border=\"1\" align=\"center\">"+
						"<TR>"+
							"<TH>Product Name</TH>"+
							"<TH>Price</TH>"+
							"<TH>Quantity</TH>"+
						"</TR>");
			for (int i=0; i<products.length; i++) 
			{
				if(String.valueOf(request.getParameter(products[i])).equals("on"))
				{
					selected[i] = true;
					out.print("<TR>"+
								"<TD><CENTER>"+products[i]+"</CENTER></TD>"+
								"<TD><CENTER>"+price[i]+"</CENTER></TD>");
						
								String paramName = products[i]+"_quantity";
								
								out.print("<TD><CENTER><INPUT type=\"text\" name=\""+paramName+"\"></CENTER></TD>\n</TR>");

								//request.getSession().setAttribute("variable", "Aashish");

								String hiddenParam = products[i] + "_price";
								request.getSession().setAttribute(hiddenParam, String.valueOf(price[i]));								
				}
			}

			out.println("</TABLE>"+
				"<input type=\"submit\" name=\"submit\" value=\"Submit\" align=\"center\"/>"+
				"</FORM>"+
				"<CENTER></BODY>"+
			"</HTML>");
	}

	//Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}