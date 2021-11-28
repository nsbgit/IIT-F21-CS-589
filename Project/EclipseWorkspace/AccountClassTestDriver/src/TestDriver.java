
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
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String choice = "";
		TestDriverMethod currentMethodCalled = null;
		TestingOrientedMethod currentTestingOrientedMethodCalled = null;
		// ArrayList<String> methodsCalled = new ArrayList<String>();
		String parameters = "";
		int returnedValue = -2;

		account acc = new account();

		// show welcome message
		// TODO uncomment
		showWelcomeMessage();

		// show menu
		do {
			choice = showMenu();
			System.out.println("\nYour choice is : " + choice);
			currentMethodCalled = null;
			currentTestingOrientedMethodCalled = null;
			parameters = "";
			returnedValue = -2;

			int accountNumber;
			int pin;
			int balance;
			int amount;
			int lockNumber;

			switch (choice) {
			case "0": // OPEN
				currentMethodCalled = TestDriverMethod.OPEN;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				accountNumber = getInputFromUser("Enter Account#");
				pin = getInputFromUser("Enter PIN");
				balance = getInputFromUser("Enter initial balance");
				returnedValue = acc.open(accountNumber, pin, balance);
				parameters = String.format("%d %d %d", accountNumber, pin, balance);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "1": // DEPOSIT
				currentMethodCalled = TestDriverMethod.DEPOSIT;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				amount = getInputFromUser("Enter Deposit Amount");
				returnedValue = acc.deposit(amount);
				parameters = String.format("%d", amount);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "2": // WITHDRAW
				currentMethodCalled = TestDriverMethod.WITHDRAW;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				amount = getInputFromUser("Enter Withdraw Amount");
				returnedValue = acc.withdraw(amount);
				parameters = String.format("%d", amount);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "3": // BALANCE
				currentMethodCalled = TestDriverMethod.BALANCE;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				returnedValue = acc.balance();
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "4": // LOCK
				currentMethodCalled = TestDriverMethod.LOCK;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				lockNumber = getInputFromUser("Enter Lock#");
				returnedValue = acc.lock(lockNumber);
				parameters = String.format("%d", lockNumber);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "5": // UNLOCK
				currentMethodCalled = TestDriverMethod.UNLOCK;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				lockNumber = getInputFromUser("Enter Lock#");
				returnedValue = acc.unlock(lockNumber);
				parameters = String.format("%d", lockNumber);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "6": // LOGIN
				currentMethodCalled = TestDriverMethod.LOGIN;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				accountNumber = getInputFromUser("Enter Account#");
				returnedValue = acc.login(accountNumber);
				parameters = String.format("%d", accountNumber);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "7": // PIN
				currentMethodCalled = TestDriverMethod.PIN;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				pin = getInputFromUser("Enter PIN");
				returnedValue = acc.pin(pin);
				parameters = String.format("%d", pin);
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "8": // LOGOUT
				currentMethodCalled = TestDriverMethod.LOGOUT;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				returnedValue = acc.logout();
				System.out.println(String.format("\\n\\t\\tThe value returned by the method is: %d (%s)\n",
						returnedValue, (returnedValue == 1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "a": // SHOW BALANCE
				currentTestingOrientedMethodCalled = TestingOrientedMethod.SHOW_BALANCE;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				System.out.println(String.format("\n\t\tBalance: %d", acc.show_balance()));
				pressEnterKeyToContinue();
				break;

			case "b": // SHOW STATE
				currentTestingOrientedMethodCalled = TestingOrientedMethod.SHOW_STATE;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				System.out.println(String.format("\n\t\tState: %s", acc.getCurrentState()).replace("_", " "));
				pressEnterKeyToContinue();
				break;

			case "c": // SHOW LOCKED STATUS
				currentTestingOrientedMethodCalled = TestingOrientedMethod.SHOW_LOCKED_STATUS;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				System.out.println(String.format("\n\t\tLocked Status: %s", acc.getLockedStatus()).replace("_", " "));
				pressEnterKeyToContinue();
				break;

			case "d": // SHOW NUBER OF UNSUCCESSFUL LOGIN ATTEMPTS
				currentTestingOrientedMethodCalled = TestingOrientedMethod.SHOW_NUMBER_OF_UNSECCESSFUL_LOGIN_ATTEMPTS;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				System.out.println(String.format("\n\t\tNumber of Unsuccessful Login Attempts: %d",
						acc.getNumbeOfUnsuccessfulLoginAttemts()));
				pressEnterKeyToContinue();
				break;

			default:
				break;
			}

			TestSuiteData.add(currentMethodCalled, parameters, null, null, null);

		} while (!choice.equals("q"));

		System.out.println("Quitting Account Driver...");
		System.out.println(strLine + "\n\t\tTHANK YOU!!!\n" + strLine);
		System.out.println(String.format("\n\n\t\tTest: %s", TestSuiteData.getTestCase()));
	}

	/**
	 * Get Valid User Input
	 * 
	 * @param message Message to print for taking input from user
	 * @return Valid User Input
	 */
	private static int getInputFromUser(String message) {
		// TODO Auto-generated method stub
		int data = -1;
		boolean hasError = false;

		System.out.println(message + ":\n");
		String input = scanner.nextLine().toLowerCase();
		do {
			if (hasError) {
				System.out.println("Invalid Input!!!");
				System.out.println("Please try again...");
				System.out.println(message + ":\n");
			}

			try {
				data = Integer.parseInt(input);
				hasError = false;
			} catch (Exception e) {
				hasError = true;
			}
		} while (hasError);

		return data;
	}

	/**
	 * Print Current Invoked Method Information
	 * 
	 * @param currentMethodCalled                TestDriverMethod enum value of
	 *                                           current Test Driver Method or null
	 * @param currentTestingOrientedMethodCalled TestingOrientedMethod enum value of
	 *                                           current Test-Oriented Method or
	 *                                           null
	 */
	private static void printCurrentMethodInfo(TestDriverMethod currentMethodCalled,
			TestingOrientedMethod currentTestingOrientedMethodCalled) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 50; i++)
			System.out.println("\n");
		System.out.println(strLine);
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
		System.out.println(strLine + "\n");
	}

	/**
	 * Show Menu
	 * 
	 * @return Valid choice
	 */
	private static String showMenu() {
		// TODO Auto-generated method stub
		int i = 0;
		char j = 'a';

		// Show Driver Method for the Account Class
		System.out.println("\n\nDriver for the Account" + "\n" + strLine + "\n");

		for (TestDriverMethod testDriverMethod : TestDriverMethod.values()) {
			System.out.println(String.format("\t%d. %s", i++, testDriverMethod));
		}

		// Show Testing-Oriented Method for Account Class
		System.out.println("\n\nTesting-Oriented Methods" + "\n" + strLine + "\n");
		for (TestingOrientedMethod testingOrientedMethod : TestingOrientedMethod.values()) {
			System.out.println(String.format("\t%c. %s", j++, testingOrientedMethod).replace('_', ' '));
		}

		System.out.println(String.format("\n\n\t%c. %s", 'q', "Quit Account Driver"));
		System.out.println("\n\nEnter you choice:\n");

		String choice = scanner.nextLine().toLowerCase();

		// Validate Input
		while (!validateInput(choice, i, j)) {
			System.out.println("\n\nINVALID INPUT!!!");
			System.out.println("Enter you choice:\n");

			choice = scanner.nextLine().toLowerCase();
		}

		return choice;
	}

	/**
	 * Validate input of user for choice
	 */
	private static boolean validateInput(String choice, int i, char j) {
		// TODO Auto-generated method stub
		boolean isValidInput = false;
		int ch = -1;
		try {
			ch = Integer.parseInt(choice);
			isValidInput = (ch >= 0 && ch < i);
		} catch (Exception e) {
			if (choice.length() == 1) {
				char c = choice.charAt(0);
				isValidInput = (c >= 'a' && c < j) || (c == 'q');
			}
		}
		return isValidInput;
	}

	/**
	 * Shows Welcome Message
	 */
	@SuppressWarnings("unused")
	private static void showWelcomeMessage() {
		// TODO Auto-generated method stub
		System.out.println("\t\tCS 589; Fall 2021");
		System.out.println("\t\t     PROJECT");
		System.out.println("\t\t  Sukanta Sharma");
		System.out.println("\t\t     A2042623");
		System.out.println("\n" + strLine + "\n" + strLine + "\n\n");

		pressEnterKeyToContinue();

	}

	/**
	 * Press Enter Key to Continue
	 */
	private static void pressEnterKeyToContinue() {
		// TODO Auto-generated method stub
		System.out.println("\nPress Enter key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
		for (int i = 0; i <= 50; i++)
			System.out.println("\n");
	}

}
