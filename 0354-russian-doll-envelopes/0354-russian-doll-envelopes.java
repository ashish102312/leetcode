class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            if(a[0]==b[0])return b[1]-a[1];//descending order of height
            return a[0]-b[0];//asecending order for width
        });
        int[] tails = new int[envelopes.length];
        int size = 0;
        for(int[] en : envelopes){
            int h = en[1];
            int left = 0;
            int right = size;
            while(left<right){
                int mid = left+(right-left)/2;
                if(tails[mid]<h)left = mid+1;
                else right = mid;
            }
            tails[left]=h;
            if(left == size)size++;
        }
        return size;
    }
}