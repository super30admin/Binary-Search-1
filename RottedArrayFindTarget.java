package Binary_Search_one.RotatedArrayFindTarget;

public class RottedArrayFindTarget
{
    public int search(int[] nums, int target)
    {
        int high =nums.length -1, low  =0;

        if(nums==null || nums.length == 0)
        {
            return  -1;
        }
        while(low <=high)
        {
           int  mid = low + (high - low)/2;

           if(nums[mid] ==  target)
           {
               return mid;
           }

           if(nums[low] <= nums[mid]) //checking for which size is sorted
           {
               //This left side is sorted

               if(nums[low] <=  target && nums[mid] > target)
               {
                   //target lies into the left subtree.
                   high = mid -1;
               }
               else
               {
                   //target lies into the roght subtree.
                   low = mid +1;
               }
           }

           else if(nums[mid] <= nums[high])
           {
               //Right side is sorted
               if(nums[mid] < target && nums[high] >= target)
               {
                   //targget lies here in the right side
                   low = mid+1;
               }
               else
               {
                   //target lies onto the unsorted part - left side
                   high = mid -1;
               }

           }

        }
        return -1;

    }

}



class Main
{
    public static void main(String[] args) {
        int [] arr ={4,5,6,7,0,1,2};
        RottedArrayFindTarget obj = new RottedArrayFindTarget();
        System.out.println("output is ::" + obj.search(arr, 25));
    }
}


/*
* Time complexity : O(log N)        because its binary search
* space Complexity: O(1)             we are not using any auxiliary space, we are just doing search operation on the given array!
*
* approach:
* because the given array is Rotated, we can say that either of the side of the middle element will be sorted.
so, we will look for that sorted side first.
now once I get the sorted side, I willl check if the target lies ito the sorted side! if yes, I will upadate my pointers accordingly.
* if I found that target is not placed on the sorted side, I know it would be on unsorted side,
* so i will on that part and look for the target over there.
*/