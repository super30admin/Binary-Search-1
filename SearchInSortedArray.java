class SearchInSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[start]) {
                //means left half of the array is sorted
                if (nums[mid]>=target && nums[start]<=target)
                    end = mid-1;  //if the target lies in the left half, bring the end to the left half
                else start = mid+1; //otherwise, bring start to the right half and search in right half of the array
            }
            else{
                //means right half of the array is sorted
                if(nums[mid]<=target && nums[end]>=target)
                    start = mid+1; //if the target lies in the right half, bring the start to the right half
                else end=mid-1; //otherwise, bring end to the left half and search in left half of the array
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInSortedArray obj = new SearchInSortedArray();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 4;
        int res = obj.search(nums, target);
        System.out.println("result = " + res);

    }
}