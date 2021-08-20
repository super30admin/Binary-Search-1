// Time Complexity :log (n)+log(r)
// Space Complexity :O(n*r)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
interface ArrayReader{
    public int get(int index);
}
public class search2 {
   

public int search(ArrayReader reader, int target){
    
        int low=0; int high=1;
        //if element is not inside the given range then use two pointers and make high jump indexes with respect to 2
        while(reader.get(high)<target){
            low=high;
            high=2*high;
        }
        //range where element might be residing
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target) return mid;
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
