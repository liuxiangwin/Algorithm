package com.liuxiangwin.DesignPattern13.Composite.test;

import java.util.Iterator;

public interface IComponent {
	public void addComponent(IComponent component);

	public void operation(String name);

	public void removeComponet(IComponent component);
	
	
	@SuppressWarnings("unchecked")
	public Iterator iterator();

}
