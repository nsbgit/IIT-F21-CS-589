/**
 * 
 */

/**
 * @author sukanta
 *
 */

import java.util.Scanner;

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

		// show welcome message
		// TODO uncomment
		showWelcomeMessage();

		// show menu
		do {
			showMenu();
		} while (choice.equals("q"));
	}

	private static void showMenu() {
		// TODO Auto-generated method stub
		int i = 0;
		System.out.println("\n\nDriver for the Account"
				+ "\n" + strLine + "\n");
		for (TestDriverMethod testDriverMethod : TestDriverMethod.values()) { 
		    System.out.println(String.format("\t%d. %s", i++, testDriverMethod));
		}
		
		char j= 'a';
		System.out.println("\n\nTesting-Oriented Methods"
				+ "\n" + strLine + "\n");
		for (TestingOrientedMethod testingOrientedMethod : TestingOrientedMethod.values()) { 
		    System.out.println(String.format("\t%c. %s", j++, testingOrientedMethod).replace('_', ' '));
		}
		
		System.out.println(String.format("\n\n\t%c. %s", 'q', "Quit Account Driver"));
		System.out.println("\n\nEnter you choice:\n");
		
		String choice = scanner.nextLine();
		boolean isValidInput = false;
		
		while(!validateInput(choice, i, j)) {
			System.out.println("\n\nInvalid Input!!!");
			System.out.println("Enter you choice:\n");
			
		}
		
		
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
				isValidInput = (c >= 'a' && c < j) || ch == 'q'; 
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
