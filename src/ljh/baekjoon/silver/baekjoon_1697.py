# baekjoon 알고리즘 1697
# 2023.10.15 이주현
import sys
from collections import deque

def bfs(v):
    q = deque([v]) 
    while q:
        v = q.popleft()
        if v == k: # 동생과 동일한 위치 일때 
            return visited[v]
        for i in (v-1, v+1, 2*v): # 이동 - -1, +1, *2
            if 0 <= i <= 100000 and not visited[i]: # 이동 범위 내 그리고 방문하지 않은 곳
                visited[i] = visited[v] + 1
                q.append(i)

n, k = map(int, sys.stdin.readline().split())
visited = [0 for i in range(100001)]
print(bfs(n))
