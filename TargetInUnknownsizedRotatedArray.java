
/*Leetcode 702: (Medium) Given an Integer array sorted in ascending order, write a function to search target in nums if Target exists return -1. However the
array size is unknown. Only access the array using ArrayReader.get from ArrayReader intercface.
ArrayReader.get(k) return the element of he array at Index k.
You may assume all integers in the array are less than 10000 and
if you access the array out of bounds; ArrayReader.get(k) will return the 2147483647.

* */


public class TargetInUnknownsizedRotatedArray
{
    public int search(ArrayReader reader, int target)
    {
        int low = 0, high =1;
        while (reader.get(high) <=target)
        {
            low =high;
            high = high *2;

        }
        return binarySearch(reader, target, low, high)

    }

    public  int binarySearch(ArrayReader reader, int target, int low, int high)
    {
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid)  > target) //targt exists in left sub tree
            {
                high = mid-1;
            }
            else    // target lies in right subtree.
            {
                low = mid +1;
            }
        }
        return -1;
    }

}

/*Time Complexity : O(log N)
Space Complexity : O(1)
Approach: I don't know the size of the array! So, I set my low nd high pointer to start of the indices.
Now, I will go to the limit of array by doubling my high pointer - this is reverse method we use in binary search.
so, in that I am halving my search space by doubling the pointer.

Now, that would be a point, when my reader will give me a value 2^32 -1(given constraints),
when I am accessing array out of bound. I will mark this point as high and I already have my low from previous iterations.
So, with that low and new high, I will perform traditinal binary search, by halving the number of cases.
So in total , time complexity will be O(log N)+ O(log N) = 2O(log N) ~=  O(log N)!
*
* */