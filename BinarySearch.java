//Time Complexity: O(logn) since we keep dividing the array and search in the half arrays
//Space complexity: O(1)

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i+j)/2;
            System.out.println(m);
            if (nums[m] == target) 
                return m;
            if (nums[i] <= nums[m]) {
                if(nums[i] <= target && target <= nums[m])    
                    j = m-1;
                else
                    i = m+1;  
            }
            else{
               if(nums[m] <= target && target <= nums[j])    
                    i = m+1; 
                else
                    j = m-1;
            }
        }
        return -1;     
    }
        
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
    
    
}