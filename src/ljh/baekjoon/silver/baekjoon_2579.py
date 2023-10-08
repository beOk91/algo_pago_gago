# baekjoon 알고리즘 2579
# 2023.09.23 이주현

import sys

num = int(sys.stdin.readline())
stairs = [0]*301
for i in range(num):
    stairs[i]=int(input())

DP = [0]*301
DP[0] = stairs[0] # 첫번째 계단
DP[1] = stairs[0]+stairs[1] # 두번째 계단
DP[2] = max(stairs[0]+stairs[2], stairs[1]+stairs[2]) # 세번째 계단

for i in range(3,num):
    DP[i] = max(DP[i-3] + stairs[i-1] + stairs[i], DP[i-2]+stairs[i])

print(DP[num-1])