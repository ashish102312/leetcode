class Solution {
        public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        LongestSubstringSegmentTree segmentTree = new LongestSubstringSegmentTree(s);
        char[] source = s.toCharArray();
        int queryLength = queryIndices.length;
        int[] longestSubstring = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {
            int index = queryIndices[i];

            char currChar = source[index];
            char newChar = queryCharacters.charAt(i);

            if (newChar != currChar) {
                source[index] = newChar;
                segmentTree.update(index, newChar);
            }

            longestSubstring[i] = segmentTree.query(0, s.length() - 1).substring;
        }

        return longestSubstring;
    }

    static class LongestSubstringSegmentTree {

        private static class Node {

            int substring;
            int prefix;
            int suffix;
            boolean isEmpty;

            public Node(int longestSubstring, int longestPrefixSubstring, int longestSuffixSubstring, boolean isEmpty) {
                this.substring = longestSubstring;
                this.prefix = longestPrefixSubstring;
                this.suffix = longestSuffixSubstring;
                this.isEmpty = isEmpty;
            }

            public static Node getEmpty() {
                return new Node(0, 0, 0, true);
            }

            public static Node singleNode(int val) {
                return new Node(val, val, val, false);
            }

            public boolean getIsEmpty() {
                return isEmpty;
            }
        }

        private final int size;
        private final Node[] tree;
        private final char[] arr;

        public LongestSubstringSegmentTree(String s) {
            this.size = s.length();
            this.tree = new Node[size << 2];
            this.arr = s.toCharArray();

            build(0, 0, size - 1);
        }

        // Returns the maximum subarray sum in the inclusive range [left, right].
        private Node query(int queryLeft, int queryRight) {
            return query(0, 0, size - 1, queryLeft, queryRight);
        }

        // Updates whole tree based on this new value at the given index.
        private void update(int index, char ch) {
            arr[index] = ch;
            update(0, 0, size - 1, index, ch);
        }

        private Node query(int nodeIndex, int left, int right, int queryLeft, int queryRight) {
            if (queryLeft <= left && queryRight >= right) return tree[nodeIndex];
            if (queryLeft > right || queryRight < left) return Node.getEmpty();

            int mid = left + ((right - left) >> 1);

            int leftChild = nodeIndex * 2 + 1;
            int rightChild = nodeIndex * 2 + 2;

            Node leftResult = query(leftChild, left, mid, queryLeft, queryRight);
            Node rightResult = query(rightChild, mid + 1, right, queryLeft, queryRight);

            return merge(leftResult, rightResult, left, right);
        }


        private void update(int nodeIndex, int left, int right, int index, char newChar) {
            if (left == right) {
                // nothing to change as we are not storing char as leaf nodes
                return;
            }

            int mid = left + ((right - left) >> 1);
            int leftChild = 2 * nodeIndex + 1;
            int rightChild = 2 * nodeIndex + 2;

            if (index <= mid) update(leftChild, left, mid, index, newChar);
            else update(rightChild, mid + 1, right, index, newChar);

            tree[nodeIndex] = merge(tree[leftChild], tree[rightChild], left, right);
        }

        private Node merge(Node left, Node right, int start, int end) {
            if (left.isEmpty) return right;
            if (right.isEmpty) return left;

            int mid = start + ((end - start) >> 1);
            int leftLen = mid - start + 1;
            int rightLen = end - mid;
            boolean edgesMatch = arr[mid] == arr[mid + 1];
            // 0000 0000
            int longestSubstring = Math.max(left.substring, right.substring);
            if (edgesMatch) { // merging points have same char, then left's suffix and right's prefix can be considered
                longestSubstring = Math.max(longestSubstring, left.suffix + right.prefix);
            }

            int longestPrefixSubstring = left.prefix;
            if (edgesMatch && left.prefix == leftLen) {
                longestPrefixSubstring += right.prefix;
            }

            int longestSuffixSubstring = right.suffix;
            if (edgesMatch && right.suffix == rightLen) {
                longestSuffixSubstring += left.suffix;
            }

            return new Node(longestSubstring, longestPrefixSubstring, longestSuffixSubstring, false);
        }

        private void build(int nodeIndex, int left, int right) {
            if (left == right) {
                tree[nodeIndex] = Node.singleNode(1);
                return;
            }

            int mid = left + ((right - left) >> 1);

            int leftChild = 2 * nodeIndex + 1;
            int rightChild = 2 * nodeIndex + 2;

            build(leftChild, left, mid);
            build(rightChild, mid + 1, right);

            tree[nodeIndex] = merge(tree[leftChild], tree[rightChild], left, right);
        }
    }
}