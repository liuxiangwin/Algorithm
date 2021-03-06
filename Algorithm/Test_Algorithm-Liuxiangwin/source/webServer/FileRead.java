/*
 *@author  Assoudi Othmane
 *@version 1.5
 *@since   7 june 2002
 * 
 * Mimes.java - FileRead either read the requested File or list a folder content
 *
 * This program is free software; you can redistribute it and/or
 * modify it.
 *
 *	 
 * For any additional help please contact : a_othmane@hotmail.com
 */


/** class FileRead Belong to the webServer Package. **/
package webServer; 

import java.io.*;
import java.util.*;
import java.util.Date;
import webServer.Mimes;

public class FileRead 
{
	
	private int nbRead;//Hold the number of bytes readed
	private byte[] buffer;//Buffer contain data readed from file.
	private String Directory_Name="";//Hold the current directory name. 
	private String MIME_TYPE=""; //MIME_TYPE is used to hold the Requested File mime type  
	private final int CGI_PROG=1;//This type must be used when the file is a Cgi Program.
	private final int PHP_PROG=2;//This type must be used when the file is a php file.
	private String mailto="a_othmane@hotmail.com";//Hold the web server administrator e-mail  
				  
	public FileRead(){
	nbRead=0;//initializing nbRead to zero
	buffer = new byte[1024];//The buffer can contain  1 KB 
	}
	
	/** Set the current directory name */
	public void setDirectory_Name(String Dir){
		
		Directory_Name=Dir;
	}
	/** Get the current directory name */
	public String getDirectory_Name(){
		return Directory_Name;
	}
	
	/**
	 * Handling The ERROR 404 Not Found (occur when a file or a directory
	 * doesn't exist under the web server
	 */
	
	void FileNotFound(OutputStream outS,String HOST_NAME)throws IOException{
	
		outS.write(new String("<html>\r\n").getBytes());
		outS.flush();
		outS.write(new String("<Title>404 File Not Found</Title>\r\n").getBytes());
		outS.flush();
		outS.write(new String("<body bgcolor='#008080'>\r\n").getBytes());
		outS.flush();
		outS.write(new String("<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>\r\n").getBytes());
		outS.flush();
		outS.write(new String("<div align='center'><center></p>\r\n").getBytes());
		outS.flush();
		outS.flush();
		outS.write(new String("<table border='1' width='700' bgcolor='#004080'><TR>\r\n").getBytes());
		outS.write(new String("<td align='center'><p align='center'><font color='#FFFFFF' size='6'><strong>404 File Not Found</strong></font></p>"+
        "<p align='left'><font color='#FFFFFF'><strong>The Web Server cannot find the requested file or script"+
        " . check for your URL ,to be sure that your acces path is correct. Contact the Web Server administrator "+
							  " if the problem persist  <a href='mailto:>" + mailto + "'>"+ mailto + "</a></strong></font></p><p>&nbsp;</p></td></TR></Table>\r\n").getBytes());
		outS.flush();
		outS.write(new String("</center></div>\r\n").getBytes());
		outS.flush();
		outS.write(new String("</html>"+"\r\n").getBytes());
		outS.flush();
	}
	/**
	 * Sending The 200 OK Response to the client = The Request Was accepted
	 */
	
	public void HttpResponseOK(OutputStream OUT_HROK,File FILE_LENGTH,String FILE_MIME)throws IOException {
		
	 /**Test the file extension, then get the appropriate mime type **/ 
		
		Mimes mim=new Mimes();
		MIME_TYPE=mim.getMimes(FILE_MIME);
		
		/** Sending a Http Response of type
		 * 
		 * HTTP/1.x 200 OK + crlf
		 * Date : xx/xx/xxxx + crlf
		 * Server : serverName + crlf
		 * content-length : X bytes + crlf
		 * content-type : mime type + crlf
		 * 
		 * */
		OUT_HROK.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
		OUT_HROK.flush();
		OUT_HROK.write(new String("Date: "+new Date().toString()+"\r\n").getBytes());
		OUT_HROK.flush();
		OUT_HROK.write(new String("Server: AssoudiWebServer1.5r\n").getBytes());
		OUT_HROK.flush();
		OUT_HROK.write(new String("Accept-Ranges: bytes\r\n").getBytes());
		OUT_HROK.flush();
		OUT_HROK.write(new String("content-length: "+String.valueOf(FILE_LENGTH.length())+"\r\n").getBytes());
		OUT_HROK.flush();
		OUT_HROK.write(new String("Content-Type: "+MIME_TYPE+"\r\n").getBytes());
		OUT_HROK.flush();
		OUT_HROK.write(new String("\r\n").getBytes());
		OUT_HROK.flush();
	}
	
	/* Method isCgiProg test if the file is a cgi program **/
	public boolean isCgiProg(String FILE_MIME){
		
		int FILE_EXTENS_POS=(int)FILE_MIME.lastIndexOf(".");
		
		if(FILE_MIME.substring(FILE_EXTENS_POS+1,FILE_MIME.length()).equals("exe"))
			
			return true;
		else
			return false;
		
	}
	/* Method isPHPProg test if the file is a PHP Script **/
	public boolean isPHPProg(String FILE_MIME){
		
		int FILE_EXTENS_POS=(int)FILE_MIME.lastIndexOf(".");
		
		if(FILE_MIME.substring(FILE_EXTENS_POS+1,FILE_MIME.length()).equals("php"))
			
			return true;
		else
			return false;
		
	}
	
	
	public void ProcessCgi(String CGI_PHPFile,OutputStream ToBrowser,int CGI_PHP )throws IOException{
	
	/**
	 * Method ProcessCgi according to the CGI_PHP varaiable ,either directly execute
	 * the file if it is a cgi program or call the php program wich execute the php script 
	 * then send the result to the server
	 */	
	
	Runtime r=Runtime.getRuntime(); //creating an object Runtime by calling the getRuntime Method 
	String cgiContent="";
	Process p=null;//win32 process initialised to null
	
	switch(CGI_PHP){
	
	case CGI_PROG:
					p=r.exec(CGI_PHPFile);
					break;
	case PHP_PROG:
					p=r.exec("C:\\php\\php.exe "+CGI_PHPFile);
					break;
	}
	/*we redirect the program STDOUT  to a bufferedReader */
	
	BufferedReader brcgi=new BufferedReader(new InputStreamReader(p.getInputStream()));
	
	while((cgiContent=brcgi.readLine())!=null){
		
	/** we eliminate useless data generated by the program */	
		
		if(cgiContent.startsWith("Status")||
		   cgiContent.startsWith("Content")||
		   cgiContent.startsWith("X-Powered-By"))
		{
		
		ToBrowser.write("".getBytes());
		ToBrowser.flush();
		
		}else
		{
		//we send the data redirected from the program STDOUT to the client	
		ToBrowser.write((cgiContent+"\r\n").getBytes());
		ToBrowser.flush();
		}
	}

	p.destroy();//we destroy the process to free memory
			
	}
	/**
	 * method ReadFile used to either read file,execute cgi program or excute a php script
	 * 
	 */
	public void ReadFile(String File_Name,String HOST_NAME,OutputStream priw,String File_Mime_Type)throws IOException {
		
		File f=new File(File_Name);
		
		if(f==null){
			System.out.println("The File doesn't exist");
		}
		else
		{
		if(!f.exists()){
			/** Requested File doesn't exist => calling the method FileNotFound  **/
			this.FileNotFound(priw,HOST_NAME);			
		}
		else
		{
		if(f.canRead()){
			
		/**Testing if the file is a CGI program **/
		if(isCgiProg(File_Name)){
			
			/** calling the method ProcessCgi with option CGI_PROG **/
			this.ProcessCgi(File_Name,priw,CGI_PROG);
		}
		/**Testing if the file is a PHP file **/
		else if(isPHPProg(File_Name)){
			
			/** calling the method ProcessCgi with option PHP_PROG **/
			this.ProcessCgi(File_Name,priw,PHP_PROG);
		}
		else
		{
		/** case of a simple file => readed then it's content sent to the client **/	
		FileInputStream fich=new FileInputStream(File_Name);
		
		/** calling method HttpResponseOK */
		this.HttpResponseOK(priw,f,File_Mime_Type);
		
		/**
		 * while is not end of file, method read store number of bytes equivalent to the 
		 * buffer length in buffer variable then it's content is sent by method write 
		 */		while((nbRead=fich.read(buffer,0,buffer.length))!=-1){
		
			priw.write(buffer,0,nbRead);			priw.flush();					}
		fich.close(); //File readed must be closed
		}
		}
		}
		}
		
	}
	
	public String DirectoryToList(String Fold){
	
		/** Method DirectoryToList return the name of the actual directory that will be listed*/
		
		StringTokenizer set=new StringTokenizer(Fold,"/");
		String ActualDirectory="";
		int cont=set.countTokens();
		
		if(!set.hasMoreTokens()){
			return Fold;
		}else
		{
		Vector DirectoryParse=new Vector();
		DirectoryParse.setSize(cont);
		
		try{
	
			for(int j=0;j<cont;j++){
	
			DirectoryParse.addElement(set.nextToken());
			}
			
		ActualDirectory=DirectoryParse.lastElement().toString();
		}catch(NoSuchElementException nsee){}
		
		return ActualDirectory;
		}
	}
	
	public void Listdir(String directory,OutputStream pr,String HOST_NAME_LINK,String Icons_Path)throws IOException  {
		
		File DIR_FILE=new File(directory);
			
		String File_Separ_String=System.getProperty("file.separator");
		String ActualDir=this.DirectoryToList(this.getDirectory_Name());
		
		if(DIR_FILE.isDirectory()){
			
		pr.write(new String("<html><head><h1>"+HOST_NAME_LINK+"- /"+this.getDirectory_Name()+"</h1></head><body><HR><BR>").getBytes());
		
		String[] File_List=new String[DIR_FILE.list().length];
		
		File_List=DIR_FILE.list();
		
		//send The Heading => Name Last Modified Size
		
		pr.write(new String("<Table border=0>").getBytes());
		pr.write(new String("<TR>").getBytes());
		pr.write(new String("<TD width='50'> </TD>").getBytes());
		pr.write(new String("<TD><strong>Name</strong></TD>").getBytes());
		pr.write(new String("<TD align='center'><strong>Last Modified</strong></TD>").getBytes());
		pr.write(new String("<TD align='center' width='50'><strong>Size</strong></TD>").getBytes());
		pr.write(new String("</TR>").getBytes());
		
		for(int i=0;i<File_List.length;i++){
			
			pr.write(new String("<TR>").getBytes());
			
			if(new File(directory+File_Separ_String+File_List[i]).isDirectory()){
				
				//List sub-directories founded into the current directory
										
				if(File_List[i].equals("icons")){
					
				/** if the actual directory is icons , we send a blank cells*/
				
				pr.write(new String("<TD width='50'></TD>").getBytes());
				pr.write(new String("<TD></TD>").getBytes());
				pr.write(new String("<TD align='center' width='300'></TD>").getBytes());
				pr.write(new String("<TD align='center' width='50'></TD>").getBytes());
				}
				else{
					/** Listing directories*/
				pr.write(new String("<TD width='50'><img src="+Icons_Path+"dir.gif width='22' height='22'></TD>").getBytes());
				pr.write(new String("<TD><a href='"+ActualDir+'/'+File_List[i]+"'>"+File_List[i]+"</a>"+"</TD>").getBytes());
				pr.write(new String("<TD align='center' width='300'>"+new Date(new File(directory+File_Separ_String+File_List[i]).lastModified()).toString()+"</TD>").getBytes());
				pr.write(new String("<TD align='center' width='50'><font color=red><strong>&lt;DIR&gt;</strong></font></TD>").getBytes());
				
				}//fin test
				
				}
				
			else{
				
				//Listing files founded into the directory
				
				if(this.isCgiProg(directory+File_Separ_String+File_List[i]))
				{
					pr.write(new String("<TD width='50'><img src="+Icons_Path+"Filecgi.gif width='22' height='22'></TD>").getBytes());
				}
				else
				{
					pr.write(new String("<TD width='50'><img src="+Icons_Path+"File.gif width='22' height='22'></TD>").getBytes());
				}
										
				pr.write(new String("<TD><a href='"+ActualDir+'/'+File_List[i]+"'>"+File_List[i]+"</a>"+"</TD>").getBytes());
				pr.write(new String("<TD  align='center' width='300'>"+new Date(new File(directory+File_Separ_String+File_List[i]).lastModified()).toString()+"</TD>").getBytes());			
				pr.write(new String("<TD align='center' width='50'><font color=red><strong>"+String.valueOf(new File(directory+File_Separ_String+File_List[i]).length())+"</font></strong></TD>").getBytes());	
				}
				pr.write(new String("</TR>").getBytes());
			
			}
		}
		pr.write(new String("</Table>"+"<Hr><BR>AssoudiWebServer1.5 at "+HOST_NAME_LINK+" port 10181</body></html>").getBytes());
		
		
	}
}
	