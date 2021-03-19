class Solution {
    public int search(ArrayReader reader, int target) {
        if (target > 10000){
            return -1;
        }
        int l =0; int h=1;
        while (reader.get(h) < target){
            l = h;
            h = h*2;
        }
        return BinSearch(l,h,target,reader);
    }
    
    private int BinSearch(int l,int h,int target,ArrayReader reader){
        if (l>h){
            return -1;
        }
        while (l <=h){
            int mid = l + (h-l)/2;
            if (reader.get(mid) == target){
                return mid;
            } else if (reader.get(mid) > target){
                h = mid -1;
            } else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
