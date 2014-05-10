package liuxiangwin.JavaObjectTrainningtest.ContactWithFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Contact implements Serializable, Comparable {
	private String _fistName;
	public String get_fistName() {
		return _fistName;
	}

	public String get_lastName() {
		return _lastName;
	}



	public String get_emailAdrress() {
		return _emailAdrress;
	}



	private String _lastName;
	private String _emailAdrress;

	protected Contact(String fn, String ln, String email) {
		this._fistName = fn;
		this._lastName = ln;
		this._emailAdrress = email;

	}

	public String toString() {
		return _fistName + " " + _lastName + " " + _emailAdrress;

	}

	public int compareTo(Object contact) {

		if (contact instanceof Contact) {
			int result = _lastName.compareTo(((Contact) contact)._lastName);
			return result == 0 ? _lastName
					.compareTo(((Contact) contact)._lastName) : result;
		}
		return -1;

	}

	public boolean equals(Object contact) {
		return this.compareTo(contact) == 0;
	}


    public static Contact  GetContactInput()
    {
        try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("\n" + " Please Entry you Frist Name");
			String fName = reader.readLine();
			System.out.println("\n" + " Please Entry you Last Name");
			String lName = reader.readLine();
			System.out.println("\n" + " Please Entry you Email Address");
			String email = reader.readLine();
			return new Contact(fName, lName, email);
		} catch (Exception e) {
		    return null;
		}
    	
    }


}
