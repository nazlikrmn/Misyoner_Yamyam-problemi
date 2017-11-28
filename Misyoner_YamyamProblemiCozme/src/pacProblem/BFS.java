package pacProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {
	public State exec(State ilkState) {
		if (ilkState.isGoal()) {
			return ilkState;
		}
		Queue<State> frontierQueue = new LinkedList<State>();	
		Set<State> explored = new HashSet<State>();
		frontierQueue.add(ilkState);
		while (true) {
			if (frontierQueue.isEmpty()) {
				return null;	// error
			}
			State state = frontierQueue.poll();
			explored.add(state);
			List<State> successors = state.generateSuccessor();
			for (State child : successors) {
				if (!explored.contains(child) || !frontierQueue.contains(child)) {
					if (child.isGoal()) {
						return child;
					}
					frontierQueue.add(child);
				}
			}
		}
	}
}
