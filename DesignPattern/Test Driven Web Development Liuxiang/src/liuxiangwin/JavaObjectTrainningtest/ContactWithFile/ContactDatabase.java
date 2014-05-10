package liuxiangwin.JavaObjectTrainningtest.ContactWithFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ContactDatabase implements Serializable {
	private File _File = new File("ContactDB.txt");

	private HashMap<String,Contact> _hm = new HashMap<String,Contact>();
    /**
     * This is Construtor and initialization the File DB
     */
	public ContactDatabase() {
		if (this._File.exists()) {
			try {
				ObjectInputStream objIputStream = new ObjectInputStream(
						new FileInputStream(_File));
				_hm = (HashMap<String,Contact>) objIputStream.readObject();
				objIputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	public void Add(Contact contact) {
		_hm.put(contact.get_fistName(), contact);

	}

	public void Save() {
		try {
			System.out.println("====Saving You Contact Information=====");
			ObjectOutputStream ooStream = new ObjectOutputStream(
					new FileOutputStream(_File));
			//The output stream write the object to the file
			ooStream.writeObject(_hm);
			System.out.println("Saving Complete");
			ooStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@SuppressWarnings("unchecked")
	public void Show_Contact() {
		for(Iterator iterator=_hm.keySet().iterator();iterator.hasNext();)
		{
			String key=(String)iterator.next();
			System.out.println(((Contact)_hm.get(key)).get_fistName());
			System.out.println(((Contact)_hm.get(key)).get_lastName());
			System.out.println(((Contact)_hm.get(key)).get_emailAdrress());
		}
		
	
	}
}
