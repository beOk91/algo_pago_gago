# baekjoon 알고리즘 1182
# 2023.08.26 이주현

import sys
from itertools import combinations # combination 라이브러리 확인 

def calculate(depth , count, sum):
    
    if depth == count:
        return sum

    calculate()
num , target = map(int , sys.stdin.readline().split())

n_list = list(map(int , sys.stdin.readline().split()))

count = 0
for n in range(1, num + 1): # 범위 잘 설정하기
    subset = combinations(n_list, n)
    
    for s_n in subset:
        if sum(s_n) == target:
            count = count + 1

print(count)