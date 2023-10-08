# baekjoon 알고리즘 1149
# 2023.10.08 이주현

import sys

num = int(sys.stdin.readline())

rgb_bill = list()

for _ in range(num):

    next_line = list(map(int, sys.stdin.readline().strip().split()))
    rgb_bill.append(next_line)

for i in range(1,num):
    
    rgb_bill[i][0] += min(rgb_bill[i-1][1], rgb_bill[i-1][2])
    rgb_bill[i][1] += min(rgb_bill[i-1][0], rgb_bill[i-1][2])
    rgb_bill[i][2] += min(rgb_bill[i-1][0], rgb_bill[i-1][1])

print(min(rgb_bill[-1]))