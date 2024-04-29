def main():
    holder = [2, 4, 3, 7, 9, 10]
    print(find_first(holder))

def find_first(holder):
    left = 0
    right = len(holder) - 1
    while left < right:
        m = (right - left + left) // 2
        if is_bad_version(holder[m]):
            right = m
        else:
            left = m + 1
    return holder[left]

def is_bad_version(version):
    return version % 2 == 1

if __name__ == "__main__":
    main()
