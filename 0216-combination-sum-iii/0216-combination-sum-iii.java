class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
    backtrack(k,n,1,0,new ArrayList<>());
    return ans;
    }
    private void backtrack(int k, int target, int start, int sum , List<Integer>path){
        if(path.size() == k ){
            if(sum == target){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if(sum>target) return;

        for(int i = start; i<=9; i++){
            path.add(i);

            backtrack(k , target, i+1, sum+i, path);
            path.remove(path.size()-1);
        }
    }
}