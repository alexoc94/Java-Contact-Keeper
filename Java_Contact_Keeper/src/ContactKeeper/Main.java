package ContactKeeper;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("0852738330");//The purpose of this seems to be to get its methods
	public static void main(String[] args) {
		boolean quit = false;
		while(quit != true) {
			printInstructions();
			int choice = scan.nextInt();
			scan.nextLine();

			switch(choice) {
			case 1:
				turnOff();
				quit = true;
				break;

			case 2:
				addContact();
				break;

			case 3:
				updateContact();
				break;

			case 4:
				removeContact();
				break;

			case 5:
				searchContactRI();
				break;
				
			case 6:
				mobilePhone.printContacts();
				break;


			case 7:
				printInstructions();
				break;
				

			case 8:
				search();
				break;


			}
		}



	}

	public static void printInstructions() {
		System.out.println("\nAvailable actions:\nEnter");
		System.out.println("-1 to quit");
		System.out.println("-2 to add Contact");
		System.out.println("-3 to Update Contact");
		System.out.println("-4 to Remove Contact ");
		System.out.println("-5 to Search Contact");
		System.out.println("-6 to Print Contacts");
		System.out.println("-7 to display instructions");
		System.out.println("-8 to search via number");
		System.out.println("Choose your action: ");
		

	}

	public static void turnOff() {
		System.out.println("Shutting down");


	}

	private static void addContact() {
		System.out.println("Enter Contact Name: ");
		String name = scan.nextLine();
		System.out.println("Enter Contact Number: ");
		long number = scan.nextInt();
		scan.nextLine();
		Contact newContact = Contact.createContact(name, number);
		if(mobilePhone.addNewContact(newContact)) {
			System.out.println("New contact added");
		}else {
			System.out.println("Cannot add, name is already on file");
		}


	}
	private static void removeContact() {
		System.out.println("Enter existing contact name");
		String name = scan.nextLine();
		Contact existingContact = mobilePhone.queryContactN(name);//Dont think of find as search but think of query as search
		if(existingContact == null) {
			System.out.println("Contact not found");
			return;
		}
		if(mobilePhone.removeContact(existingContact)) {//Note your using the parameters of Remove Contact
			System.out.println("Deletion complete");
		}else {
			System.out.println("error deleting contact");

		}

	}

	private static void updateContact() {
		System.out.println("Enter existing contact name");
		String name = scan.nextLine();
		Contact existingContact = mobilePhone.queryContactN(name);//return index position for name. also a number 1
		if(mobilePhone.queryContactN(name)==null) {
			System.out.println("Contact does not exist");
			return;
		}
		System.out.println("Enter name");
		String contactName = scan.nextLine();
		System.out.println("Enter number");
		long contactNumber = scan.nextInt();
		scan.hasNextLine();
		Contact newContact = Contact.createContact(contactName, contactNumber);
		if(mobilePhone.updateContact(existingContact, newContact)){//if its true then the method was a success
			System.out.println("Update complete");

		}else {
			System.out.println("error updating contact");
		}

	}
	
	public static void searchContactRI() {
		System.out.println("Enter name of Contact you want searched");
		String name = scan.nextLine();
		Contact existingContact = mobilePhone.queryContactN(name);
		if(existingContact == null) {
			System.out.println("Contact not found");
			return; 
		}System.out.println("Name" + existingContact.getName() + "phoneNumber" + existingContact.getPhoneNumber());
			
		}
	
	public static void search() {
		System.out.println("Enter number your looking for");
		int num = scan.nextInt();
		scan.nextLine();
		Contact existingContact = mobilePhone.Search(num);
		if(existingContact == null) {
			System.out.println("Contact not found");
			return; 
		}System.out.println("Name" + existingContact.getName() + "phoneNumber" + existingContact.getPhoneNumber());
			
		}
	
		






}
