class Solution {
    int[] nums;
    int target;
    
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int n = nums.length;
        
        if(n == 0)
            return -1;
        if(n == 1)
            return this.nums[0] == target ? 0 : -1;
        
        int rotate_index = find_rotate_index(0, n - 1);
        
        if (nums[rotate_index] == target)
            return rotate_index;
        
        if(rotate_index == 0)
            return search(0, n - 1);
        else if(target < nums[0])
            return search(rotate_index, n - 1);
        return search(0, rotate_index);
    }
    
    public int search(int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target)
                return mid;
            else {
                if(target < nums[mid]) 
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
    
    public int find_rotate_index(int start, int end){
        if(nums[start] < nums[end])
            return 0;
    
        while(start <= end){
            int pivot = (start + end) / 2;
            if(nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if(nums[pivot] < nums[start]) 
                    end = pivot - 1;
                else 
                    start = pivot + 1;  
            }
        }
        return 0;
    }
}