public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // base case
            if(nums[mid] == target)
                return mid;

            if(nums[mid] >= nums[low]) {
                if(target >= nums[low] && target < nums[mid])
                    high = mid-1;
                else
                    low = mid + 1;
            } else {
                if(target <= nums[high] && target > nums[mid])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray=new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2},0));
    }
}
