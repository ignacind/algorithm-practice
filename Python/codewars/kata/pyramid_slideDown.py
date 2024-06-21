def sumSlideDown(pyramid):
    pyramidSum = []
    for i, r in enumerate(pyramid):
        pyramidSum.append([])
        for n in r:
            if i == len(pyramid) - 1:
                pyramidSum[i].append(n)
            else:
                pyramidSum[i].append(0) 
    
    for i in range(len(pyramidSum)-2, -1, -1):
        for j in range(len(pyramidSum[i])):
            pyramidSum[i][j] = pyramid[i][j] + max(pyramidSum[i+1][j], pyramidSum[i+1][j+1])
    
    return pyramidSum[0][0]

    

                # [23], [20, 19], [10, 13, 15], [8, 5, 9, 3]]
print(sumSlideDown([[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]))