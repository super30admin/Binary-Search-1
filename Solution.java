/*
    Time Complexity : O(n*logn)
    Space Complexity: O(1)
    
    Accepted Leetcode URL: https://leetcode.com/submissions/detail/632640618/
    
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            if(binarySearch(matrix[i], target)){
                return true;
            }else{
                continue;
            }
        }
        
        return false;
    }
    
    public boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(target > arr[mid]){
                left = mid + 1;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else{
                return true;
            }
        }
        
        return false;
    }
}
