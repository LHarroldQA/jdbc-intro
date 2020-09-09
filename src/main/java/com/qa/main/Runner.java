
package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		DatabaseConnector db = new DatabaseConnector();
		
		String action = "";
		action = getAction();
		
		try {
            do {
                if(action.equals("create")) {
                    System.out.println("Please enter a forename");
                    String forename = scan.nextLine();
                    System.out.println("Please enter a surname");
                    String surname = scan.nextLine();
                    db.createActor(forename, surname);
                } else if(action.equals("read")){
                	System.out.println("Would you like to read all or one actor?");
                	String readChoice = scan.nextLine();
                	if(readChoice.equals("all")) {
                		db.readAllActors();
                	} else if(readChoice.equals("one")) {
                		System.out.println("Please enter the id of the actor you want to read");
                		int readId = scan.nextInt();
                		db.readActor(readId);
                	} else {
                		System.out.println("Invalid input");
                	}
                } else if(action.equals("update")) {
                    System.out.println("Please enter the ID of the actor you want to change");
                    int updateId = Integer.parseInt(scan.nextLine());
                    System.out.println("Please enter the new forename");
                    String newForename = scan.nextLine();
                    System.out.println("Please enter the new surname");
                    String newSurname = scan.nextLine();
                    db.updateActor(updateId, newForename, newSurname);
                } else if (action.equals( "delete")) {
                    System.out.println("Please enter the ID of the actor you want to delete");
                    int deleteId = scan.nextInt();
                    db.deleteActor(deleteId);
                } else {
                    System.out.println("Invalid input");
                }
                action = getAction();
            } while (!action.equals("exit"));
            System.out.println("bye");
        } finally {
            scan.close();
            db.close();
        }
	}
		
	private static String getAction() {
		System.out.println("Please enter the CRUD method you want");
		return scan.nextLine();
	}
}

