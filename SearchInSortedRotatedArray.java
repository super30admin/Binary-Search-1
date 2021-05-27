class Solution {
    public int binarySearch(int[] a, int t, int l, int r) {
        if(l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if(a[m] == t) {
            return m;
        }
        if(a[l] <= a[m]) { //1st half is sorted
            if(t >= a[l] && t <= a[m]) {
                return binarySearch(a, t, l, m);
            }
            return binarySearch(a, t, m+1, r);
        }
        // else second half is sorted
        if(t >= a[m] && t <= a[r]) {
            return binarySearch(a, t, m, r);
        }
        return binarySearch(a, t, l, m-1);

    }
    public int search(int[] a, int t) {
        int ind = binarySearch(a, t, 0, a.length-1);
        return ind;
    }
}