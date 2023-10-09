# baekjoon 알고리즘 11726
# 2023.10.08 이주현

import sys

num = int(sys.stdin.readline())

tile = [0] * (num + 1)

if num == 1:
    print(1)
elif num == 2:
    print(2)
else:
    tile[1] = 1
    tile[2] = 2
    for i in range(3, num+1):
        tile[i] = (tile[i-1] + tile[i-2]) % 10007

    print(tile[num])
