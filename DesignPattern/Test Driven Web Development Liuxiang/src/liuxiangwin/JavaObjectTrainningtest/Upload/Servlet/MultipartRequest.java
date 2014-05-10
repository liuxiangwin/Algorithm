package liuxiangwin.JavaObjectTrainningtest.Upload.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

public class MultipartRequest extends HttpServlet {

	public static String fEOLN = "\r\n";
	public static String fEmptyLine = fEOLN + fEOLN;
	public static String fDoubleDash = "--";
	private HttpServletRequest mRequest;
	//private ServletRequest mRequest;
	private String mBoundary;
	private byte[] mDataBytes;
	private String mDataString;
	private int mMaxSize;

	public static final String newString(byte[] bytes) {

		if (bytes == null) {
			return "";
		}
		return new String(bytes);
	}

	public MultipartRequest(ServletRequest request) {
		
	}
     
	
	public MultipartRequest(HttpServletRequest request,int maxSize) {
		mRequest=request;
		if(true)
		{
			 //throw 
		}
		if(maxSize<0)
		{
			mMaxSize=Integer.MAX_VALUE;
		}
		else
		{
			mMaxSize=maxSize;
		}
		//DataInputStream in=null;
		//in =new DataInputStream(); 
		//int formDataLength=
	}
	
	/*public ServletInputStream getDataInputStream()
	{
		return this.mRequest.getInputStream();
	}
	*/
	
	public int getContentLength()
	{
		return this.mRequest.getContentLength();
	}
	
	public String getContenType()
	{
		return this.mRequest.getContentType();
	}
	
	
	
	public byte[] getByteContent()
	{
		return this.mDataBytes;
	}
	public String getBoundary()
	{
		return this.mBoundary;
	}
	public String getQueryString()
	{
	    return this.mRequest.getQueryString();
		
	}
	
	
	public String getRemoteAddr()
	{
	    return this.mRequest.getRemoteAddr();
		
	}
	
	
	public String getHeaderParameter(String name)
	{
	    return this.mRequest.getParameter(name);
		
	}
	
	public String getMultipartHeader(String name)
	{
	    //DataBlock dblock
		
		
		return this.mRequest.getParameter(name);
		
	}
	
	
	/*public  String getMultipartValue(String name)
	{
		
		
	}
	*/
	public String getRequestURL()
	{
		return new String(HttpUtils.getRequestURL(this.mRequest));
	}
	public String getScheme()
	{
		return this.mRequest.getScheme();
	}
	
	public boolean isSecure()
	{
		return this.mRequest.isSecure();
	}
	
	
	public String getServerName()
	{return this.mRequest.getServerName();}
	
	
	/*public String getServerPort()
	{return this.mRequest.getServerPort();}
	
	*/
	
	public String getParameter(String name) {
		return null;
	}

}
