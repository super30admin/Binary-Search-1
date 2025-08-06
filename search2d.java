
// So my approach here is I'm using the binary search to potentially find where the target element potentially could be present. Once I found the row where the target element could potentially be, I performed another binary search on that list.
//Since two binary searches are performed the time complexity would be O(log m +log n).
//Since we are not using any additional space this algorithm would run in a constant space. 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m-1;
        //finding the row
        while(low<high){
            int mid=low+(high-low)/2;
            if(matrix[mid][n-1]>=target)high=mid;
            else low=mid+1;
        }
        //finding the element
        int[] list=matrix[low];
        int left=0;
        int right=list.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list[mid]==target) return true;
            if(list[mid]>target)right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}