// Binary search for umlimited array size


// solution working in leetcode, arrayreader is an inteface

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left <= right)
        {
            int pivot = left +(right-left)/2;// to prevent the overflow
            int num = reader.get(pivot);
            if(num == target)
            {
                return pivot;
            }
            else if(num <target)
            {
                left = pivot + 1;
            }
            else
                right = pivot - 1;

            
        }
        return -1;
        
    }
}