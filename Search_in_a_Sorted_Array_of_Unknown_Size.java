
public class Search_in_a_Sorted_Array_of_Unknown_Size {
	int target = 0;
	//Approach: 1. We need to first identify the boundary for target and then apply binary search
	//2. we have 2 pointers left and right, with 0 and 1 value, if target is not within this range,
	//we move left to right and right is doubled to get the next bigger range.
	//3. we do this since we find the range for target, once we got range, will do binary search.
	
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        this.target = target;
        while( reader.get(right) < target )
        {
            left = right;
            right = right * 2;
        }
        return binarySearch(reader, left, right);
    }
    int binarySearch(ArrayReader reader, int left, int right)
    {
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(reader.get(mid) == target)return mid;
            else if(reader.get(mid) < target)
                left = mid +1;
            else
                right = mid -1;
        }
        return -1;
    }
}

//Time Complexity : O(log N) where N is the index of target value. 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No