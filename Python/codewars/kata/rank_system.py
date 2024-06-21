class User:
    
    def __init__(self):
        self.rank = -8
        self.progress = 0
        self.ranks_table = [-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8]
        self.MIN_RANK = -8
        self.MAX_RANK = 8
        self.i = 0
        
    

    def inc_progress(self, activity_rank):
        if activity_rank > self.MAX_RANK or activity_rank < self.MIN_RANK or activity_rank == 0: raise ValueError
    
        diff = self.get_rankIndex(activity_rank) - self.i

        if diff < 1:
            if diff == 0:
                self.progress += 3
            elif diff == -1:
                self.progress += 1
        
        else:
            self.progress += 10 * diff * diff

        if self.rank <= 8:    
            
            if self.progress >= 100:
                self.i += self.progress // 100
                self.progress %= 100
            self.rank = self.ranks_table[self.i]
            
        if self.rank >= 8:
            self.progress = 0
        

    
    def get_rankIndex(self, rank):
        l, r = 0, len(self.ranks_table) - 1

        while l <= r:
            mid = (l+r) // 2

            if self.ranks_table[mid] == rank:
                return mid
            elif self.ranks_table[mid] < rank:
                l = mid + 1
            else:
                r = mid - 1

        return -1
    


        

user = User()


print(user.rank)
print(user.progress)
user.inc_progress(1)
print(user.rank)
print(user.progress)



