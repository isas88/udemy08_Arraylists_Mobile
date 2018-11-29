package udemy08_Arraylists_Mobile;

public class Contact {

	private String name;
	private String number;
	
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	/*

	public static Contact createContact(String name, String number) {
		return new Contact(name,number);
		
		
	}
	*/
	
}
