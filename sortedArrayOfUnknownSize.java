/**Time Complexity :
    O(log n)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
// Your code here along with comments explaining your approach
**/




class sortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;

        //if increase the high, till we found target is smaller than high element
        while(target>reader.get(high)){
            high=high*2;
            if(reader.get(high)==target) return high;
        }

        //once we found high calculate low 
        low=high/2;
        while(low<=high){

            //apply binary search 
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}