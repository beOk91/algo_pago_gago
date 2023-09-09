# baekjoon 알고리즘 15686
# 2023.09.09 이주현

# TODO : BFS로 가능할지 한번 더 보기 // 문제 풀이 다시 보기!! 

import sys
from itertools import combinations

num_of_buildings , max_num_of_chicken = map(int, sys.stdin.readline().split())

min_distance = 1000000000

house_info = list()
chicken_info = list()

for i in range(num_of_buildings):

    row = list(map(int,sys.stdin.readline().split()))

    for j in range(num_of_buildings):
        if row[j] == 1:
            house_info.append((i + 1,j + 1))
        if row[j] == 2:
            chicken_info.append((i + 1,j + 1))

comb_of_chickens = list(combinations(chicken_info, max_num_of_chicken))

for comb in comb_of_chickens:
    dist = 0 
    for house_i , house_j in house_info:
        chick_house_dist = 10000000000
        for chicken_i, chicken_j in comb:
            chick_house_dist = min(chick_house_dist,abs(chicken_i-house_i)+abs(chicken_j-house_j))
        dist += chick_house_dist
    min_distance = min(min_distance, dist)

print(min_distance)
