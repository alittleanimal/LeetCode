package Collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {
    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start) {
        Queue<Character> q = new LinkedList<>();
        q.add(start);
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty()) {
            char top = q.poll();
            i++;
            System.out.println("The " + i + "th element:" + top + " Distance from s is: " + dist.get(top));
            int distance = dist.get(top) + 1;
            for (Character character : graph.get(top)) {
                if (!dist.containsKey(character)) {
                    dist.put(character, distance);
                    q.add(character);
                }
            }
        }
    }

    private static void dfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited) {
        visit(graph, visited, 'u');
        visit(graph, visited, 'w');
    }

    private static void visit(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited, char start) {
        int count = 0;
        if (!visited.containsKey(start)) {
            count++;
            System.out.println("The time into element " + start + ":" + count);
            visited.put(start, true);
            for (char character : graph.get(start)) {
                if (!visited.containsKey(character)) {
                    visit(graph, visited, character);
                }
            }
            count++;
            System.out.println("The time out element " + start + ":" + count);
        }
    }
}
