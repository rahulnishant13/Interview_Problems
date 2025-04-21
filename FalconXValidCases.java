import java.util.*;

public class FalconXValidCases {
    public static void main(String[] args) {
        String[] comparisons1 = {"a>b", "a>c", "b<c"};
        System.out.println(isValidComparison(comparisons1)); // Output: true
        String[] comparisons2 = {"a>b", "b>c", "c>a"};
        System.out.println(isValidComparison(comparisons2)); // Output: false
        String[] comparisons3 = {"x<y", "y<z"};
        System.out.println(isValidComparison(comparisons3)); // Output: true
        String[] comparisons4 = {"p>q", "q>p"};
        System.out.println(isValidComparison(comparisons4)); // Output: false
        String[] comparisons5 = {"a>b", "a>c", "c>b"};
        System.out.println(isValidComparison(comparisons5)); // Output: true
        String[] comparisons6 = {"a>b", "b>a"};
        System.out.println(isValidComparison(comparisons6)); // Output: false
        String[] comparisons7 = {"a<b", "c>a", "c>b"};
        System.out.println(isValidComparison(comparisons7)); // Output: true
        String[] comparisons8 = {"a>b", "a<c"};
        System.out.println(isValidComparison(comparisons8)); // Output: true
        String[] comparisons9 = {"a>b", "a>c", "b>c"};
        System.out.println(isValidComparison(comparisons9)); // Output: true
        String[] comparisons10 = {};
        System.out.println(isValidComparison(comparisons10)); // Output: true
    }

    private static boolean isValidComparison(String[] input) {
        if (input == null || input.length == 0) {
            return true;
        }

        Map<Character, List<Character>> graphMap = new HashMap<>();
        Map<Character, Integer> degreeMap = new HashMap<>();

        for (String data: input) {
            char a = data.charAt(0);
            char b = data.charAt(2);
            char comparator = data.charAt(1);

            graphMap.putIfAbsent(a, new ArrayList<>());
            graphMap.putIfAbsent(b, new ArrayList<>());

            if(comparator == '>') {
                graphMap.get(a).add(b);
                degreeMap.put(a, degreeMap.getOrDefault(a, 0) + 1);
            } else {
                graphMap.get(b).add(a);
                degreeMap.put(b, degreeMap.getOrDefault(b, 0) + 1);
            }
        }

        Set<Character> visited = new HashSet<>();
        Set<Character> recursionStack = new HashSet<>();

        for (Character node : graphMap.keySet()) {
            if(hasCycle(node, graphMap, visited, recursionStack)){
                return false;
            }
        }

        List<Character> sortedList = topoLogicalSort(graphMap, degreeMap);
        return true;
    }

    private static List<Character> topoLogicalSort(Map<Character, List<Character>> graphMap, Map<Character, Integer> degreeMap) {
        Queue<Character> queue = new LinkedList<>();
        List<Character> result = new ArrayList<>();

        for (char node : degreeMap.keySet()) {
            if (degreeMap.get(node) == 0) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            char node = queue.poll();
            result.add(node);

            for(char child : graphMap.get(node)) {
                degreeMap.put(child, degreeMap.get(child) - 1);
                if(degreeMap.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (result.size() != degreeMap.keySet().size()) {
            return new ArrayList<>();
        } else {
            return result;
        }
    }

    private static boolean hasCycle(Character node, Map<Character, List<Character>> graphMap, Set<Character> visited, Set<Character> recursionStack) {
        visited.add(node);
        recursionStack.add(node);

        for (char child : graphMap.get(node)) {
            if(!visited.contains(child)) {
                if(hasCycle(child, graphMap, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack.contains(child)) {
                return true;
            }
        }
        recursionStack.remove(node);
        return false;
    }
}
