package ie.gmit.sw;

import java.io.*;
import java.rmi.Naming;

import javax.servlet.*;
import javax.servlet.http.*;


public class CrackerHandler extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String remoteHost = null;
	private static long jobNumber = 0;
	private	VigenereRequestManager reqman = new VigenereRequestManager();

	
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
				
		int maxKeyLength = Integer.parseInt(req.getParameter("frmMaxKeyLength"));
		String cypherText = req.getParameter("frmCypherText");
		String taskNumber = req.getParameter("frmStatus");		
		String waiting = "BREAKING THE CODE";	//	Will be on screen will stuff get's broken. Is meant to change back the decrpyted text when it's done
		String result;	//	Should get the 
					
		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			jobNumber++;
			
			// New request
			Request newReq = new Request(cypherText, maxKeyLength, jobNumber);		
			reqman.add(newReq);	
			} 
		else{	// Checks if request is finished.
			result = reqman.getResult(maxKeyLength);		//	Should pull the decrypted string
			if(result != null && !result.equals(cypherText)) {
				waiting = result;	//	Once everything is done, result should replace waiting with the decrpyted string
			}		
		}
		
		
		//	Here is the direct RMI code that had no queues. While it still does work, it's synchronus and slow.
		/*try {
			VigenereBreaker vb = (VigenereBreaker) Naming.lookup("rmi://localhost:1099/cypher-service");
			result = vb.decrypt(cypherText, maxKeyLength);
		} catch (Exception e) {
			out.println("Naming.Lookup error");
		}*/
			
		
		
		//Check out-queue for finished job
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
			
		out.print("RMI Server is located at " + remoteHost);
		out.print("<OL>");
		out.print("<P>Maximum Key Length: " + maxKeyLength);		
		out.print("<P>Cypher Text: " + cypherText);
		out.print("<P>Decrypted Text: " + waiting);
		out.print("</OL>");
			
		out.print("<form name=\"frmCracker\">");
		out.print("<input name=\"frmMaxKeyLength\" type=\"hidden\" value=\"" + maxKeyLength + "\">");
		out.print("<input name=\"frmCypherText\" type=\"hidden\" value=\"" + cypherText + "\">");
		out.print("<input name=\"frmStatus\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");
			
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmCracker.submit();\", 10000);");	
		out.print("</script>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}