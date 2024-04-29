def remove_digits_lower(holder):
    temp = ""
    for char in holder:
        if not char.isdigit():
            temp += char
    return temp

def palindrome(holder): # assume remove_digits_lower is called on parameter
    last = len(holder)
    for i in range(len(holder)):
        if holder[i] == holder[last - 1 - i]:
            return True
        else:
            return False
    return False

def main():
    statement = input("Enter the string please: ")
    statement = remove_digits_lower(statement)
    pal = palindrome(statement)
    print("This statement is a palindrome:", pal)

if __name__ == "__main__":
    main()
