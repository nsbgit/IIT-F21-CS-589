import java.util.Hashtable;

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
	 * Locked Status <br/>
	 * 0 --> UNLOCKED <br/>
	 * 1 --> LOCKED
	 */
	private int x2;
	/**
	 * PIN
	 */
	private int x3;
	/**
	 * State <br/>
	 * -1 --> START <br/>
	 * 0 --> IDLE <br/>
	 * 1 --> CHECK PIN --> LOGGED IN <br/>
	 * 2 --> x2(LOCKED STATUS) = 1 --> LOCKED <br/>
	 * x1(Balance) < x7(Minimum Balance) --> OVERDRAWN <br/>
	 * otherwise READY
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
	// TODO
	public Hashtable<String, String> tt1;
	public Hashtable<String, String> tt2;
	public Hashtable<String, String> tt3;
	public Hashtable<String, String> tt4;
	public Hashtable<String, String> tt5;
	public Hashtable<String, String> tt6;
	public Hashtable<String, String> tt7;
	public Hashtable<String, String> tt8;
	public Hashtable<String, String> tt9;
	public Hashtable<String, String> tt10;
	public Hashtable<String, String> tt11;
	public Hashtable<String, String> tt12;
	public Hashtable<String, String> tt13;
	public Hashtable<String, String> tt14;
	public Hashtable<String, String> tt15;
	public Hashtable<String, String> tt16;
	public Hashtable<String, String> tt17;
	public Hashtable<String, String> tt18;
	public Hashtable<String, String> tt19;
	public Hashtable<String, String> tt20;
	public Hashtable<String, String> tt21;
	public Hashtable<String, String> tt22;
	public String testCaseNumber;

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
	 * 
	 * @return Current State
	 */
	public final State getCurrentState() {
		switch (x4) {
		case -1:
			return State.START;

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
	 * Get Locked Status (Testing-Oriented Method)
	 * 
	 * @return Locked Status
	 */
	public final LockedStatus getLockedStatus() {
		return (x2 == 0) ? LockedStatus.UNLOCKED : LockedStatus.LOCKED;
	}

	/**
	 * Get Number of Unsuccessful Login Attempts (Testing-Oriented Method)
	 * 
	 * @return Number of Unsuccessful Login Attempts
	 */
	public final int getNumbeOfUnsuccessfulLoginAttemts() {
		return x9;
	}

	/**
	 * Constructor for parameters initialization
	 */
	public account() {
		x2 = 0;
		x4 = -1;
		x6 = 20;
		x7 = 200;
		x9 = 0;
		x0 = 3;
		// TODO
		tt1 = createTruthTable(4);
		tt2 = createTruthTable(1);
		tt3 = createTruthTable(1);
		tt4 = createTruthTable(1);
		tt5 = createTruthTable(2);
		tt6 = createTruthTable(1);
		tt7 = createTruthTable(1);
		tt8 = createTruthTable(1);
		tt9 = createTruthTable(1);
		tt10 = createTruthTable(1);
		tt11 = createTruthTable(1);
		tt12 = createTruthTable(1);
		tt13 = createTruthTable(2);
		tt14 = createTruthTable(1);
		tt15 = createTruthTable(1);
		tt16 = createTruthTable(2);
		tt17 = createTruthTable(1);
		tt18 = createTruthTable(1);
		tt19 = createTruthTable(1);
		tt20 = createTruthTable(2);
		tt21 = createTruthTable(1);
		tt22 = createTruthTable(1);
	}

	/**
	 * sets balance to the value of x, pin number to the value of y, and an account
	 * # to the value of z
	 * 
	 * @param z Account Number
	 * @param y PIN
	 * @param x Amount
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int open(int z, int y, int x) {
		boolean[] conds = {x > 0, x4 == -1, y > 0, z > 0};
		addEntryToTT(tt1, conds);
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
	 * @param x PIN
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int pin(int x) {
		boolean[] conds = {x4 != 1};
		addEntryToTT(tt2, conds);
		if (x4 != 1) { // Check if the current state is CHECK PIN
			return -1;
		}
		
		
		boolean[] conds1 = {x == x3};
		addEntryToTT(tt3, conds1);
		if (x == x3) {
			x4 = 2;
			return 0;
		} else {
			x9++;
		}
		
		
		boolean[] conds2 = {x9 >= x0};
		addEntryToTT(tt4, conds2);
		if (x9 >= x0) {
			x4 = 0;
		}
		return -1;
	}

	/**
	 * allows to logout from the account
	 * 
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int logout() {
		
		
		boolean[] conds = {x4 == 0, x2 == 1};
		addEntryToTT(tt5, conds);
		if ((x4 == 0) || (x2 == 1)) {
			return -1;
		}
		x4 = 0;
		return 0;
	}

	/**
	 * allows to login to the account, where x is an account #
	 * 
	 * @param x Account Number
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int login(int x) {
		
		
		boolean[] conds = {x4 != 0};
		addEntryToTT(tt6, conds);
		if (x4 != 0) {
			return -1;
		}
		
		
		boolean[] conds1 = {x5 == x};
		addEntryToTT(tt7, conds1);
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
		
		
		boolean[] conds = {x4 != 2};
		addEntryToTT(tt8, conds);
		if (x4 != 2) {
			return -1;
		}
		return x1;
	}

	/**
	 * locks an account where x is the lock #
	 * 
	 * @param x Lock Number
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int lock(int x) {
		
		
		boolean[] conds = {x4 != 2};
		addEntryToTT(tt9, conds);
		if (x4 != 2) {
			return -1;
		}
		
		
		boolean[] conds1 = {x == x3};
		addEntryToTT(tt10, conds1);
		if (x == x3) {
			return -1;
		}
		
		
		boolean[] conds2 = {x2 == 0};
		addEntryToTT(tt11, conds2);
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
	 * @param x Lock Number
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int unlock(int x) {
		
		
		boolean[] conds = {x4 != 2};
		addEntryToTT(tt12, conds);
		if (x4 != 2) {
			return -1;
		}
		
		
		boolean[] conds1 = {x2 == 1, x == x8};
		addEntryToTT(tt13, conds1);
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
	 * @param d Amount to deposit
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int deposit(int d) {
		
		
		boolean[] conds = {x4 != 2};
		addEntryToTT(tt14, conds);
		if (x4 != 2) {
			return -1;
		}
		
		
		boolean[] conds1 = {x2 == 1};
		addEntryToTT(tt15, conds1);
		if (x2 == 1) {
			return -1;
		}
		;
		
		
		boolean[] conds2 = {x1 + d < x7, d > 0};
		addEntryToTT(tt16, conds2);
		if ((x1 + d < x7) && (d > 0)) {
			x1 = x1 + d - x6; // TODO BUG
			return 0;
		} else {
			
			
			boolean[] conds3 = {d > 0};
			addEntryToTT(tt17, conds3);
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
	 * @param w Amount to withdraw from the account
	 * @return the value returned by the method 0 --> Successful, -1 --> ERROR
	 */
	public final int withdraw(int w) {
		
		
		boolean[] conds = {x4 != 2};
		addEntryToTT(tt18, conds);
		if (x4 != 2) {
			return -1;
		}
		
		
		boolean[] conds1 = {x2 == 1};
		addEntryToTT(tt19, conds1);
		if (x2 == 1) {
			return -1;
		}
		;
		
		
		boolean[] conds2 = {x1 > w, w > 0};
		addEntryToTT(tt20, conds2);
		if ((x1 > w) && (w > 0)) {
			
			
			boolean[] conds3 = {x1 < x7};
			addEntryToTT(tt21, conds3);
			if (x1 < x7) {
				return -1;
			} else {
				x1 = x1 - w;
			}
			;
			
			
			boolean[] conds4 = {x1 < x7};
			addEntryToTT(tt22, conds4);
			if (x1 < x7) {
				x1 = x1 - x6;
			}
			return 0;
		}
		return -1;
	}
	
	private Hashtable<String, String> createTruthTable(int numberOfParameters) {
        int rows = (int) Math.pow(2,numberOfParameters);
        Hashtable<String, String> truthTable = new Hashtable<String, String>();
        
        for (int i=0; i<rows; i++) {
        	StringBuilder rKey = new StringBuilder();
            for (int j=numberOfParameters-1; j>=0; j--) {
//                System.out.print((i/(int) Math.pow(2, j))%2 + " ");
                int rInt = (i/(int) Math.pow(2, j))%2;
                rKey.append((rInt + ",").replace("0", "T").replace("1", "F"));
            }
            truthTable.put(rKey.toString(), "");
//            System.out.println();
        }
        return truthTable;
    }
	
	private void addEntryToTT(Hashtable<String, String> tTable, boolean[] conds) {
		// TODO Auto-generated method stub
		StringBuilder rKey = new StringBuilder();
		for (boolean cond : conds) {
			rKey.append(cond ? "T" : "F");
			rKey.append(",");
		}
		tTable.put(rKey.toString(), testCaseNumber);
	}
}