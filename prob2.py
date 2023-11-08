class SkipIterator:
  def __init__(self, stream):
    self.stream = stream
    self.hashmap = {}
    self.itr = -1

  def hasNext(self):
    return self.itr < len(self.stream) - 1

  def next(self):
    if self.itr < len(self.stream) - 1:
   # or if self.hasNext():
      if self.stream[self.itr + 1] not in self.hashmap.keys() or self.hashmap[self.stream[self.itr + 1]] == 0:
        self.itr += 1
        return self.stream[self.itr]
      else:
        val = self.stream[self.itr + 1]
        self.hashmap[val] -= 1
        self.itr += 1
        # checking again for the next valid number in the input stream
        return self.next()
        
  def skip(self, val):
    if val in self.hashmap.keys():
      self.hashmap[val] += 1
    else:
      self.hashmap[val] = 1


it = SkipIterator([5, 6, 7, 5, 6, 8, 9, 5, 5, 6, 8])
print(it.hasNext())  # returns true
it.skip(5)
print(it.next())  #returns 6
it.skip(5)
print(it.next())  # returns 7
print(it.next())  # returns 6
it.skip(8)  # skips 8
it.skip(9)  # skips 9
print(it.next())  # returns 5
print(it.next())  # returns 5
print(it.next())  # returns 6
print(it.hasNext())  #returns true
print(it.next())  #returns 8
print(it.hasNext())  # returns False
