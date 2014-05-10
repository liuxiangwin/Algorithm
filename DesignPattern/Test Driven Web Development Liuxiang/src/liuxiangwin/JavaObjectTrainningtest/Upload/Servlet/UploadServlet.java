package liuxiangwin.JavaObjectTrainningtest.Upload.Servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {

	private static String Uploadlocation = "";
	private static String actStr = "";
	private static final String fParMaxsize = "";
	private static final String fParResult = "";
	private static final String fParUploaddirectory = "";
	private static final String fParUploadfile = "";

	private String mValUploaddirectory = "";
	private String mValResult = "";
	private String mValUploadfile = "";

	private int mValMaxsize = 102400;
	private String mScheme;
	private String mHost;
	private String mPort;
	private String mContenType;
	private String mSourceFile;
	private int mFromDatalength;

	private byte[] mDataBytes;

	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		// super();
		System.out.println("This Upload Servlet Constuctor");

	}


	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Starting Uploading Servlet");
		String contentType = request.getContentType();
		if (contentType == null || contentType.indexOf("multipart") == -1) {

			System.out.println(" Uploading File but is not multipart");
		} else {
			MultipartRequest mreq = new MultipartRequest(request);
			LoadServletParams(mreq, response);
			try {
				DoUpload(mreq, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Uploading Servlet Done");
	}

	protected void LoadServletParams(MultipartRequest mrequest,
			ServletResponse httpResponse) {
		Uploadlocation = this.GetParameter(mrequest, "uploadlocation",
				"c:\\temp\\uploads");
		this.mValResult = this.GetParameter(mrequest, fParMaxsize, " "
				+ this.mValResult);
		String max = this.GetParameter(mrequest, fParMaxsize, " "
				+ this.mValMaxsize);
		try {
			this.mValMaxsize = Integer.parseInt(max);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// this.mScheme=mrequest.get
			if (this.mContenType == null
					|| this.mContenType.indexOf("multipart/form-data") == -1) {
			}
			// this.mFromDatalength=
			this.mDataBytes = new byte[this.mFromDatalength];
		}
	}

	protected void DoUpload(MultipartRequest mrequest, ServletResponse response) throws Exception {
		System.out.println("UploadServlet# Starting doUpload");
		//----------------------Check Directory-------------------------------------//
		File fileDir = new File(mValUploaddirectory);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		//----------------------Get File Name-------------------------------------//
		String fullFilename = BuildFileName(this.mValUploaddirectory,
				this.mValUploadfile);
		File fileUpload = new File(fullFilename);
		if (fileUpload.exists()) {
             throw new Exception("File exists already");
		}
		//----------------------Read File and Write File Through ServletStream-------------------------------------//
		
		FileOutputStream outUpload = null;
		try {
			outUpload = new FileOutputStream(fullFilename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte data[] = new byte[10];// =mrequest.getFileValue();
		try {
			outUpload.write(data, 0, data.length);
			outUpload.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//------------------------Print Html--------------------------------------
		String resultHtml = "<P></P>" + this.UrlDetails(mrequest);
		byte[] resultBytes = resultHtml.getBytes();
		try {
			ServletOutputStream out = response.getOutputStream();
			out.print(resultHtml);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Verifile the  file content is the same;
		try {
			RandomAccessFile raf = new RandomAccessFile(fullFilename, "r");
			long length = raf.length();
			if (length != data.length) {
				throw new Exception("Verificationfailed");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String GetParameter(MultipartRequest mrequest, String name,
			String defaultValue) {
		String value = mrequest.getParameter(name);
		if (value == null) {
			value = defaultValue;
		}
		return value;

	}
    //Give the URL details to print
	private String UrlDetails(MultipartRequest mrequest) {
		StringBuffer info = new StringBuffer("Meta infomation");
		info.append(this.mScheme);
		info.append(this.mHost);
		info.append(this.mPort);
		info.append(this.mDataBytes);
		return new String(info);

	}

	private String BuildFileName(String directory, String filename) {
		if (directory == null) {
			directory = "";
		}
		if (filename == null) {
			filename = "";
		}
		directory = directory.trim();
		filename = filename.trim();
		if (!(directory.endsWith("\\") && directory.endsWith("/"))) {
			directory += "/";
		}
		if ((filename.startsWith("\\")) && filename.startsWith("/")) {
			if (filename.length() > 1) {
				filename = filename.substring(1, filename.length());
			} else {
				filename = "";
			}
		}
		// Here return a fully qualify name
		return directory + filename;

	}



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();

		// MultipartRequest t=new Multipa
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
