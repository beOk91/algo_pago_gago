# baekjoon 알고리즘 1016
# 2023.09.23 이주현

import sys
import math

min_num , max_num = map(int, sys.stdin.readline().split())

a = [i**2 for i in range(2,int(max_num**0.5)+1)] # 제곱수 파악

num = [1] * (max_num-min_num+1)

for i in a:
    n = min_num//i*i # 제곱수로 나눠지는 숫자 찾기
    while(n < max_num+1):
        if n - min_num >= 0:
            num[n-min_num] = 0
        n += i
print(sum(num))
