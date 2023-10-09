# baekjoon 알고리즘 1932
# 2023.10.08 이주현

import sys

num = int(sys.stdin.readline())

# result = [0 for i in range(num)] # 0으로
triangle = list()

for _ in range(num):
    next_line = list(map(int, sys.stdin.readline().strip().split()))
    triangle.append(next_line)

result = 0
for i in range (1, len(triangle)):
    for j in range(len(triangle[i])):
        if j == 0:
            triangle[i][j] += triangle[i-1][j]
        elif j == len(triangle[i])-1:
            triangle[i][j] += triangle[i-1][j-1]
        else:
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])

result = max(triangle[-1])

print(result)