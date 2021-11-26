import java.util.ArrayList;

/**
 * 
 */

/**
 * @author sukanta
 *
 */
public class TestSuiteData {
	private StringBuilder testCase;
	private StringBuilder states;
	private StringBuilder paths;
	private StringBuilder output;

	private static ArrayList<String> methodsCalled = new ArrayList<String>();
	private static ArrayList<String> transitStates = new ArrayList<String>();
	private static ArrayList<String> transitPaths = new ArrayList<String>();
	private static ArrayList<String> outputs = new ArrayList<String>();

	/**
	 * @return the testCase
	 */
	public String getTestCase() {
		testCase = new StringBuilder();

		boolean isFirst = true;

		for (String cur : methodsCalled) {
			if (isFirst) {
				states.append(cur);
				isFirst = false;
			} else {
				states.append(" " + cur);
			}

		}

		return testCase.toString().toLowerCase();
	}

	/**
	 * @return the states
	 */
	public String getStates() {
		states = new StringBuilder();
		return states.toString().toUpperCase();
	}

	/**
	 * @return the paths
	 */
	public String getPaths() {
		paths = new StringBuilder();
		return paths.toString().toUpperCase();
	}

	public static void add(TestDriverMethod currentMethodCalled, String parameters, Object object, Object object2,
			Object object3) {
		// TODO Auto-generated method stub
		if (currentMethodCalled != null) {
			methodsCalled.add(String.format("%s%s", currentMethodCalled,
					((parameters.trim().isEmpty()) ? "" : " " + parameters)));
		}
	}

}
