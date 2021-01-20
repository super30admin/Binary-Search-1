//Array with unknown length 
//Step 1 let's assume the input array is arr, where we can not access its length.
//Step 2 my approach is to double the pointer starting from index i=1 , if it not null we continue else we need to 
//       find the end index of array which is in beetween i/2 and i.
//Step 3 if target<arr[i] set low and high variable and do a binary seach from low to high.

//I am not able to build the Step 2 properly.

//Assuming instead of exception we have arrayreader which return Integer.maxvalue
import java.util.*;

class ArrayReader
{
    int[] arr;
    ArrayReader()
    {}
    ArrayReader(int [] array)
    {
        arr=array;
    }
    public int get(int index)
    {
    try{
        return arr[index];           
    }
    catch(Exception e){
            return Integer.MAX_VALUE;
    }
}
}
 
class Solution3 extends ArrayReader

{
public int search(int target,ArrayReader reader)
    {
               int low=0;int high=1;
               while(reader.get(high)<=target){
                    low=high;
                    high=high*2;
               }
                return binarysearch(reader,target,low,high);
           
        }

        public int binarysearch(ArrayReader reader,int target, int low,int high)
        {
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(reader.get(mid)==target)
                    return mid;
                if(reader.get(mid)<target)
                    low=mid+1;
                else
                    high=mid-1;
            }
            return -1;
        }

        public static void main(String args[])
        {
            Solution3 s= new Solution3();
           
            int[] arr=new int[]{1,4,6,8,9,10,40,Integer.MAX_VALUE,Integer.MAX_VALUE ,Integer.MAX_VALUE};
                ArrayReader reader= new ArrayReader(arr);
            System.out.println(s.search(11,reader));
        }

    }



