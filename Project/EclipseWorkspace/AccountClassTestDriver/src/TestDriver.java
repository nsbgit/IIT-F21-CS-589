/**
 * 
 */

/**
 * @author sukanta
 *
 */

import java.util.Scanner;
import java.util.ArrayList;

public class TestDriver {

	private static final String strLine = "_____________________________________________________________________";
//	private static Scanner scanner;
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String choice = "";
		TestDriverMethod currentMethodCalled = null;
		TestingOrientedMethod currentTestingOrientedMethodCalled = null;
		ArrayList<String> methodsCalled = new ArrayList<String>();
		String parameters = "";
		int returnedValue = -2;
		
		account acc = new account();

		// show welcome message
		// TODO uncomment
		//showWelcomeMessage();

		// show menu
		do {
			choice = showMenu();
			System.out.println("\nYour choice is : " + choice);
			currentMethodCalled = null;
			currentTestingOrientedMethodCalled = null;
			parameters = "";
			returnedValue = -2;
			
			switch (choice) {
				case "0": // OPEN
					currentMethodCalled = TestDriverMethod.OPEN;
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					int accountNumber = getInputFromUser("Enter Account#");
					int pin = getInputFromUser("Enter PIN");
					int balance = getInputFromUser("Enter initial balance");
					returnedValue = acc.open(accountNumber, pin, balance);
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					pressAnyKeyToContinue();
					break;
				case "1": // DEPOSIT
					currentMethodCalled = TestDriverMethod.DEPOSIT;
					int depositAmount = getInputFromUser("Enter Deposit Amount");
					returnedValue = acc.deposit(depositAmount);
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					pressAnyKeyToContinue();
					break;
				case "2": // WITHDRAW
					currentMethodCalled = TestDriverMethod.WITHDRAW;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
				case "3": // BALANCE
					currentMethodCalled = TestDriverMethod.BALANCE;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
				case "4": // LOCK
					currentMethodCalled = TestDriverMethod.LOCK;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
				case "5": // UNLOCK
					currentMethodCalled = TestDriverMethod.UNLOCK;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
				case "6": // LOGIN
					currentMethodCalled = TestDriverMethod.LOGIN;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
				case "7": // PIN
					currentMethodCalled = TestDriverMethod.PIN;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
				case "8": // LOGOUT
					currentMethodCalled = TestDriverMethod.LOGOUT;
					System.out.println("\nThe valu returned by the method is: " + returnedValue + "\n");
					printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
					
					pressAnyKeyToContinue();
					break;
					
				
				case "a": // SHOW BALANCE
					break;
				case "b": // SHOW STATE
					break;
				default:
					System.out.println("DEFAULT");
			}
			
			TestSuiteData.add(currentMethodCalled, parameters, null, null, null);
			
		} while (!choice.equals("q"));
		
		System.out.println("Quitting Account Driver...");
		System.out.println(strLine + "\n\t\tTHANK YOU!!!\n" + strLine);
		System.out.println(String.format("Test: %s", TestSuiteData.getTestCase()));
	}

	private static int getInputFromUser(String message) {
		// TODO Auto-generated method stub
		int data = -1;
		boolean hasError = false;
		
		System.out.println(message + ":\n");
		
		do {
			if (hasError) {
				System.out.println("Invalid Input!!!");
				System.out.println("Please try again...");
				System.out.println(message + ":\n");
			}
			
			try {
				data = Integer.parseInt(message);
			}
			catch (Exception e) {
				hasError = true;
			}
		}while (hasError);
		
		return data;
	}

	private static void printCurrentMethodInfo(TestDriverMethod currentMethodCalled,
			TestingOrientedMethod currentTestingOrientedMethodCalled) {
		// TODO Auto-generated method stub
		System.out.println("\n\n");
		if (currentMethodCalled != null) {
			System.out.println("Class: Account");
			System.out.println("Type: Class Method");
			System.out.println("Method: " + currentMethodCalled);
		}
		
		if (currentTestingOrientedMethodCalled != null) {
			System.out.println("Class: Account");
			System.out.println("Type: Testing - Oriented Method");
			System.out.println("Method: " + currentTestingOrientedMethodCalled);
		}
	}

	private static String showMenu() {
		// TODO Auto-generated method stub
		int i = 0;
		char j= 'a';
		
		// Show Driver Method for the Account Class
		System.out.println("\n\nDriver for the Account"
				+ "\n" + strLine + "\n");
		
		for (TestDriverMethod testDriverMethod : TestDriverMethod.values()) { 
		    System.out.println(String.format("\t%d. %s", i++, testDriverMethod));
		}
		
		// Show Testing-Oriented Method for Account Class
		System.out.println("\n\nTesting-Oriented Methods"
				+ "\n" + strLine + "\n");
		for (TestingOrientedMethod testingOrientedMethod : TestingOrientedMethod.values()) { 
		    System.out.println(String.format("\t%c. %s", j++, testingOrientedMethod).replace('_', ' '));
		}
		
		System.out.println(String.format("\n\n\t%c. %s", 'q', "Quit Account Driver"));
		System.out.println("\n\nEnter you choice:\n");
		
		String choice = scanner.nextLine().toLowerCase();
		
		// Validate Input
		while(!validateInput(choice, i, j)) {
			System.out.println("\n\nINVALID INPUT!!!");
			System.out.println("Enter you choice:\n");
			
			choice = scanner.nextLine().toLowerCase();
		}
		
		return choice;
	}

	private static boolean validateInput(String choice, int i, char j) {
		// TODO Auto-generated method stub
		boolean isValidInput = false;
		int ch = -1;
		try {
			ch = Integer.parseInt(choice);
			isValidInput = (ch >= 0 && ch < i);
		}
		catch (Exception e) {
			if (choice.length() == 1) {
				char c = choice.charAt(0);
				isValidInput = (c >= 'a' && c < j) || (c == 'q'); 
			}
		}
		return isValidInput;
	}
		
	@SuppressWarnings("unused")
	private static void showWelcomeMessage() {
		// TODO Auto-generated method stub
		System.out.println("\t\tCS 589; Fall 2021");
		System.out.println("\t\t     PROJECT");
		System.out.println("\t\t  Sukanta Sharma");
		System.out.println("\t\t     A2042623");
		System.out.println("\n" + strLine + "\n" + strLine + "\n\n");
			
		pressAnyKeyToContinue();
		
	}

	private static void pressAnyKeyToContinue() {
		// TODO Auto-generated method stub
		System.out.println("\nPress Enter key to continue...");
		try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}
	}

}
