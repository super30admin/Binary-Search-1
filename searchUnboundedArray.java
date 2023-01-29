public class searchUnboundedArray {
    public int search(int[] nums, int target){

    int low=0;
    int high=1;
    if(reader.get(high)<=target){
        low=high;
    high=2*high;
}
    while (low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target) return mid;
        else if (nums[mid] > target) high= mid-1;
        else low=mid+1;
    }
    return -1;
}}
