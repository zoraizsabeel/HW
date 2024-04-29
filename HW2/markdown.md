# highLevel Approach
    - use binary search to acheive least calls on the api when compared to linear search (which is the other way)
# binary search
    - start off by defining left and right variables
    - set middle by subtracting left from right, adding the left to it, and divide it by 2
    - while the left is still less than right
        - see if the middle is true for the api
        - if so limit our set by setting our right value as mid
        -   this way we can check if there are any true values before the mid value in other iterations of the loop
        - if not then we set the left equal to mid+1
            - this way we do not include any values before mid since they all are fine versions.
    - outside the while loop, we return the leftmost value.
