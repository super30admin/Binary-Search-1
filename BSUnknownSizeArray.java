import java.util.ArrayList;

import java.util.List;
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. We would be jumping 2X steps in order to find a subarray where our element lies.
2. Once we  have a subarray we can perform a normal Binary Search on it to find the element.
*/

public class BSUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target)
            return 0;
         int i=1;
         //System.out.println(reader.get(i));
         while(reader.get(i)<target)
             i*=2;
        return  binarySearch(reader,i/2+1,i,target);
     }
     public int binarySearch(ArrayReader reader,int left,int right,int target)
     {
         while(left<=right)
         {
             int middle= (left+right)/2;
             if(reader.get(middle)==target)
                 return middle;
             else if(reader.get(middle)>target)
             {
                 right=middle-1;
             }
             else left=middle+1;
         }
         return -1;
     }
     public static void main(String[] args)
     {
         List<Integer> list=new ArrayList<Integer>(List.of(-1,0,3,5,9,12));
         
         ArrayReader reader=new ArrayReaderImpl(list);
       
         BSUnknownSizeArray bs=new BSUnknownSizeArray();
         System.out.println(bs.search(reader, 9));
         System.out.println(bs.search(reader, 2));

     }
}
