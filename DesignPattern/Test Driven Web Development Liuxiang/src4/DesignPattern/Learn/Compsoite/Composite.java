package DesignPattern.Learn.Compsoite;

import java.util.ArrayList;
import java.util.List;

//Composite
public class Composite implements Component {

	private List<Component> childComponents = new ArrayList<Component>();

	public void add(Component component) {
		childComponents.add(component);
	}

	public void remove(Component component) {
		childComponents.remove(component);
	}

	public void show() {
		for (Component component : childComponents) {
			component.show();
		}
	}
}
