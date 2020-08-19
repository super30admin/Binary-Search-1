//Time Complexity: O(nlogn) // since we will iterate the whole array to find the low and high until the val is greater than the target and then we will call binary seach method
//Space complexity: O(1)

public class BinarySearchInfiniteArray {
    public static int search(int[] nums, int target) {
        if(nums.length >= 2){
            int l = 0, h = 1;
            int val = nums[0];
            while (val < target) 
            { 
                l = h;    
                h = 2*h;      
                if(h > nums.length-1){
                    h = nums.length-1;
                }
                val = nums[h];
            }
            return bs(nums, l, h, target);  
        }   
        else if(nums.length == 1 && nums[0] == target)
            return 0;
        else{
            return -1;
        }
    }
    
    public static int bs(int[] nums, int l, int r, int x){
        if(r>=1){
            int m = (l+r)/2;
            if (nums[m] == x) 
                return m; 
            if (nums[m] > x) 
                return bs(nums, l, m-1, x); 
            return bs(nums, m+1, r, x); 
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,5,6};
        int target = 1;
        System.out.println(search(nums, target));
    }
}