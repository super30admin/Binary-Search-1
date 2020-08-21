// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class RotatedArray{

    public static int search(int key, int[] a){
        int l=0, r=a.length-1;
        while(l<r){
        int mid = l+(r-l)/2;
        if(key==a[mid]) return mid;
        if(a[mid]>a[l]){
            if(key >= a[l] && key < a[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }else{
            if(key <= a[r] && key > a[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }

        }
    }
    return -1;
    }


    public static void main(String[] args){
        int[] a = new int[]{2,3,4,5,6,0,1};

        System.out.println(search(3,a));

    }
}