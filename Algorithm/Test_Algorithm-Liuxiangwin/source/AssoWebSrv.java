/*
 *@author  Assoudi Othmane
 *@version 1.5
 *@since   7 june 2002
 * 
 * AssoWebSrv.java - AssoWebSrv the main Server program
 *
 * This program is free software; you can redistribute it and/or
 * modify it.
 *
 *
 * For any additional help please contact : a_othmane@hotmail.com
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import webServer.Settings;
import webServer.util.log;

class ServeurWeb implements Runnable {

	private String Server_root = ""; // server root path
	private String Server_Home = ""; // server home page
	private String Server_Icons_Path = ""; // contain the server Icons Path
	private Socket soc; // Socket that will receive or send data
	private String RequestFromClient = ""; // contain the request String ex: GET
											// /someFile HTTP/1.1
	private String File_Name = ""; // contain the requested File
	private String DIR_HTTP = ""; // contain the name of current directory
	private String NOM_HOTE = "";// Hold the Hostname
	private int position1 = 0;
	private int position2 = 0;
	private BufferedReader in;
	private PrintWriter out;

	// constructor ServeurWeb
	public ServeurWeb(Socket s, String Sroot, String Shome, String Sicons,
			String Slog) throws UnknownHostException, IOException {

		try {
			// initailzing the class Fileds
			Server_root = Sroot;
			Server_Home = Shome;
			Server_Icons_Path = Sicons;

			soc = s;
			// Getting the String sent by client
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			// String to be sent by the server
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					soc.getOutputStream())), true);

			NOM_HOTE = soc.getInetAddress().getLocalHost().toString();

			run(); // invoking method run() to execute the thread code

		} catch (IndexOutOfBoundsException ie) {
			// handling Error :Bad Request

			log lg = new log();
			// call LogEvent Method From Class log
			lg.LogEvent(Slog, "BAD REQUEST", 2);

		}

	}

	public String DecodeURL(String pth) {
		/*
		 * DecodeURL Method used to Decode URL's having space in their body ex:
		 * /File%20Having%20space.htm = /File Having space.htm
		 */
		String pathWithSpace = "";

		// testing if the request file contain %20
		if (pth.indexOf("%20") == -1) {

			return pth; // returning the same file name
		}

		else {
			StringTokenizer set = new StringTokenizer(pth, "%20");

			int cont = set.countTokens();

			if (!set.hasMoreTokens()) {

				return pth;
			} else {
				try {

					for (int j = 0; j < cont; j++) {

						/*
						 * we build a string replacing %20 with space as the
						 * original File
						 */

						pathWithSpace += set.nextToken() + " ";
					}
				} catch (NoSuchElementException ne) {
				}

			}
			return pathWithSpace.substring(0, pathWithSpace.length() - 1);
		}
	}

	public synchronized void run() {

		try {
			// initializing in & out with String received from client and String
			// that will be sent to it
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					soc.getOutputStream())), true);

		} catch (IOException ioe) {
		}

		try {

			// Getting The System File Separator ex : on windows \ ,on linux /
			String FILE_SEPERATOR = System.getProperty("file.separator");

			// Getting the request string sent by client
			RequestFromClient = in.readLine();

			position1 = RequestFromClient.indexOf("/") + 1;
			position2 = RequestFromClient.indexOf("HTTP") - 1;

			// file_Name contain the path of requested file
			File_Name = Server_root
					+ FILE_SEPERATOR
					+ RequestFromClient.substring(position1, position2)
							.replace('/', '\\');

			// Decoding the file
			File_Name = this.DecodeURL(File_Name);

			// Setting the Name of actual Directory
			DIR_HTTP = RequestFromClient.substring(position1, position2).trim();

			System.out.println("[CLIENT REQUEST]: " + RequestFromClient);
			System.out.println("[REQUESTED FILE]: " + File_Name);
			System.out.println("*********************************************"
					+ "**********************************\n");

			File f = new File(File_Name);
			webServer.FileRead fl = new webServer.FileRead();

			fl.setDirectory_Name(DIR_HTTP);
			// testing if the requested file is a directory
			if (f.isDirectory()) {

				if (new File(File_Name + Server_Home).exists())
					// if the welcome page exist we will send its content
					fl.ReadFile(File_Name + Server_Home, NOM_HOTE,
							soc.getOutputStream(),
							RequestFromClient.substring(position1, position2));
				else
					fl.Listdir(File_Name, soc.getOutputStream(), NOM_HOTE,
							Server_Icons_Path);
				// otherwise we list the content of the directory
			} else {
				// if the requested file is a file we read its content and we
				// sent it to the client almost (browser)
				fl.ReadFile(File_Name, NOM_HOTE, soc.getOutputStream(),
						RequestFromClient.substring(position1, position2));
			}

		} catch (IOException ioe) {

		} finally {
			try {
				soc.close(); // we always close the socket to free the bandwidth
			} catch (IOException ioe) {
			}
		}
	}
}// End class ServeurWeb

public class AssoWebSrv {

	// Defining AssoWebSrv variables

	private static int SERVER_PORT;
	private static String SERVER_ROOT;
	private static String SERVER_HOMEPAGE;
	private static String SERVER_ICONS;
	private static String SERVER_LOG;

	public void getServerDirectives() throws IOException {

		Settings set = new Settings();
		// calling Method readConfFile From class Setting
		set.readConfFile("c:\\AssWebSrv\\conf\\AssoWebSrv.txt");

		/*
		 * Set value of Variables => will be the arguments of ServeurWeb
		 * Constructor
		 */

		this.SERVER_PORT = set.getServerPort();
		this.SERVER_ROOT = set.getServerRoot();
		this.SERVER_HOMEPAGE = set.getServerHomePage();
		this.SERVER_ICONS = set.getServerIcons();
		this.SERVER_LOG = set.getServerLog();

	}

	public void GeneralInfos() {
		// Method GeneralInfos collecting some System Informations

		// Getting The System User Connected informations
		String USER_HOME = System.getProperty("user.home");
		String USER_NAME = System.getProperty("user.name");
		String USER_TIMEZONE = System.getProperty("user.timezone");

		// Getting The Operating System informations
		String OS_NAME = System.getProperty("os.name");
		String OS_ARCH = System.getProperty("os.arch");
		String OS_VERS = System.getProperty("os.version");

		System.out.println("\nAssoudiWebServer1.5 WEB SERVER \n");
		System.out.println("[PLATFORM]");
		System.out.println("\t|_NAME=" + OS_NAME + "");
		System.out.println("\t|_VERSION=" + OS_VERS + "");
		System.out.println("\t|_ARCHITECTURE=" + OS_ARCH + "");

		System.out.println("\n");

		System.out.println("[USER]");
		System.out.println("\t|_NAME=" + USER_NAME + "");
		System.out.println("\t|_HOME_DIRECTORY=" + USER_HOME + "");
		System.out.println("\t|_TIMEZONE=" + USER_TIMEZONE + "");

		System.out.println("\n");

		System.out.println("[SERVER STATE]: STARTED...\n");

	}

	public static void main(String[] args) throws IOException {
		// creating an instance of type AssoWebSrv
		AssoWebSrv Assws = new AssoWebSrv();
		Assws.getServerDirectives(); // initialize The Directives
		Assws.GeneralInfos(); // Show General Infos about OS & USER

		try {
			// creating a new ServerSocket Listning on SERVER_PORT
			ServerSocket S = new ServerSocket(SERVER_PORT);

			try {
				while (true) {
					// returning an established socket via the ServerSocket
					// accept method
					Socket sock = S.accept();

					try {
						System.out.println("[REMOTE HOST]: "
								+ sock.getInetAddress().toString());
						System.out.println("[LISTNING ON PORT]: "
								+ sock.getPort());

						// calling the ServeurWeb constructor
						new ServeurWeb(sock, SERVER_ROOT, SERVER_HOMEPAGE,
								SERVER_ICONS, SERVER_LOG);

					} catch (IOException e) {
						sock.close();// always close the socket
					}
				}
			} finally {
				S.close(); // always close the ServerSocket
			}
		} catch (BindException B) {
			// handling exception generated if they are already running server
			System.out.println("SERVER Already Running");
			System.exit(0);
		}

	}
}// End class AssoWebSrv