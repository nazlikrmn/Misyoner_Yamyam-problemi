package pacProblem;

import java.util.ArrayList;
import java.util.List;

enum Position{Right,Left}
public class State {
	private int YamyamLeft;
	private int MisyonerLeft;
	private int YamyamRight;
	private int MisyonerRight;
	private Position kayýk;
	private State parentState;
	public State(int yamyamL,int misyonerL,Position Kayýk,int yamyamR,int misyonerR) {
		this.YamyamLeft=yamyamL;
		this.MisyonerLeft=misyonerL;
		this.YamyamRight=yamyamR;
		this.MisyonerRight=misyonerR;
		this.kayýk=Kayýk;
	}
	public Boolean isGoal() {
		return YamyamLeft==0&&MisyonerLeft==0;
	}
	public Boolean gecerliMi() {
		if(YamyamLeft>=0&&YamyamRight>=0&&
				MisyonerRight>=0&&MisyonerLeft>=0&&
				(MisyonerRight==0||MisyonerRight>=YamyamRight)&&
				(MisyonerLeft==0||MisyonerLeft>=YamyamLeft)) {
			return true;
		}
		return false;
	}
	public String stateYaz() {
		return "("+YamyamLeft+","+MisyonerLeft+","+(this.kayýk==Position.Left?"L":"R")+","+YamyamRight+","+MisyonerRight+")";
	}
	public List<State> generateSuccessor(){
		List<State> successors=new ArrayList<State>();
		if(kayýk==Position.Left) {
			TestandAdd(successors, new State(YamyamLeft, MisyonerLeft - 2, Position.Right,
					YamyamRight, MisyonerRight + 2)); // Two missionaries cross
			TestandAdd(successors, new State(YamyamLeft - 2, MisyonerLeft, Position.Right,
					YamyamRight + 2, MisyonerRight)); // Two cannibals cross
			TestandAdd(successors, new State(YamyamLeft - 1, MisyonerLeft - 1, Position.Right,
					YamyamRight + 1, MisyonerRight + 1)); // One missionary and one cannibal cross
			TestandAdd(successors, new State(YamyamLeft, MisyonerLeft - 1, Position.Right,
					YamyamRight, MisyonerRight + 1)); // One missionary cross
			TestandAdd(successors, new State(YamyamLeft - 1, MisyonerLeft, Position.Right,
					YamyamRight + 1, MisyonerRight)); // One cannibal cross
		}
		else {
			TestandAdd(successors, new State(YamyamLeft, MisyonerLeft + 2, Position.Left,
					YamyamRight, MisyonerRight - 2)); // Two missionaries cross
			TestandAdd(successors, new State(YamyamLeft + 2, MisyonerLeft, Position.Left,
					YamyamRight - 2, MisyonerRight)); // Two cannibals cross
			TestandAdd(successors, new State(YamyamLeft + 1, MisyonerLeft + 1, Position.Left,
					YamyamRight - 1, MisyonerRight - 1)); // One missionary and one cannibal cross
			TestandAdd(successors, new State(YamyamLeft, MisyonerLeft + 1, Position.Left,
					YamyamRight, MisyonerRight - 1)); // One missionary cross
			TestandAdd(successors, new State(YamyamLeft + 1, MisyonerLeft, Position.Left,
					YamyamRight - 1, MisyonerRight)); // One cannibal cross
		}
		return successors;
	}
	public void TestandAdd(List<State> successor,State state1) {
		if (state1.gecerliMi()) {
			state1.setParentState(this);
			successor.add(state1);
		}
	}
	public void setParentState(State state1) {
		this.parentState=state1;
	}
	public State getParentState() {
		return parentState;
	}
	
}
