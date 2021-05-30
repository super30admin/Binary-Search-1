public class SearchRotate {
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length -1;
        while(l<=h)
        {
            int mid = l+(h - l)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if (nums[l]<=nums[mid])
            {
                if(nums[l] <= target && nums[mid] > target) {
                    h = mid - 1;
                }
                else
                    l=mid+1;
            }
            else
            if(nums[mid]< target && nums[h]>=target)
                l = mid +1;
            else
                h = mid -1;
        }
        return -1;
    }
    public static void main(String args[])
    {
        SearchRotate obj = new SearchRotate();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(obj.search(nums,target));
    }
}