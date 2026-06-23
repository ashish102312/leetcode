class Solution {
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;//rows
        int n = heightMap[0].length;//coulmn

        if (m < 3 || n < 3)
            return 0;

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        //add all bundary cells
        for (int i = 0; i<m; i++) {

            pq.offer(new int[]{heightMap[i][0],i,0});
            pq.offer(new int[]{heightMap[i][n-1],i,n-1});
            //marking
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j<n - 1; j++) {

            pq.offer(new int[]{heightMap[0][j],0,j});
            pq.offer(new int[]{heightMap[m-1][j],m-1,j});
            //marking
            visited[0][j] = true;
            visited[m-1][j] = true;
        }

        int water = 0;

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int h = curr[0];
            int r = curr[1];
            int c = curr[2];

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr<0 ||nr>=m ||nc<0 ||nc>=n ||visited[nr][nc])continue;

                visited[nr][nc] = true;

                water += Math.max(0,h - heightMap[nr][nc]);
                pq.offer(new int[]{
                Math.max(h, heightMap[nr][nc]),nr,nc});
            }
        }

        return water;
    }
}