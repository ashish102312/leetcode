class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i =0; i<n; i++){
            int paper = n-i;
            if(citations[i] >= paper){
                return paper;
            }
        }
        return 0;

    }
}