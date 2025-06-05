class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Set<Character>> equivalenceMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            equivalenceMap.putIfAbsent(c1, new HashSet<>());
            equivalenceMap.putIfAbsent(c2, new HashSet<>());

            equivalenceMap.get(c1).add(c2);
            equivalenceMap.get(c2).add(c1);
        }

        Map<Character, Character> smallestCharMap = new HashMap<>();
        for (char c : equivalenceMap.keySet()) {
            smallestCharMap.put(c, findSmallest(c, equivalenceMap, new HashSet<>()));
        }

        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append(smallestCharMap.getOrDefault(c, c));
        }

        return result.toString();
    }

    private char findSmallest(char c, Map<Character, Set<Character>> map, Set<Character> visited) {
        if (visited.contains(c)) return c;
        visited.add(c);

        char smallest = c;
        for (char neighbor : map.getOrDefault(c, new HashSet<>())) {
            smallest = (char) Math.min(smallest, findSmallest(neighbor, map, visited));
        }

        return smallest;
    }
}