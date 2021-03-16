package com.ioc.demo;

public class Client {
	private Student stud;
	private Address address;

	public Client() {
		this.stud = new Student();
		this.address = new Address();

	}

	public static void main(String[] args) {
		Client client = new Client();
		client.stud.setName("Ambe");
		client.address.setCity("Bhopal");
		client.address.setState("Madhya Pradesh");
		System.out.println(client.stud.getName() + " " + client.address.getCity() + " " + client.address.getState());
	}

}
