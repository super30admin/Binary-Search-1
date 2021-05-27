class BinarySearchInArrayOfUnknownSize {
    public int binarySearch(int[] a, int t, int l, int h) {
        int m;
        boolean ret = false;
        while(l <= r) {
            m = l + (r - l) / 2;
            if(a[m] == t) {
                ret = true;
                break;
            } else if (a[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ret;
    }
    public search(int[] a, int t) {
        int l, r, val;
        l = 0;
        r = l+1;
        val = a[0];

        while(val < t) {
            l = h;
            if(2*h < a.length) { // heuristic to increase the search space
                h = 2*h;
            } else {
                h = a.length - 1;
            }
            val = a[h];
        }

        return binarySearch(a, t, l, h);
    }
}