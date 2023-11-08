# // Time Complexity :O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we store the mapping of user to followers in a hashmap. since we need the search to be O(1) -instead of keeping a list of followers we keep hashset of followers
# we keep the tweets and its and the time in another hashmap - ordered in the order of time. to follow is O(1)- we just add to the users hashmap
# to unfollow we just remove form the hashmap if it exists. to post we add the tweet object and time .
# to get the post feeds-we use minheap to get 10 most recent from the followers of the user. 
import heapq
class Twitter(object):
    

    def __init__(self):
        self.count=0
        self.tweetmap=defaultdict(list)
        self.usrmap=defaultdict(set)
    def postTweet(self, userId, tweetId):
        """
        :type userId: int
        :type tweetId: int
        :rtype: None
        """
        # if userId not in usrmap:
        #     
        self.tweetmap[userId].append([self.count, tweetId])
        self.count-=1
        
        

    def getNewsFeed(self, userId):
        """
        :type userId: int
        :rtype: List[int]
        """
        res=[]
        minheap=[]
        self.usrmap[userId].add(userId)
        for followeeId in self.usrmap[userId]:
            if followeeId in self.tweetmap:
                ind=len(self.tweetmap[followeeId]) - 1
                count,tweetId=self.tweetmap[followeeId][ind]
                minheap.append([count,tweetId, followeeId, ind-1])
        heapq.heapify(minheap)
        while minheap and len(res)<10:
            count,tweetId, followeeId, ind = heapq.heappop(minheap)
            res.append(tweetId)
            if ind>=0:
                count, tweetId = self.tweetmap[followeeId][ind]
                heapq.heappush(minheap, [count, tweetId, followeeId, ind-1])
        

        return res
        
    def follow(self, followerId, followeeId):
        """
        :type followerId: int
        :type followeeId: int
        :rtype: None
        """
        self.usrmap[followerId].add(followeeId)
        

    def unfollow(self, followerId, followeeId):
        """
        :type followerId: int
        :type followeeId: int
        :rtype: None
        """
        if followeeId in self.usrmap[followerId]:
            self.usrmap[followerId].remove(followeeId)
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)