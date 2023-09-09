# baekjoon 알고리즘 14889
# 2023.09.09 이주현


import sys

def dfs(depth, idx):
    global min_capability
    if depth == num_of_players//2: ## 팀원수 == 전체 총 인원 // 2 
        cap1 = 0
        cap2 = 0
        
        for i in range(num_of_players):
            for j in range(num_of_players):
                if visited[i] and visited[j]:
                    cap1 += player_matrix[i][j]
                elif not visited[i] and not visited[j]:
                    cap2 += player_matrix[i][j]
        min_capability = min(min_capability, abs(cap1-cap2))
        return

    for i in range(idx, num_of_players):
        if not visited[i]:
            visited[i] = True
            dfs(depth+1, i+1)
            visited[i] = False

num_of_players = int(sys.stdin.readline())

player_matrix = list()
visited = list()

min_capability = 1000000000

for _ in range(num_of_players):
    player_matrix.append(list(map(int,sys.stdin.readline().split() )))
    visited.append(False)

dfs(0, 0)
print(min_capability)
