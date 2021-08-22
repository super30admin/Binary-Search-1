//33. Search in Rotated Sorted Array
public class searchRotated
{

    public static void main(String[] arg)
    {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int ans = search(nums,0);
        System.out.println("__ANS___:"+ans);
    }

    public static int search(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high)
        {
            int m = low + (high - low) / 2;
            if (nums[m] == target)
            {
                return m;
            }
            else if (nums[low] <= nums[m])
            {
                if (nums[low] <= target && nums[m] > target)
                {
                    high = m - 1;
                }
                else
                {
                    low = m + 1;
                }
            }
            else
            {
                if (nums[m] < target && nums[high] >= target)
                {
                    low = m + 1;
                }
                else
                {
                    high = m - 1;
                }
            }
        }
        return -1;
    }
}
