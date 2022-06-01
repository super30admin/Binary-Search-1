//Time Complexity:O(log n)
//Space Complexity: O(1)
//Run successfully on LeetCode: Yes

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target)
            {
                return mid;
            }
            
            else if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && nums[mid] > target)
                {
                    high = mid - 1;
                }
                
                else
                {
                    low = mid + 1;
                }
            }
            
            else{
                if(nums[mid] < target && nums[high] >= target)
                {
                    low = mid + 1;
                }
                
                else
                {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
}    

public static void main(String[] args) {
    RotatedSortedArray rsa = new RotatedSortedArray();
    int nums[] = {4,5,6,7,0,1,2};
    System.out.println(rsa.search(nums, 0)); 
    System.out.println(rsa.search(nums, 10)); 
}
}
