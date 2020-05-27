class Solution {
    public int search(int[] nums, int target) {
        int pivot = findMisplacedPivot(nums, 0,nums.length-1);
        int index = -1;
        if(pivot > -1){
            if(nums[pivot] > target)
                index =  binarySearch(nums, pivot+1, nums.length-1, target);
             else if(nums[pivot] < target)
                 index =  binarySearch(nums,0,pivot,target);
            else if(nums[pivot] == target)
                return pivot;
        }
        return index;
    }

    private int findMisplacedPivot(int[] nums,int low, int high){
        if(low<=high){
            if(low == 0 && high == 0)
                return 0;
            else{
                int partition = (low + high)/2;
                if(nums[partition] < nums[low])
                    findMisplacedPivot(nums,low,partition-1);
                else if(nums[partition] > nums[high])
                    findMisplacedPivot(nums,partition+1, high);
                return partition;
            }
        }
        return -1;
    }

    private int binarySearch(int[]nums, int low, int high, int target){
        while(low<=high){
            int partition = (low + high)/2;
            if(nums[partition] == target)
                return partition;
            if(nums[partition] < target)
                low = partition+1;
            else
                high = partition-1;
        }
        return -1;
    }
}