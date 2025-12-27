//Here we are increasing our search space by 2 in an array every time in a loop to find a range  for a target
//If a target is found in a range then we are implementing binary search on that range to find index of that target
//If a target is not found in that range then we return -1


public class Problem3 {

    public int search (ArrayReader reader, int target) {
        
        int low=0;
        int high=1;

        while(reader.get[high]<target){
            low=high;
            high=2*high;
        }
        while(low<=high){
            int mid= low + (high-low)/2;
            if(reader.get[mid]==target){
                return mid;
            }
            else if(reader.get[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;

    }
    
}
