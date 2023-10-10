package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        List<Node> explored = new ArrayList<>();

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.getLabel().equals(goal)) {
                return current;
            } else {
                explored.add(current);
                List<Node> children = current.getChildrenNodes();

                for (Node child : children) {
                    if (!stack.contains(child) && !explored.contains(child)) {
                        stack.push(child);
                        child.setParent(current);
                    }
                }
            }
        }
        return null;
    }
    @Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		boolean started = false;
		frontier.add(root);
		Stack<Node> explored = new Stack<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
				return execute(current, goal);
			}
			if (current.getLabel().equals(goal) && started) {
				return current;
			} else {
				explored.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node child : children) {
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

}
