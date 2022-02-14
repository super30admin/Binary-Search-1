class Solution {
    public int search(ArrayReader reader, int target) {
        int first=0;
        int last=1;
        while(reader.get(last)<target){
            first=last+1;
            last=2*last;
        }
        
         while(first<=last) {
            int mid=(first+last)/2;
                if(reader.get(mid)==target){
                    return mid;
                }
            else if(reader.get(mid) < target){
                first=mid+1;
            }
            else {
                last=mid-1;}
         } 
        
        return -1;
        }
}
