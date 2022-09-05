
//Technique1 : Multiply the high by 2 and Binary Search.  
//Time Complexity : O(log(m)) + O(log(n))
// Space : Complexity : O(1)
class Solution{
    public int main(ArrayReader reader, int target) {
        int low = 0; 
        int high = 1;
        
        //Multiply the high by 2, and its TC = O(log(m))
        while(reader.get(high) < target){  
                high = high * 2;
        }
        
         
        while(low <= high){ // O(log(n))
                int mid = low + (high-low)/2;
                int midValue = reader.get(mid);
                if(midValue == target)return mid;
                else if(midValue > target) {
                    high = mid-1;
                }  
                else{
                    low = mid+1;
                }
       }
      return -1;
    }
}

