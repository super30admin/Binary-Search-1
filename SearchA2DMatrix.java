// Time Complexity : m+log(n)
// Space Complexity : O(1)
//https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    private boolean binarySearch(int arr[],int low,int high, int key) {
		if(low<=high && low<=arr.length-1) {
			int mid = (low+high)/2;
			mid = (low+high)/2;
			int val = arr[mid];
			if(arr[mid] == key) {
				return true;
			}else if(key > arr[mid]) {
				low = mid + 1;
				return binarySearch(arr,low,high,key);
			}else {
				high = mid - 1;
				return binarySearch(arr,low,high,key);
			}
		}
		return false;
	}
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        for(int i=0;i<rows;i++){
            if(target < matrix[i][columns-1]){
                return binarySearch(matrix[i],0,columns-1,target);
            }else if(target == matrix[i][columns-1]){
                return true;
            }
        }
        return false;
    }
                     
}
