package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Given an undirected graph check 
 * if all the nodes are connected, 
 * if yes return true else false */

public class Solution {
	static class Graph {
		List<List<Integer>> graph;
		boolean visited[];
		int nodes;

		Graph(int nodes) {
			graph = new ArrayList<>();
			visited = new boolean[nodes];
			this.nodes = nodes;
			for (int i = 0; i <= nodes; i++) {
				graph.add(i, new ArrayList<>());
			}
		}

		public void addEdge(int source, int destination) {
			graph.get(source).add(destination);
			graph.get(destination).add(source);
		}

		public boolean checkGraphIsConnected() {
			graph.remove(0);
			int startIndex = 0;
			DFS(startIndex);
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					return false;
				}
			}
			return true;
		}

		public void DFS(int start) {
			Stack<Integer> stack = new Stack<>();
			stack.push(start);
			visited[start] = true;

			while (!stack.isEmpty()) {
				Integer node = stack.pop();
				List<Integer> neighboursList = graph.get(node);
				// Check for adjacent neighbors
				for (Integer neighbour : neighboursList) {
					if (!visited[neighbour]) {
						stack.push(neighbour);
						visited[neighbour] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 4, 4, 3 };
		int[] B = { 2, 3, 1, 3, 1 };
		int N = 4;
		Graph graph = new Graph(N + 1);
		for (int i = 0; i < A.length; i++) {
			graph.addEdge(A[i], B[i]);
		}
		boolean check = graph.checkGraphIsConnected();
		System.out.print(check);
	}
}
