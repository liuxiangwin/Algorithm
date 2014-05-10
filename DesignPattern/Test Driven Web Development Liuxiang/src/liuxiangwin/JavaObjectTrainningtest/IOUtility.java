package liuxiangwin.JavaObjectTrainningtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class IOUtility {

	public static void gzip(String strSrc, String strDst) throws IOException {
		FileInputStream fileIn = new FileInputStream(strSrc);

		GZIPOutputStream output = new GZIPOutputStream(new FileOutputStream(
				strDst));

		byte[] databuffer = new byte[1024];

		int byteRead;

		while ((byteRead = fileIn.read(databuffer)) != -1) {
			output.write(databuffer, 0, byteRead);
		}

		fileIn.close();
		output.close();

	}

	public static void main(String[] args) throws IOException {
		IOUtility.gzip(args[0], args[1]);
		
	}

}
