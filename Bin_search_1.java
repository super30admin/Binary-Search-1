class Solution5 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;
    }
}

class Solution6 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)  
            return -1;
        int low = 0, high = nums.length -1;
        while(low<= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[low] <= nums[mid])
            {
                if(target < nums[mid] && target >= nums[low])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else
            {
                if(target <= nums[high] && target > nums[mid])
                    low = mid +1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}

class Solution7 {
    public int search(ArrayReader reader, int target){
        int low = 0, high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high * 2;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}