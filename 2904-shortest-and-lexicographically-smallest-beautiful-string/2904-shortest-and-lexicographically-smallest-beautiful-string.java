class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        ArrayList<Integer> pos = new ArrayList<>();

        // Store positions of all 1s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                pos.add(i);
            }
        }

        // Not enough 1s
        if (pos.size() < k) {
            return "";
        }

        String ans = "";

        // Take every group of k consecutive 1s
        for (int i = 0; i + k - 1 < pos.size(); i++) {

            int start = pos.get(i);
            int end = pos.get(i + k - 1);

            String candidate = s.substring(start, end + 1);

            // First candidate OR better candidate
            if (ans.equals("") ||
                candidate.length() < ans.length() ||
                (candidate.length() == ans.length()
                 && candidate.compareTo(ans) < 0)) {

                ans = candidate;
            }
        }

        return ans;
    }
}