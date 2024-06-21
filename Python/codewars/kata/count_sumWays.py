def exp_sum(n):
    dp = [0] * (n + 1)  # dp = [1, 0, 0, 0, 0, 0]
    dp[0] = 1

    for i in range(1, n + 1):
        for j in range(i, n + 1):
            dp[j] += dp[j - i]

    print(dp)
    return dp[n]


print(exp_sum(3))

'''
    From wikipedia: https://en.wikipedia.org/wiki/Partition_(number_theory)
    In number theory and combinatorics, a partition of a positive integer n, also called an integer partition, is a way of writing n as a sum of positive integers. Two sums that differ only in the order of their summands are considered the same partition. If order matters, the sum becomes a composition. For example, 4 can be partitioned in five distinct ways:
4
3 + 1
2 + 2
2 + 1 + 1
1 + 1 + 1 + 1
'''
