package liuxiangwin.JavaObjectTrainningtest.ExcueExternal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcutionExternal_Application {
	public ExcutionExternal_Application(String cmd) {
		String output;
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			
		
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			while ((output = reader.readLine()) != null) {
				System.out.println("This the External File contet" + output);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new ExcutionExternal_Application(args[0]);

	}
}
