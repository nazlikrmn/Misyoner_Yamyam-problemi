package pacProblem;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS bfs=new BFS();
		State ilkState = new State (3, 3, Position.Left, 0, 0);
		State Cozum = bfs.exec(ilkState);
		CozumuYaz(Cozum);
	}
	private static void CozumuYaz(State cozum) {
		if (null == cozum) {
			System.out.print("\n��z�m bulunamad�");
		} else {
			System.out.println("\n ��z�m:  (SoldakiYamyam,SoldakiMisyoner,Kay�k,Sa�dakiYamyam,Sa�dakiMisyoner): ");
			List<State> path = new ArrayList<State>();
			State state = cozum;
			while(null!=state) {
				path.add(state);
				state = state.getParentState();
			}

			int depth = path.size() - 1;
			for (int i = depth; i >= 0; i--) {
				state = path.get(i);
				if (state.isGoal()) {
					System.out.print(state.stateYaz());
				} else {
					System.out.print(state.stateYaz() + " -> \n ");
				}
			}
			System.out.println("\n" + depth+"\t ad�mda bulundu.");
		}
	}

}
