//Step 1 let's assume the input array is arr, where we can not access its length.
//Step 2 my approach is to double the pointer starting from index i=1 , if it not null we continue else we need to 
//       find the end index of array which is in beetween i/2 and i.
//Step 3 if target<arr[i] set low and high variable and do a binary seach from low to high.

//I am not able to build the Step 2 properly.
import java.util.*;
 
class Solution3 extends Exception
{
    public int search(int[] arr, int target)
    {
        boolean flag=true;
        int i=1,low=-1,high=-1;
        try{
        if(arr[0]==target)
            return 0;
        }
        catch(Excpetion e)
        {
            return -1;
        }
        while(flag)
        {
            try{
                if(target>arr[i])
                    i=i*2;
                else if(target<arr[i])
                    {
                        low=i/2;
                        high=i;
                        break;
                    }
                else 
                    return i;
            
            }
            catch(Exception e)
            {
                flag=false;
            }
        }


        if(flag)
        {
            while(low<high)
                {
                    int mid=(low+high)/2;
                    if(target>arr[mid])
                        low=mid+1;
                    else if(target<arr[mid])
                        high=mid-1;
                    else
                        return mid;
                }
        }

    }

}