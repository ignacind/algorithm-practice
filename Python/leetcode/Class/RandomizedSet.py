import random
class RandomizedSet:

    def __init__(self):
        self.numMap = dict()
        self.numList = list()

    def insert(self, val):
        if val not in self.numMap:
            self.numMap[val] = len(self.numList)
            self.numList.append(val)
            return True
        else:
            return False

    def remove(self, val):
        if val in self.numMap:
            i = self.numMap[val]
            n = self.numList[-1]
            self.numList[i] = n
            self.numMap[n] = i
            self.numList.pop()
            del self.numMap[val]
            return True
        else:
            return False

    def getRandom(self):
        if self.numMap:
            return self.numList[random.randint(0, len(self.numList)-1)]