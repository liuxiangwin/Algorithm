package liuxiangwin.JavaObjectTrainningtest.ContactWithFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Progam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContactDatabase contactDB = new ContactDatabase();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));	

		System.out
				.println("Please Enter 1 add \n  Enter 3 listAll \n Enter 9 Save");
		for (;;) {
			try {
				int choice = Integer.parseInt(reader.readLine());
				switch (choice) {
				case 1:
					contactDB.Add(Contact.GetContactInput());
					break;

				case 3:
					contactDB.Show_Contact();
					System.out.println("====List All Contact");
					break;

				case 9:
					contactDB.Save();
					System.out.println("Save and quit application");
					return;
				default:
					System.out.println("There is no option here");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}

// }
