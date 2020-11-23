//Program to search the target in an array of unknown size and the elements are sorted in ascending order

// Time Complexity :  O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : yes




/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */ 

class Search2 {


    public int search(ArrayReader reader, int target) {    
        int l=0,h=1;                                                //initializing low and high pointers
        while(target>reader.get(h)){                                //till our target is greater than the element at high index, assign high to low and increment h*2             
            l = h;
            h = h*2;            
        }   
        return bs(reader,l,h,target);                                       //doing binary search
    }
    
    
    public int bs(ArrayReader reader,int l, int h, int target){
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            int element = reader.get(mid);
            if(target == element){
                return mid;
            }
            if(target<element){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
       return -1; 
    }
}