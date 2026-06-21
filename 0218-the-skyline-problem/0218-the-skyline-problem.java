class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1],  b[2]});
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> height = new TreeMap<>();
        height.put(0, 1);

        List<List<Integer>> result = new ArrayList<>();

        int preMax = 0;

        for (int[] e : events) {

            int x = e[0];
            int h = e[1];

            if (h < 0) {
                h = -h;
                height.put(h, height.getOrDefault(h, 0) + 1);
            } else {
                height.put(h, height.get(h) - 1);

                if (height.get(h) == 0) {
                    height.remove(h);
                }
            }

            int currentMax = height.lastKey();

            if (currentMax != preMax) {
                result.add(Arrays.asList(x, currentMax));
                preMax = currentMax;
            }
        }

        return result;
    }
}