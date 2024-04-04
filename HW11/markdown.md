# HighLevel Approach
- start off with matrix
- check if the target color is the same as what is in the matrix (if so you dont need to continue)
- check if matrix is empty
- crate queue to hold the location of the colors in the matrix
- save the previous color for comparison
# iterative approach
- while the queue is not empty:
- remove location of color value from queue and put into array
- Compare with saved color to see if replacement is possible
- with checks for outofbounds for each of the neighbors (up, down, left right) place all neighbors in queue
- continue until done
  - out of loop return the image
