//TC : O(T) where T is the index of the target value
//SC : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Implemented in two approaches
class SearchInInfiniteArray {
    public int search(ArrayReader reader, int target) {


        int left = 0;
        int right=1;

        //increment right boundary by making it twice in each iteration and stopping when element at right index becomes greater than target
        while(target > reader.get(right))
            right*=2;

        //apply binary search to the window [left, right]
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(reader.get(mid) < target)
                left = mid +1;
            else if(reader.get(mid) >target)
                right = mid-1;
            else
                return mid;
        }

        return -1;
    }

    //another approach to solve the same problem.
    public int search_new(ArrayReader reader, int target) {


        int left = 0;
        //Since it is given that the elements are sorted and the elements are unique, if the first element is k,
        // then in the worst case all elements from k till target will be present and hence the maximum index that the target can be present at is target-k;
        int right = target - reader.get(0);

        //perform normal binary search
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(reader.get(mid) < target)
                left = mid +1;
            else if(reader.get(mid) >target)
                right = mid-1;
            else
                return mid;
        }

        return -1;
    }


}