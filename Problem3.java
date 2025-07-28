
// Did this code successfully run on Leetcode :No since i dont have subscription
// Time Complexity : O(log n)
// Space Complexity : O(1)  
public class Problem3{
    public int search(ArrayReader reader, int target){
        int l=0,h=1;
        if(reader.get(h)<target){
            l=h;
            h=h*2;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            int val=reader.get(mid);
            if(val==target) 
                return mid;
            else if(val<target) 
                l=mid+1;
            else 
                h=mid-1;
        }
        return -1;
    }
}