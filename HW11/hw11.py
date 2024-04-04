from collections import deque

def floodFill(image, sr, sc, color):
    if color == image[sr][sc] or not image or not image[0]:
        return image
    
    queue = deque([(sr, sc)])
    colorHolder = image[sr][sc]
    
    while queue:
        y, x = queue.popleft()
        if image[y][x] == colorHolder:
            image[y][x] = color
            
            if y + 1 < len(image):
                queue.append((y + 1, x))  # down
            if y >= 1:
                queue.append((y - 1, x))  # up
            if x + 1 < len(image[0]):
                queue.append((y, x + 1))  # right
            if x >= 1:
                queue.append((y, x - 1))  # left
    
    return image

def main():
    image1 = [
        [1, 1, 1],
        [1, 1, 0],
        [1, 0, 1]
    ]
    image1 = floodFill(image1, 1, 1, 2)
    for row in image1:
        print(" ".join(map(str, row)))

    image2 = [
        [0, 0, 0],
        [0, 0, 0]
    ]
    floodFill(image2, 0, 0, 0)

if __name__ == "__main__":
    main()
