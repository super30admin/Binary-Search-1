/*
Given a sorted array of unknown length and a number to search for, return the index of the number in the array. 
Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of 
any occurrence. If it isn’t present, return -1.
*/

import java.util.*;
public class Problem3 
{
    public int search(ArrayReader reader, int target)
    {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target) // log step
        {
            low = high;
            high = high*2;
        }
        while(low <= high)
        {
            int mid = low + (high - low)/2; //to avoid integer overflow
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }
        return -1;
    }
}
