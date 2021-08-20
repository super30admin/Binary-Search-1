
public class BinarySearch1 {
    /*Search a 2D Matrix*/
    // Time Complexity : logN
    // Space Complexity : o(1)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : yes , confused with my space complexity here we are given
    // a 2D matrix and we just use 3 pointers to find our target hence I think space complexity should be O(1)
    // is my understanding correct ?
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length ;
        int nc = matrix[0].length;
        int low = 0;
        int high = (nr*nc)-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int r = mid/nc;
            int c = mid%nc;
            if(matrix[r][c]<target){
                low = mid+1;
            }else if(matrix[r][c]>target){
                high = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
/*Search in a Rotated Sorted Array*/
    // Time Complexity : Logn
    // Space Complexity : o(1)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no


    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]== target){
                return mid;
            }else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && nums[mid]>target){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
                
            }else {
                if(nums[mid]<target && nums[high]>=target){
                    low= mid+1;
                }else{
                    high= mid-1;
                }
            }

        }
        return -1;
    }

    /*Search in Infinite sorted array*/
    // Time Complexity : Logn
    // Space Complexity : o(1)
    // Did this code successfully run on Leetcode : no( I dont have a premium and it doesnt open without a premium subscription)
    // Any problem you faced while coding this : no

    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high)<target){
            low = high;
            high = high*2;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(reader.get(mid)== target){
                return mid;
            }else if(reader.get(mid)<target ){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
       
}