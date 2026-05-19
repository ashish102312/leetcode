class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);

        backtrack(s,set,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(String s, Set<String> set, List<String> path, List<String> result){
        if(s.length() == 0){
            result.add(String.join(" ",path));
            return;
        }

        for(int i = 1; i<=s.length(); i++){
            String he = s.substring(0,i);

            if(set.contains(he)){
                path.add(he);
                backtrack(s.substring(i),set,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}