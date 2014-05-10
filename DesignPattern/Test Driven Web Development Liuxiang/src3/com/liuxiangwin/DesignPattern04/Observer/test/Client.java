package com.liuxiangwin.DesignPattern04.Observer.test;

public class Client {

	/**
	 * The Observer pattern is widely used in blog sites and various software
	 * systems¡ª Flickr, cyber-dating web sites, and Microsoft Updates are a few
	 * of the places where it is applied. It also has a formal face as the
	 * ¡°publish/subscribe¡± model and the ¡°Model-View-Controller¡± (MVC)
	 * architectural pattern.
	 * 
	 * The Mediator keeps the constraint in the mediator object, deciding how,
	 * who, and when should get the next message. In the Observer, there can be
	 * a protocol between an observer and subject, but it would be more varied
	 * and maintained on both sides. These observations are summarized in
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISubject database = new Database();

		IObserver administrator = new Adminstrator();

		IObserver archiver = new Archiver();

		IObserver boss = new Boss();

		database.registerObserver(administrator);

		database.registerObserver(archiver);

		database.registerObserver(boss);

		database.editRecord("delete", "record 1");
	}

}
