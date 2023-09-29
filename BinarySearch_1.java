// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class BinarySearch_1 {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while(l<=h){
            int mid = (l + h)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[l] <= nums[mid]){
                if(nums[l]<=target && target <= nums[mid]){
                    h = mid - 1;
                }
                else{
                    l = mid +1;
                }   
            }
            else{
                if(nums[mid]<=target && target <= nums[h]){
                    l = mid + 1;
                }
                else{
                    h = mid - 1;
                }
            }

        }
        return -1;
    }
    
    public static void main(String[] args) {
    	BinarySearch_1 obj = new BinarySearch_1();
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		int index = obj.search(nums, target);
		System.out.println("index : " + index);
		
		int[] nums2 = {7,0,1,2,4,5,6};
		int index2 = obj.search(nums2, target);
		System.out.println("index2 : " + index2);
		
		int[] nums3 = {1,2,4,5,6,7,0};
		int index3 = obj.search(nums3, target);
		System.out.println("index3 : " + index3);
		
		int[] nums4 = {7,0,1,2,4,5,6};
		int target4 = 7;
		int index4 = obj.search(nums4, target4);
		System.out.println("index2 : " + index4);
		
		int[] nums5 = {1,2,4,5,6,7,0};
		int target5 = 0;
		int index5 = obj.search(nums5, target5);
		System.out.println("index3 : " + index5);
		
	}
}