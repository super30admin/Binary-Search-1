//time complexity: O(logn)
//space complexity : O(1)
//executed on leetcode : yes
//approach : 1. find out the element where the array has been rotated. 2. if the target lies between the pivot element and end element, we apply binary search in that part of array else we apply binary search on the other part.

class Rotated {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums==null) return -1;
        int left = 0;
        int result = -1;
        int right = nums.length-1;
        while(left<right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[right]) left = mid + 1;
            else right = mid;
        }
        int pivot = left;
        left  = 0;
        right = nums.length-1;
        if(target>=nums[pivot] && target<=nums[right]) left = pivot;
        else right = pivot;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(target==nums[mid]) return mid;
            else if(nums[mid]<target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }
    public static void main(String[] args)
    {
        Rotated obj = new Rotated();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.print("index of target="+obj.search(nums,target));
    }
}