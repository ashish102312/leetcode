class Solution {
    public int minimumPushes(String word) {
         int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int pushes = 0;
        int index = 0;
        // Traverse from highest frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            int cost = (index / 8) + 1;
            pushes += freq[i] * cost;
            index++;
        }
        return pushes;
    }
}