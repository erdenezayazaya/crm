package edu.mum.mpp.zayagerman.client;

/**
 * 
 */
public abstract class Client {

	/**
	 * Default constructor
	 */
	public Client(String firstName, String lastName, String email) {
		if (firstName.equals("")) {
			this.firstName = "";
		} else {
			this.firstName = firstName;
		}

		if (lastName.equals("")) {
			this.lastName = "";
		} else {
			this.lastName = lastName;
		}

		if (email.equals("")) {
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