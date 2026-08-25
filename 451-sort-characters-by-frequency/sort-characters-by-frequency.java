class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        // Build answer
        while (!pq.isEmpty()) {
            char c = pq.poll();

            for (int i = 0; i < map.get(c); i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}