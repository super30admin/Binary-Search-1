class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix[0].length-1;
        int m=matrix.length-1;
        for(int i=0;i<=m;i++){
            if((target >= matrix[i][0]) && (target <= matrix[i][n])){
                if(findEle(matrix[i], target)){
                    return true;
                }else{
                    return false;
                }
            }}
        return false;
    }

    public boolean findEle(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right - left)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(target < arr[mid]){
                right=mid-1;
            }else if(target > arr[mid]){
                left = mid+1;
            }
        }
        return false;
    }
}
