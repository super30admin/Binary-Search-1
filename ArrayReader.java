// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not sure(No subscription)
// Any problem you faced while coding this :

public class ArrayReader {
    public int search(ArrayReader reader, int target){

        int l = 0; int r = 1;
        while(l<=r){

            int mid = (l + r)/2;
            if(reader.get(mid) == target)
                return mid;

            else if(reader.get(l)<=reader.get(mid)){
                if(target>=reader.get(l) && target<=reader.get(mid)) {
                    r=mid-1;}
                else{
                    l=mid+1;}
            }
            else{


                if(target>=reader.get(mid)&&target<=reader.get(r)){
                    l=mid+1;
                }
                else{
                    r=mid-1;}
            }
        }
        return -1;
    }

}




