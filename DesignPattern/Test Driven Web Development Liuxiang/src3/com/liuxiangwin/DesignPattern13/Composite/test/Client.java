package com.liuxiangwin.DesignPattern13.Composite.test;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IComponent department=new DepartmentComposite();
		
		Team casinoLinkTeam=new Team("CasinoLink");
		casinoLinkTeam.addComponent(new Employee("Leader",101));
		casinoLinkTeam.addComponent(new Employee("Developer",102));
		casinoLinkTeam.addComponent(new Employee("Scrum Master",103));
		casinoLinkTeam.addComponent(new Employee("ProjectManger",104));
		
		Team interactiveTeam=new Team("Interactive");
		interactiveTeam.addComponent(new Employee("Leader",101));
		interactiveTeam.addComponent(new Employee("Developer",102));
		interactiveTeam.addComponent(new Employee("Scrum Master",103));
		interactiveTeam.addComponent(new Employee("User Designer",104));
		
		Team PAteam=new Team("Interactive PA");
		PAteam.addComponent(new Employee("PA Leader",101));
		PAteam.addComponent(new Employee("PA Tester",101));
		
		interactiveTeam.addComponent(PAteam);
		
		Employee employee=new Employee("IT Adminstrator",901);
		
		
		department.addComponent(casinoLinkTeam);
		department.addComponent(interactiveTeam);
		department.addComponent(employee);
		
		//The Unife interface invoke
		department.operation(null);
	}

}
