# baekjoon 알고리즘 1260
# 2023.10.15 이주현
import sys

n, m, v = map(int,sys.stdin.readline().split() )
# n : 정점의 개수, m : 간선의 개수 , v : 탐색 시작 번호 

graph = [[0] * (n) for _ in range(n)]

visited_dfs = [0 for i in range(n)]
visited_bfs = [0 for i in range(n)]

for _ in range(m):
    num1 , num2 = map(int,sys.stdin.readline().split() )
    graph[num1-1][num2-1] = 1
    graph[num2-1][num1-1] = 1

def dfs(num):
    visited_dfs[num-1] = 1
    print(num, end=' ')
    for i in range(1, n + 1):
        if (graph[num-1][i-1] == 1 and visited_dfs[i-1] == 0):
            dfs(i)

def bfs(num):
    queue = [num]
    visited_bfs[num-1] = 1
    while queue:
        num = queue.pop(0)
        print(num , end = ' ')
        for i in range(1 , n + 1):
            if (graph[num-1][i-1] == 1 and visited_bfs[i-1] == 0):
                queue.append(i)
                visited_bfs[i-1] = 1
dfs(v)
print()
bfs(v)