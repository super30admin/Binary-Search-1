/*
Leet Code Problem 705
Search in a Sorted Array of Unknown Size
Language Used : Java
*/

/*
Sample Input
array = [-1,0,3,5,9,12]
target = 9
Output =4

array = []
target = 2
output = -1

Unable to run as ArrayReader not importing
Logic: Find low and hig in log n time using 2*high method. Once you get low and high value perform binary search
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high= 1;
        int mid;
        //Setting the high - log n 
        while(reader.get(high)!=Integer.MAX_VALUE&&target<reader.get(high))
        {
            low = high;
            high = high*2;
        }
        //perform binary search here
        while(low <= high){
            mid= low + (high-low)/2;
            // Check for the element in mid
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)>target)
                high=mid-1;
            else
                low=mid+1;                                
        }
        return -1;
    }
}