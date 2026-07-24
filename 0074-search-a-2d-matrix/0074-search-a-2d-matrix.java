class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = -1;
        int top =0;
        int bottom = m-1;
        while(top<=bottom){
            int mid = (top+bottom)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]){
                row = mid;
                break;
            }else if(target<matrix[mid][0]){
                bottom = mid-1;
            }else top = mid+1;
        }
        if(row == -1)return false;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid]<target){
                left = mid+1;
            }else right = mid-1;
        }
        return false;
    }
}