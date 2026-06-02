class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord))return 0;

        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);
        int level = 1;

        while(!qu.isEmpty()){
            int size = qu.size();

            for(int i = 0; i<size; i++){
                String word = qu.poll();

                if(word.equals(endWord)) return level;

                char[] arr = word.toCharArray();
                for(int j = 0; j<arr.length; j++){
                    char Orignal = arr[j];

                    for(char ch = 'a'; ch<='z'; ch++){
                        arr[j] = ch;

                        String nextWord = new String(arr);

                        if(set.contains(nextWord)){
                            qu.offer(nextWord);
                            set.remove(nextWord);
                        } 
                    }
                    arr[j] = Orignal;
                }
            }
            level++;
        }
        return 0;
    }
}