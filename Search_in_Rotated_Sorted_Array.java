class Solution {
    public int bin(int[] a,int l,int h,int t){
        if(l>h)return -1;
        int mid = l+((h-l)/2);
        if(a[mid]==t)return mid;
        if(a[l]<=a[mid]){
            if(a[l]<=t && a[mid]>t)return bin(a,l,mid-1,t);
            return bin(a,mid+1,h,t);
        }
            
        else{
            if(a[mid]<=t && a[h]>=t)return bin(a,mid+1,h,t);
            return bin(a,l,mid-1,t);
        }
    }
    public int search(int[] nums, int target) {
        return bin(nums,0,nums.length-1,target);
    }
}
