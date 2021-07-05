class Solution(object):
    def isomorphicStrings(self, s, t):
        """
        create a hashmap to store isomorphic values of characters
        check len of s and len of t and len of set of s and len of set of t
        iterate through all the characters and store their corresponding value in the hashmap if it does not exist
        while iterating, if we find that key again, verify the value in hashmap is equal to the current value of t
        """

        if len(s) != len(t):
            return False

        if len(set(s)) != len(set(t)):
            return False    
        
        lookup = {}
        for i in range(len(s)):
            if s[i] not in lookup:
                lookup[s[i]] = t[i]
                print(lookup)
            else:
                if lookup[s[i]] != t[i]:
                    return False
        return True

obj = Solution()
# s, t = 'egg', 'add' 
# print(obj.isomorphicStrings(s,t))
s, t = 'foo', 'bar' 
print(obj.isomorphicStrings(s,t))
# s, t = 'paper', 'title' 
# print(obj.isomorphicStrings(s,t))