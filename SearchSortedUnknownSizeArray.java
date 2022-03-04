// Time Complexity : O(logn) n is size of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class SearchSortedUnknownSizeArray {
    public int search(ArrayReader reader, int target) {

        //we basically need to find where to put h and then use binary search
        int l=0, h=1;

        while(l<=h)
        {
            //if target is greater than value of h index
            if(target>reader.get(h))
            {
                l=h; //put l in place of h
                h=2*h; //double h

                //we get new range
            }
            else //target is within current range of l and h, use binary search
            {
                int m = l + (h-l)/2;

                if(reader.get(m) == target)
                    return m;
                else if(reader.get(m) > target)
                    h=m-1;
                else
                    l=m+1;
            }
        }
        return -1;
    }
}
