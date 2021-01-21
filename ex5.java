//Problem 1
//Time complexity: O(log n)
//Space complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,  m= matrix[0].length;
        int low =0;
        int high = n*m -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int i = mid/m;
            int j = mid%m;
            
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] < target){
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return false;
    }
}


//Problem 1
//Time complexity: O(log n)
//Space complexity: O(1)
class Solution2 {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        
        return binarySearch2(nums, 0, high, target);
    }
    
    public int binarySearch2(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[high] > nums[mid]){
                if(target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
            else if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
            }
                
            else{
                    low = mid + 1;
            }
            
        }
        return -1;
    }
}


//Problem 1
//Time complexity: O(log n)
//Space complexity: O(1)
class Solution3 {
    public int search(ArrayReader reader, int target) {
        
        int high = 1;
        while(reader.get(high) != Integer.MAX_VALUE && reader.get(high) <= target){
            
            high = high * 2;
        }
        
        return binarySearch(reader, 0, high, target);
        
    }
     public int binarySearch(ArrayReader reader, int low, int high, int target){
         
         while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                low = mid+1;
            }
            else
                high = mid-1;
        }
         return -1;
         
     }
    
}

