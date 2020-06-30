package ContactKeeper;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * Created by dev on 28/08/15.
 */
public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}

	Scanner scan = new Scanner(System.in);

	//String findContact() used
	public boolean addNewContact(Contact newContact) {//When checking to see if a name already exists use boolean
		if(findContactViaName(newContact.getName()) >=0) {
			System.out.println("Contact is already on file");
			return false;
		}

		myContacts.add(newContact);
		return true;

	}
	//findContact by position used here as your modiying a contact based on the position
	public boolean updateContact(Contact oldContact, Contact newContact) {//llok closely at the parameters here and in the main
		int foundPosition = findContact(oldContact);//Finding the index position of the old contact and replacing that value with the new contact
		if(foundPosition <0) {
			System.out.println(oldContact.getName() +", was not found.");
			return false;
		}//else

		this.myContacts.set(foundPosition, newContact);//set the new contact at the old position
		System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
		return true;
	}

	public boolean removeContact(Contact contact) {
		int foundPosition = findContact(contact);
		if(foundPosition <0) {
			System.out.println(contact.getName() +", was not found.");
			return false;
		}
		this.myContacts.remove(foundPosition);//remove is by "
		System.out.println(contact.getName() + ", was deleted.");
		return true;
	}

	//NB ALWAYS USE 2 FIND METHODS. 1 by position and 1 by name
	private int findContact(Contact contact) {
		System.out.println("First findMethod activated");
		return this.myContacts.indexOf(contact);//This returns an int which shows us index position for that contract OBJECT.
	}

	//Takes in a name and sees if the name is there
	public int findContactViaName(String contactName) {//Loops through all names in list. Its set to private because its only gonna be used in this class
		for(int i=0; i<this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);//Loop through all contacts
			if(contact.getName().equals(contactName)) {//extract name and seeif it equals the name being searched
				return i;/*Return the index of the name so we can update 
it via modify or in the case of addcontact were testing to see if that number is greater than 0 to see if its on file or not 
If its greater than 0 then it means its on the file so we cant add it as there would be a dupicate*/
			}
		}
		return -1;//If the name wasnt found, return -1
	}

	public String queryContact(Contact contact) {//Accepts  a contacts record
		if(findContact(contact) >=0) {/*If findContact returns a number greater than 0 
        	than it is on file */
			return contact.getName();
		}
		return null;
	}
    
	
	public Contact queryContactN(String name) {//**
		int position = findContactViaName(name);
		if(position >=0) {
			return this.myContacts.get(position);
		}

		return null;    
	}

	public void printContacts() {
		System.out.println("Contact List");
		for(int i=0; i<this.myContacts.size(); i++) {
			System.out.println((i+1) + "." +
					this.myContacts.get(i).getName() + " -> " +//get all name values(i)
					this.myContacts.get(i).getPhoneNumber());//get all phone number values(i)
		}//i = an increment which gets a name and number. The size of i = the size of the list

	}

	public int findContactthroughnumber(long num) {//get index position of phone number
		for(int i = 0; i<myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if(contact.getPhoneNumber()==(num)) {
				return i;
			
			}
		}
		return -1;
	}

	public Contact Search(long num) {
		int position = findContactthroughnumber(num);//position = element position of long num
		if(position >=0) {
			return this.myContacts.get(position);//return the value associated with the int
		}

		return null;    
	}
		
		

	}





	/*public void printContacts() {
		for(Contact c: myContacts) {
			System.out.println(c.getName() + c.getPhoneNumber());*/



















