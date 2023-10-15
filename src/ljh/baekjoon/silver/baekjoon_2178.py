# baekjoon 알고리즘 2178
# 2023.10.15 이주현

import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
graph = list()

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().strip())))

dx = [-1, 1, 0, 0] 
dy = [0, 0, -1, 1]

def bfs(x, y):
    
    queue = deque()
    queue.append((x,y))

    while queue:
        x, y = queue.popleft()

        for i in range(4): # 동 서 남 북 , 상하 좌우 위치로 이동해서 파악
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1: # 이동 범위 내에서 이동이 가능한 길을 선택
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
    
    return graph[n-1][m-1]

print(bfs(0,0))