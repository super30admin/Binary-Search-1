
//Implemented in two approaches
class SearchInRotatedArray {

    //TC : TC is O(logN) as all BinarySeach and findRotatedIndex methods used in search_approach_one method have O(logN) TC
    //SC : O(1)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
    public int search_approach_one(int[] nums, int target) {

        //need to handle the case where the length of array is 1
        if(nums.length==1)
        {
            if(target == nums[0])
                return 0;
            else
                return -1;
        }


        int rot = findRotationIndex(nums, target);

        //case where the array is not rotated, search the whole array
        if(rot == 0)
            return binarySearch(nums,target,0,nums.length-1);


        if(target >= nums[0])
            return binarySearch(nums, target, 0, rot);

        else if( target < nums[0])
            return binarySearch(nums,target,rot,nums.length-1);

        return -1;

    }


    //one pass binary search approach
    //TC : O(logN)
    //SC O(1)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
    public int search_approach_two(int[] nums, int target)
    {

        int left = 0;
        int right = nums.length-1;

        while(left <=right)
        {
            int mid = left + (right - left)/2;
            if(target == nums[mid])
                return mid;

            //[mid]>= [left] means that the part of array : [left,mid] is sorted. There can be two cases :
            //case 1 : [left] < target < [mid] --> perform binary search on this subset
            //case 2 : target lies on the right side of mid, hence left = mid +1
            if(nums[mid] >= nums[left])
            {
                if(target >= nums[left] && target <nums[mid])
                    return binarySearch(nums, target, left, mid-1 );
                else
                    left = mid+1;
            }

            //[mid] <  [left] means that the part of array : [mid, right] is sorted. Similar as above, there can be two cases :
            //case 1 : [mid] < target < [right] -->perform binary search on this sorted subarray
            //case 2 : target lies on the left side of mid, hence set right = mid-1
            else
            {
                if(target > nums[mid] && target <= nums[right])
                    return binarySearch(nums, target, mid+1, right);
                else
                    right = mid-1;

            }
        }

        return -1;

    }

    //normal binary search
    public int binarySearch(int[] nums, int target, int left, int right)
    {

        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] < target)
                left = mid+1;
            else if(nums[mid] > target)
                right = mid-1;
            else
                return mid;

        }
        return -1;
    }


    //method to find the index at which the array is rotated
    public int findRotationIndex(int[] nums, int target)
    {

        int left = 0;
        int right = nums.length-1;
        if(nums[0] < nums[nums.length-1])
            return 0;

        while(left<=right)
        {
            int mid = left + (right-left)/2;

            // if the element immediately to the right of mid is lesser than the element at mid, then our answer is mid+1
            if(nums[mid]>nums[mid+1])
                return mid+1;

            //if mid element is greater than or equal to the left element that means we need to search in right half for the rotated index

            //Explanation for including the "=" sign here : for the case where elements at mid and left indices are equal
            // and the function didn't satisfy  the previous if(nums[mid]>nums[mid+1]),
            // means that there are still element greater than the element at left index.
            // here consider the case where left =0, right =1 for [4,5,1,2,3]. Here element at mid and left are equal,
            //in this case we need to search the right half to find the rotation index.

            if(nums[mid] >= nums[left])
                left = mid+1;
            //if mid element is lesser than right element that means we have to search in the left half for the rotated index
            else if(nums[mid] < nums[left])
                right = mid-1;


        }
        return 0;

    }


}