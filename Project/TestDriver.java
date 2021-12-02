
/**
 * 
 */

/**
 * @author sukanta
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

enum LockedStatus {
	LOCKED, UNLOCKED
}

enum State {
	START, IDLE, CHECK_PIN, READY, LOCKED, OVERDRAWN
}

enum TestDriverMethod {
	OPEN, DEPOSIT, WITHDRAW, BALANCE, LOCK, UNLOCK, LOGIN, PIN, LOGOUT
}

enum TestingOrientedMethod {
	SHOW_BALANCE, SHOW_STATE, SHOW_LOCKED_STATUS, SHOW_NUMBER_OF_UNSECCESSFUL_LOGIN_ATTEMPTS
	// SHOW_TRANSITION
}

/**
 * Driver Class for the Account Class
 * 
 * @author sukanta
 */
public class TestDriver {

	private static final String strLine = "_____________________________________________________________________";
	private static final int NUMBER_OF_NEW_LINES = 2;
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
		
		acc.testCaseNumber = getInputFromUser("Enter test Case#:") + "";

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
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "1": // DEPOSIT
				currentMethodCalled = TestDriverMethod.DEPOSIT;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				amount = getInputFromUser("Enter Deposit Amount");
				returnedValue = acc.deposit(amount);
				parameters = String.format("%d", amount);
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "2": // WITHDRAW
				currentMethodCalled = TestDriverMethod.WITHDRAW;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				amount = getInputFromUser("Enter Withdraw Amount");
				returnedValue = acc.withdraw(amount);
				parameters = String.format("%d", amount);
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "3": // BALANCE
				currentMethodCalled = TestDriverMethod.BALANCE;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				returnedValue = acc.balance();
				System.out.println(String.format("\n\t\tThe value returned by the method is: Balance = %d (%s)\n",
						returnedValue, (returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "4": // LOCK
				currentMethodCalled = TestDriverMethod.LOCK;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				lockNumber = getInputFromUser("Enter Lock#");
				returnedValue = acc.lock(lockNumber);
				parameters = String.format("%d", lockNumber);
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "5": // UNLOCK
				currentMethodCalled = TestDriverMethod.UNLOCK;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				lockNumber = getInputFromUser("Enter Lock#");
				returnedValue = acc.unlock(lockNumber);
				parameters = String.format("%d", lockNumber);
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "6": // LOGIN
				currentMethodCalled = TestDriverMethod.LOGIN;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				accountNumber = getInputFromUser("Enter Account#");
				returnedValue = acc.login(accountNumber);
				parameters = String.format("%d", accountNumber);
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "7": // PIN
				currentMethodCalled = TestDriverMethod.PIN;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				pin = getInputFromUser("Enter PIN");
				returnedValue = acc.pin(pin);
				parameters = String.format("%d", pin);
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
				pressEnterKeyToContinue();
				break;

			case "8": // LOGOUT
				currentMethodCalled = TestDriverMethod.LOGOUT;
				printCurrentMethodInfo(currentMethodCalled, currentTestingOrientedMethodCalled);
				returnedValue = acc.logout();
				System.out.println(String.format("\n\t\tThe value returned by the method is: %d (%s)\n", returnedValue,
						(returnedValue != -1) ? "SUCCESS" : "FAILED"));
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

			TestSuiteData.add(currentMethodCalled, parameters, acc.getCurrentState(), acc.show_balance(),
					acc.getNumbeOfUnsuccessfulLoginAttemts(), returnedValue);

		} while (!choice.equals("q"));

		System.out.println("Quitting Account Driver...");
		System.out.println(strLine + "\n\t\tTHANK YOU!!!\n" + strLine);
		System.out.println(String.format("\n\n\t\tTest Case Performed:\n%s", TestSuiteData.getTestCase()));
		System.out.println(
				String.format("\n\n\t\tTest Case Performed as function:\n%s", TestSuiteData.getFunctionTestCase()));
		System.out.println(String.format("\n%s\n%s", strLine, TestSuiteData.getResult()));
		
		
		
		pritntTT("TT1", acc.tt1);
//		pritntTT("TT2", acc.tt2);
//		pritntTT("TT3", acc.tt3);
//		pritntTT("TT4", acc.tt4);
//		pritntTT("TT5", acc.tt5);
//		pritntTT("TT6", acc.tt6);
//		pritntTT("TT7", acc.tt7);
//		pritntTT("TT8", acc.tt8);
//		pritntTT("TT9", acc.tt9);
//		pritntTT("TT10", acc.tt10);
//		pritntTT("TT11", acc.tt11);
//		pritntTT("TT12", acc.tt12);
//		pritntTT("TT13", acc.tt13);
//		pritntTT("TT14", acc.tt14);
//		pritntTT("TT15", acc.tt15);
		pritntTT("TT16", acc.tt16);
		pritntTT("TT17", acc.tt17);
//		pritntTT("TT18", acc.tt18);
//		pritntTT("TT19", acc.tt19);
		pritntTT("TT20", acc.tt20);
//		pritntTT("TT21", acc.tt21);
//		pritntTT("TT22", acc.tt22);
	}
	
	

	private static void pritntTT(String truthTableName, Hashtable<String, String> tT) {
		// TODO Auto-generated method stub
		System.out.println("\n\n\n" + truthTableName);
		
		tT.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + "" + entry.getValue() + "");
		});
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
		for (int i = 0; i <= NUMBER_OF_NEW_LINES; i++)
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
		System.out.println("\n\nEnter your choice:\n");

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
//			System.in.read();
		} catch (Exception e) {
		}
		for (int i = 0; i <= NUMBER_OF_NEW_LINES; i++)
			System.out.println("\n");
	}

}

/**
 * Responsible for Test Suite Data for Test Case
 * 
 * @author sukanta
 */
class TestSuiteData {
	private static StringBuilder testCase;
	private static StringBuilder result;

	private static ArrayList<String> methodsCalled = new ArrayList<String>();
	private static ArrayList<String> functionsCalled = new ArrayList<String>();
	private static ArrayList<String> results = new ArrayList<String>();

	/**
	 * @return the testCase
	 */
	public static String getTestCase() {
		testCase = new StringBuilder();

		boolean isFirst = true;

		for (String cur : methodsCalled) {
			if (isFirst) {
				testCase.append(cur);
				isFirst = false;
			} else {
				testCase.append(" " + cur);
			}

		}

		return testCase.toString().toLowerCase();
	}

	/**
	 * @return the testCase as function()
	 */
	public static String getFunctionTestCase() {
		testCase = new StringBuilder();

		boolean isFirst = true;

		for (String cur : functionsCalled) {
			if (isFirst) {
				testCase.append(cur);
				isFirst = false;
			} else {
				testCase.append(", " + cur);
			}

		}

		return testCase.toString().toLowerCase();
	}

	/**
	 * @return the result
	 */
	public static String getResult() {
		result = new StringBuilder();

		boolean isFirst = true;

		for (String cur : results) {
			if (isFirst) {
				result.append(cur);
				isFirst = false;
			} else {
				result.append("\n" + cur);
			}

		}

		return result.toString();
	}

	/**
	 * Stores called method with parameter for the performed test cases
	 * 
	 * @param currentMethodCalled  Current Called Method for Test Driver Class
	 * @param parameters           parameters given if any
	 * @param stateAfterTransition State after the transition is done due to the
	 *                             current method called
	 * @param balance              Current Balance
	 * @param stateAfterTransition Number of unsuccessful login attempts
	 * @param returnedValue        Value returned by the account method
	 */
	public static void add(TestDriverMethod currentMethodCalled, String parameters, State stateAfterTransition,
			int balance, int numberOfUnsuccessfulLoginAttempts, int returnedValue) {
		// TODO Auto-generated method stub
		if (currentMethodCalled != null) {
			String method = String.format("%s%s", currentMethodCalled,
					((parameters.trim().isEmpty()) ? "" : " " + parameters));
			String performedResult = String.format("%s,%s,%s,%s,%s", method,
					stateAfterTransition.toString().replace("_", " "), balance, numberOfUnsuccessfulLoginAttempts,
					returnedValue);

			String function = "";

			switch (currentMethodCalled) {
			case BALANCE:
			case LOGOUT:
				function = String.format("%s()", currentMethodCalled.toString().toLowerCase());
				break;
			case DEPOSIT:
			case LOCK:
			case LOGIN:
			case PIN:
			case UNLOCK:
			case WITHDRAW:
				function = String.format("%s(%s)", currentMethodCalled.toString().toLowerCase(), parameters);
				break;
			case OPEN:
				String param = parameters.replace(" ", ",");
				function = String.format("%s(%s)", currentMethodCalled.toString().toLowerCase(), param);
				break;
			default:
				break;

			}

			methodsCalled.add(method);
			functionsCalled.add(function);
			results.add(performedResult);

		}
	}

}
