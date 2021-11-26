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
		ArrayList<String> methodsCalled = new ArrayList<String>();
		String parameters = "";
		//TestSuiteData testSuiteData = new TestSuiteData();

		// show welcome message
		// TODO uncomment
		//showWelcomeMessage();

		// show menu
		do {
			choice = showMenu();
			System.out.println("\nYour choice is : " + choice);
			currentMethodCalled = null;
			parameters = "";
			
			switch (choice) {
				case "0": // OPEN
					currentMethodCalled = TestDriverMethod.OPEN;
					break;
				case "1": // DEPOSIT
					currentMethodCalled = TestDriverMethod.DEPOSIT;
					break;
				case "2": // WITHDRAW
					currentMethodCalled = TestDriverMethod.WITHDRAW;
					break;
				case "3": // BALANCE
					currentMethodCalled = TestDriverMethod.BALANCE;
					break;
				case "4": // LOCK
					currentMethodCalled = TestDriverMethod.LOCK;
					break;
				case "5": // UNLOCK
					currentMethodCalled = TestDriverMethod.UNLOCK;
					break;
				case "6": // LOGIN
					currentMethodCalled = TestDriverMethod.LOGIN;
					break;
				case "7": // PIN
					currentMethodCalled = TestDriverMethod.PIN;
					break;
				case "8": // LOGOUT
					currentMethodCalled = TestDriverMethod.LOGOUT;
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
