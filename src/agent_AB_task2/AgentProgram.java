package agent_AB_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AgentProgram {
//	public Action execute(Percept p) {// location, status
//		//TODO
//		if(p.getLocationState().equals(Environment.LocationState.DIRTY)) {
//			return Environment.SUCK_DIRT;
//		}else if(p.getAgentLocation().equals(Environment.LOCATION_A)) {
//			return Environment.MOVE_RIGHT;
//		}else if(p.getAgentLocation().equals(Environment.LOCATION_B)) {
//			return Environment.MOVE_LEFT;
//		}
//		return NoOpAction.NO_OP;
//	}
	public Action randomMove(Percept p) {
		List<Action> action = new ArrayList<>();
		action.add(Environment.MOVE_LEFT);
		action.add(Environment.MOVE_RIGHT);
		action.add(Environment.MOVE_UP);
		action.add(Environment.MOVE_DOWN);

		Random random = new Random();
		int randomIndex = random.nextInt(action.size());
		Action randomAction = action.get(randomIndex);
		return randomAction;
	}
	public Action execute(Percept percept) {
//		Action action = null;
        Environment.LocationState state = percept.getLocationState();
        
        if (state == Environment.LocationState.DIRTY) {
            return Environment.SUCK_DIRT;
        } else if (state == Environment.LocationState.CLEAN) {
        	return randomMove(percept);
        }
        return NoOpAction.NO_OP;
	}
	
}