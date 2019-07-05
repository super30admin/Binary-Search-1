public class SearchRSA2 {
    public int binarySearch(int[] nums,int start,int end,int value){
        if(start>end)
            return -1;
        int mid = start+(end-start)/2;
        if(nums[mid]==value)
            return mid;
        if(nums[mid]>=nums[start]){
            if(value>=nums[start] && value<nums[mid]){
                end = mid-1;
            }
            else
                start = mid+1;
        }
        else{
            if(value>nums[mid] && value<=nums[end])
                start = mid+1;
            else
                end = mid-1;
        }
        return binarySearch(nums,start,end,value);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    public static void main(String[] args) {
        SearchRSA2 obj = new SearchRSA2();
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int x  = obj.search(nums,5);
        System.out.println(x);
    }
}
