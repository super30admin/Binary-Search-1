# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """

        dic=[]
        count =0
        if (len(s)==1):
            return 1
        for i in s:
            if i not in dic:
                dic.append(i)
            else:
                dic.remove(i)
                count+=2
        if (len(dic) !=0):
            count += 1
        
        return count
