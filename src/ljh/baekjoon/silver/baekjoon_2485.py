# baekjoon 알고리즘 2485
# 2023.09.17 이주현

import sys
from math import gcd

num_of_trees = int(sys.stdin.readline())

trees_dist = []

tree = int(sys.stdin.readline())

for i in range (num_of_trees -1 ):
    next_tree = int(sys.stdin.readline())
    trees_dist.append(next_tree - tree)
    tree = next_tree
    
    
g = trees_dist[0]
for j in range(1, len(trees_dist)):
    g = gcd(g, trees_dist[j])

result = 0
for t in trees_dist:
    result += t // g - 1

print(result)