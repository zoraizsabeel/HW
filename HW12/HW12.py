from typing import List

def find(parent, i):
    if parent[i] != i:
        parent[i] = find(parent, parent[i])
    return parent[i]

def union(parent, i, j):
    root_i = find(parent, i)
    root_j = find(parent, j)
    if root_i != root_j:
        parent[root_i] = root_j

def merge_sort(edges):
    if len(edges) <= 1:
        return
    mid = len(edges) // 2
    left_half = edges[:mid]
    right_half = edges[mid:]
    merge_sort(left_half)
    merge_sort(right_half)

    i = j = k = 0
    while i < len(left_half) and j < len(right_half):
        if left_half[i][2] <= right_half[j][2]:
            edges[k] = left_half[i]
            i += 1
        else:
            edges[k] = right_half[j]
            j += 1
        k += 1

    while i < len(left_half):
        edges[k] = left_half[i]
        i += 1
        k += 1

    while j < len(right_half):
        edges[k] = right_half[j]
        j += 1
        k += 1

def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
    edges = []
    for pipe in pipes:
        edges.append(pipe)
    for i in range(n):
        edges.append([0, i + 1, wells[i]])

    merge_sort(edges)

    MST = list(range(n + 1))

    count = 0
    cost = 0

    for edge in edges:
        from_, to, for_cost = edge
        if find(MST, from_) != find(MST, to):
            union(MST, from_, to)
            cost += for_cost
            count += 1
            if count == n:
                break

    return cost

# Test cases
wells1 = [1, 1]
pipes1 = [[1, 2, 1], [1, 2, 2]]
print(minCostToSupplyWater(None, 2, wells1, pipes1))  # Should be 2

wells2 = [10, 20, 30]
pipes2 = [[1, 2, 5], [2, 3, 5], [1, 3, 20]]
print(minCostToSupplyWater(None, 3, wells2, pipes2))  # Should be 20

wells3 = [50, 50, 50, 50]
pipes3 = [[1, 2, 10], [2, 3, 10], [3, 4, 10], [1, 3, 30]]
print(minCostToSupplyWater(None, 4, wells3, pipes3))  # Should be 80
