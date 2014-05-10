package liuxiangwin.JavaObjectTrainningtest.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Count implements Serializable {

	private Date dropDate;

	public Date getDropDate() {
		return dropDate;
	}

	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}

	public CountType getCountTYpe() {
		return countTYpe;
	}

	public void setCountTYpe(CountType countTYpe) {
		this.countTYpe = countTYpe;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	private CountType countTYpe;

	private String machine;

	enum CountType {
		SoftCount, HardCount, Ticket
	}

	public Count(String machine, CountType countType, Date dropDate) {
		this.machine = machine;
		this.countTYpe = countType;
		this.dropDate = dropDate;
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Date dropDate = new Date();
		String machine = "Beijng Casino";
		Count count = new Count(machine, CountType.SoftCount, dropDate);
		// This serialization the count object

		FileOutputStream fos = new FileOutputStream("CountInfo.ser");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(count);
		oos.flush();
		oos.close();

		// Read and invocation the serializalied object from persistence
		// file

		FileInputStream fis = new FileInputStream("CountInfo.ser");
		if (fis == null) {
			System.out.println("We can't find the persistence Count Object");
		}

		else {

			ObjectInputStream ois = new ObjectInputStream(fis);

			Count countGet = (Count) ois.readObject();

			System.out.println("The Count Class is " + countGet.getClass());

			System.out.println("The Machie is " + countGet.getMachine());

			System.out.println("The Count Type is " + countGet.getCountTYpe());

			System.out.println("The Drop Date  is " + countGet.getDropDate());

		}

	}

}
