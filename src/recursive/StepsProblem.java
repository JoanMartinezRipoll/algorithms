package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StepsProblem {
	/*A ladder has n steps, one can climb the ladder using any 
	 * combination of steps of 1 or steps of 2. How many possible ways
	 *  are there for one to climb the ladder? */

	public static final int MAX_STEPS = 3;

	public static void main (String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer ladderSteps = Integer.parseInt(br.readLine());
		List<List<Integer>> result = findCombinations(ladderSteps);
	}

	private static List<List<Integer>> findCombinations(Integer ladderSteps) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		findCominationsRecursive (result,ladderSteps, new ArrayList<Integer>(), 0);
		return result;
	}

	private static void findCominationsRecursive(List<List<Integer>> result, Integer ladderSteps, List<Integer> takenSteps, int amount) {
		if (amount == ladderSteps) {
			result.add(takenSteps);
		}
		else {
			for (int i = 1 ; i<=MAX_STEPS ; i++) {
				if (amount + i <= ladderSteps ) {
					List<Integer> newSteps = new ArrayList<Integer>();
					newSteps.addAll(takenSteps);
					newSteps.add(i);
					findCominationsRecursive(result, ladderSteps, newSteps, amount + i);
				}
			}
		}
	}
}
