package udemy08_Arraylists_Mobile;
import java.util.Scanner;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan2 = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		MobilePhone phone = new MobilePhone();
		
		int input = 0;
		
		menu();
		
		do{
			scan.reset();
			input = scan.nextInt();
			
			if (input > 7 || input <0) {
				input =999;
			}
			
			if ( input != 3 && input != 0 && input != 6 && input != 999 && input != 7) {
				if (phone.isEmpty()==true) {
					System.out.println("only option 3 is available :");
				}
			}
			
			switch (input) {
						
			case 999:
				System.out.print("Invalid option, re-enter :");
				break;
				
			case 0:
				menu();
				break;
				
			case 1:
				System.out.print("Enter name of the contact:");
				scan2.reset();
				phone.Searchname(scan2.nextLine());
				break;
			
			case 2:
				phone.printall();
				break;
				
			case 3:
				phone.add();
				break;			
				
			case 4:
				System.out.print("Enter name of contact that needs to be updated :");
				scan2.reset();
				String name = scan2.nextLine();
				phone.Editcontact(name);
				break;
			
			case 5:
				System.out.print("Enter name of contact that needs to be deleted:");
				scan2.reset();
				phone.Deletecontact(scan2.nextLine());
				break;
			
			case 7:
				//Note: this case is for reference, no use to this program
				System.out.println("Query Contact");
				Contact sample = phone.querycontact("sasi");
				phone.contactmain.add(sample);
				phone.printall();
				
			case 6:
				break;
				
			default:
				break;
			}
		
			if (input<=5) {
				System.out.print("Enter 0 for menu or select any option :");
			}
			
			
		}while(input != 6);
		
		System.out.println("Pgm End!!!!");

	}
	
	public static void menu() {
		System.out.println("****************Contacts Menu****************");
		System.out.println("Select any of the below given option: ");
		System.out.println("1.	Search contact");
		System.out.println("2.	Display all contacts");
		System.out.println("3.	Add contact");
		System.out.println("4.	Edit contact");
		System.out.println("5.	Delete contact");
		System.out.println("6.	Exit");
		System.out.println("*********************End*********************");
	}
}

