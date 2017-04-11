package edu.mum.mpp.zayagerman.client;

/**
 * 
 */
public abstract class Client {

	/**
	 * Default constructor
	 */
	public Client(String firstName, String lastName, String email) {
		if (firstName.equals("") || firstName.equals(null)) {
			this.firstName = "";
		} else {
			this.firstName = firstName;
		}

		if (lastName.equals("") || lastName.equals(null)) {
			this.lastName = "";
		} else {
			this.lastName = lastName;
		}

		if (email.equals("") || email.equals(null)) {
			this.email = "";
		} else {
			this.email = email;
		}
	}

	/**
	 * 
	 */
	private int id;

	/**
	 * 
	 */
	private String firstName;

	/**
	 * 
	 */
	private String lastName;

	/**
	 * 
	 */
	private String email;

}