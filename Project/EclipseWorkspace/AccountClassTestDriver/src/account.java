//***********************************************
//************* CLASS ACCOUNT *******************
//***********************************************

public class account {
	/**
	 * Maximum Login Attempt
	 */
	private int x0;
	/**
	 * Balance
	 */
	private int x1;
	/**
	 * Locked Status
	 * <br/>0 --> UNLOCKED
	 * <br/>1 --> LOCKED
	 */
	private int x2;
	/**
	 * PIN
	 */
	private int x3;
	/**
	 * State
	 * <br/>-1	-->	INITIAL
	 * <br/>0	-->	IDLE
	 * <br/>1	-->	CHECK PIN --> LOGGED IN
	 * <br/>2	-->	x2(LOCKED STATUS) = 1 --> LOCKED
	 * <br/>x1(Balance) < x7(Minimum Balance) --> OVERDRAWN
	 * <br/>otherwise READY
	 */
	private int x4;
	/**
	 * Account Number
	 */
	private int x5;
	/**
	 * Transaction Fee
	 */
	private int x6;
	/**
	 * Minimum Balance
	 */
	private int x7;
	/**
	 * Lock Number
	 */
	private int x8;
	/**
	 * Number of Unsuccessful Login Attempt
	 */
	private int x9;

	/**
	 * Shows Balance (Testing-Oriented Method)
	 *
	 * @return Current Balance
	 */
	public final int show_balance() {
		return x1;
	} // testing oriented method
	
	/**
	 * Get Current State (Testing-Oriented Method)
	 * @return Current State
	 * */
	public final State getCurrentState() {
		switch (x4) {
		case -1:
			return State.INITIAL;
			
		case 0:
			return State.IDLE;
			
		case 1:
			return State.CHECK_PIN;
			
		case 2:
			return (x2 == 1) ? State.LOCKED : ((x1 < x7) ? State.OVERDRAWN : State.READY);

		default:
			break;
		}
		return null;
	}

	/**
	 * Get Locked Status
	 * @return Locked Status
	 * */
	public final LockedStatus getLockedStatus() {
		return (x2 == 0)? LockedStatus.UNLOCKED : LockedStatus.LOCKED;
	}
	
	/**
	 * Get Number of Unsuccessful Login Attempts
	 * @return Number of Unsuccessful Login Attempts
	 * */
	public final int getNumbeOfUnsuccessfulLoginAttemts() {
		return x9;
	}
	/**
	 * Constructor
	 */
	public account() {
		x2 = 0;
		x4 = -1;
		x6 = 20;
		x7 = 200;
		x9 = 0;
		x0 = 3;
	}

	/**
	 * sets balance to the value of x, pin number to the value of y, and an account # to the value of z
	 * 
	 * @param	z
	 * 			Account Number
	 * @param	y
	 * 			PIN
	 * @param	x
	 * 			Amount
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int open(int z, int y, int x) {
		if ((x > 0) && (x4 == -1) && (y > 0) && (z > 0)) {
			x1 = x;
			x3 = y;
			x5 = z;
			x4 = 0;
			return 0;
		}
		;
		return -1;
	}

	/**
	 * provides pin # (parameter x)
	 * 
	 * @param	x
	 * 			PIN
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int pin(int x) {
		if (x4 != 1) { // Check if the current state is CHECK PIN
			return -1;
		}
		if (x == x3) { // TODO BUG T8 T16
			x4 = 2;
			return 0;
		} else {
			x9++;
		}
		if (x9 >= x0) {
			x4 = 0;
		}
		return -1;
	}

	/**
	 * allows to logout from the account
	 * 
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int logout() {
		if ((x4 == 0) || (x2 == 1)) {
			return -1;
		}
		x4 = 0;
		return 0;
	}

	/**
	 * allows to login to the account, where x is an account #
	 * 
	 * @param	x
	 * 			Account Number
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int login(int x) {
		if (x4 != 0) {
			return -1;
		}
		if (x5 == x) {
			x4 = 1;
			x9 = 0;
			return 0;
		}
		return -1;
	}

	/**
	 * returns the value of the account balance
	 * 
	 * @return the value of the account balance
	 */
	public final int balance() {
		if (x4 != 2) {
			return -1;
		}
		return x1;
	}

	/**
	 * locks an account where x is the lock #
	 * 
	 * @param	x
	 * 			Lock Number
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int lock(int x) {
		if (x4 != 2) {
			return -1;
		}
		if (x == x3) {
			return -1;
		}
		if (x2 == 0) {
			x2 = 1;
			x8 = x;
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * unlocks an account when x equals to the correct lock #
	 * 
	 * @param	x
	 * 			Lock Number
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int unlock(int x) {
		if (x4 != 2) {
			return -1;
		}
		if ((x2 == 1) && (x == x8)) {
			x2 = 0;
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * deposits amount d to the account
	 * 
	 * @param	d
	 * 			Amount to deposit
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int deposit(int d) {
		if (x4 != 2) {
			return -1;
		}
		if (x2 == 1) {
			return -1;
		}
		;
		if ((x1 + d < x7) && (d > 0)) {
			x1 = x1 + d - x6;
			return 0;
		} else {
			if (d > 0) {
				x1 = x1 + d;
				return 0;
			}
		}
		return -1;
	}

	/**
	 * withdraws amount w from the account
	 * 
	 * @param	w
	 * 			Amount to withdraw from the account
	 * @return the value returned by the method  0 --> Successful, -1 --> ERROR
	 */
	public final int withdraw(int w) {
		if (x4 != 2) {
			return -1;
		}
		if (x2 == 1) {
			return -1;
		}
		;
		if ((x1 > w) && (w > 0)) {
			if (x1 < x7) {
				return -1;
			} else {
				x1 = x1 - w;
			}
			;
			if (x1 < x7) {
				x1 = x1 - x6;
			}
			return 0;
		}
		return -1;
	}
}