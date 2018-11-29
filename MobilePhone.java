package udemy08_Arraylists_Mobile;

import java.util.*; 

public class MobilePhone {

	private Scanner scan = new Scanner(System.in);
	private Scanner scan2 = new Scanner(System.in);
	private Scanner scan3 = new Scanner(System.in);
	 
	public ArrayList<Contact> contactmain = new ArrayList<Contact>();
	
	public MobilePhone() {
		//this.contactmain = new ArrayList<Contact>();	
	}

	public void add() {
		
		int option = 1;
		int idx;
		String name;
		String number;
		
		while (option == 1){
			
			System.out.print("Enter name, press enter followed by contact phone number :");
			scan2.reset();
			scan3.reset();
			name	= scan2.next();
			number	= scan3.nextLine();
					
			idx = getindex(name);
			
			if (idx>=0) {
				
				System.out.println("Contact name " +name  +" is already available");
			}
			else {
				Contact contactadd = new Contact(name,number);
				this.contactmain.add(contactadd);
				System.out.println("Contact Added !");
			}
			
			System.out.println("Press 1 to add another contact or any key to end add");
			scan.reset();
			option = scan.nextInt();
		}
	
	}
	
	public void Editcontact(String name) {
		
		int idx = getindex(name);
		
		if (idx>=0) {
			
			Searchname(name);
			System.out.println("Press 1 for name update, 2 for number update");
			
			scan.reset();
			int option = scan.nextInt();
			String contactname;
			String contactnumber;
			
			do {
				
				if ( option == 1) {
					System.out.print("Enter Name :");
					scan2.reset();
					contactname = scan2.next();
					this.contactmain.get(idx).setName(contactname);
					//this.contactmain.set(idx, null).setName(scan2.nextLine()); 
					
					System.out.println("Name Updated ");
				}
				else if (option == 2) {
					System.out.print("Enter Number :");
					scan3.reset();
					contactnumber = scan3.nextLine();
					this.contactmain.get(idx).setNumber(contactnumber);
					System.out.println("Number Updated ");
				}
			
				else {
					System.out.print("Enter a valid option");
				}
				
				System.out.println("Press 1: name update, 2: number update, 3: EXIT ");
				if (option == 3) {
					break;
				}
				
				scan.reset();
				option = scan.nextInt();
				
			}while (option <=2);
		}
		else {
			System.out.println("No results ");
		}
	}
	
	//Search name
	public void Searchname(String name) {
		int idx = getindex(name) ;
		if ( idx >= 0) {
			System.out.println("Contact Found!	: ");
			System.out.println("Contact Name	:" +this.contactmain.get(idx).getName());
			System.out.println("Contact Number	:" +this.contactmain.get(idx).getNumber());
		}
		else {
			System.out.println("No results ");
		}
	}
	
	public void Deletecontact(String name) {
		int idx = getindex(name);
		
		if (idx>=0) {
			this.contactmain.remove(idx);
			System.out.println("Contact Deleted!	: ");
		}else {
			System.out.println("Contact not present!	: ");
		}
			
	}
	
	public void printall() {
			for (int i=0;i<contactmain.size();i++) {
				System.out.println(i +" : " +contactmain.get(i).getName() +" - " +contactmain.get(i).getNumber());
			}
	}
	
	//private int getindex(Contact contactget) {
	//	return this.contactmain.indexOf(contactget);
	//}
	
	public boolean isEmpty() {
		if (contactmain.size()==0) {
			System.out.println("Contacts is Empty !");
			return true;
		}
		return false;
	}
	
	private int getindex(String contactname) {
		
		for (int i=0;i<contactmain.size();i++) {
			if (this.contactmain.get(i).getName().equalsIgnoreCase(contactname.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	
	public Contact querycontact(String name) {
		
		if (getindex(name)>=0) {
			return this.contactmain.get(getindex(name));
		}
	
		return null;
	}
	
}
