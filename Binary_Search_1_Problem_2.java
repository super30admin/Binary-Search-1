//Time Complexity : O(logn) (logn + logn)
//Space Complexity : O(1) As no auxilary space is used
// Have not bough leetcode premium yet
// Problems :  No problem



/*
As we don't know the size of the array,
we'll be increasing (double) the search space every time
and be applying binary search on that
 */


public class Binary_Search_1_Problem_2 {
    public static int search(int[] nums,int target)
    {
        if(nums == null || nums.length ==0)
        {
            return -1;
        }
        int left = 0;
        int right= 1;
        int index = -1;
        while(index == -1)
        {
            index = BinarySearch(nums,target,left,right);
            left = right;
            right = 2*right;
        }
        return index;
    }
    public static int BinarySearch(int[] nums,int target,int left, int right)
    {
        while (left<=right)
        {
            int mid = left + (right -left)/2;
            if(nums[mid]==target)return mid;
            else if(target<nums[mid])
            {
                right = mid -1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,10,22,55,60,70,80,90,92,95,885};
        int target = 95;
        System.out.println(search(arr,target));

    }


}
