package DesignPattern.Learn.Observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopicSubject implements ISubject {

	private List<IObserver> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public MyTopicSubject() {
		this.observers = new ArrayList<IObserver>();
	}

	public void register(IObserver obj) {
		if (obj == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
	}

	public void unregister(IObserver obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	public void notifyObservers() {
		List<IObserver> observersLocal = null;
		// synchronization is used to make sure any observer registered after
		// message is received is not notified
		synchronized (MUTEX) {
			if (!changed) {
				return;
			}
			observersLocal = new ArrayList<IObserver>(this.observers);
			this.changed = false;
		}
		for (IObserver obj : observersLocal) {
			obj.update();
		}

	}

	public Object getUpdate(IObserver obj) {
		return this.message;
	}

	// method to post message to the topic
	public void postMessage(String msg) {
		System.out.println("Message Posted to Topic:" + msg);
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}

}
