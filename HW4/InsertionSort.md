# Best Case : 
    - O(N) when the array is sorted as only the outer for loop needs to iterate throughout the array as the comparisons in the second for loop are basically accounted for.
# Average Case: 
    - O(N^2) as when we look into a partially sorted array, because even when we have a half sorted array we take the largest term in the O(n) equation. Something that would look like this O(n+n(n-1)/2) n^2 is still the largest term with constants taken out, hence the time complexity.
# Worst Case: 
    - due to both the loops, an unsorted array, while undergoing sorting, would go through each index n*n times, n being the amount of indeces there are. this way the time complexity ends up being O(n^2)
