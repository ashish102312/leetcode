class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]> []gr = new ArrayList[n+1];
        for(int i = 0 ; i<= n; i++){
            gr[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            gr[road[0]].add(new int[]{road[1],road[2]});
            gr[road[1]].add(new int[]{road[0],road[2]});
        }
        boolean[] visit = new boolean[n+1];
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1);
        visit[1] = true;
        int ans = Integer.MAX_VALUE;
        while(!qu.isEmpty()){
            int node = qu.poll();
            for(int[] edge : gr[node]){
                ans = Math.min(ans,edge[1]);
                if(!visit[edge[0]]){
                    visit[edge[0]] = true;
                    qu.offer(edge[0]);
                }
            }
        }
        return ans;

    }
}