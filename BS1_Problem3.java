// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Problem3 - Search in a Sorted Array of Unknown Size
/*
We are looking for the range in which target occurs in the array
We are updating values of low and high till element is high is greater than target

Then simply applied binary search to find if target is in the range low to high or not.
*/

class Main {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        
        //Reader is interface and items stores in array accessed by reader

        while(reader.get(high) < target){ // FINDING THE RANGE FOR GIVEN TARGET 
            low = high;
            high = 2 * high;
        }
        //NOW WE HAVE RANGE TO FIND TARGET AND APPLYING BINARY SEARCH ON THAT RANGE
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;        
    }
}




public class BS1_Problem3 {
    public static void main(String[] args){
        Main m1 = new Main();
        //Reader is interface and items stores in array accessed by reader
        System.out.println("Search() " + " in array : " + m1.search(reader, 10));
    }
}
