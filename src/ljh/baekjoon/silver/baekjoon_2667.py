# baekjoon 알고리즘 2667
# 2023.10.15 이주현
import sys

num = int(sys.stdin.readline())
graph = list() # = [[0] * (num) for _ in range(num)]

for _ in range(num):
    graph.append(list(map(int, sys.stdin.readline().strip())))

home_count = 0
def dfs(x, y):
    global home_count
    if x < 0 or y < 0 or x >=num or y >=num:
        return False
    if graph[x][y] == 1:
        home_count +=1
        graph[x][y] = 0 
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y )
        dfs(x, y+1)
        return True
    return False

result = list()
for i in range(num):
    for j in range(num):
        if dfs(i , j ) == True:
            result.append(home_count)
            home_count = 0
result.sort()
print(len(result))
for i in result:
    print(i)