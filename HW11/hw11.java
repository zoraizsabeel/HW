// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
// Return the modified image after performing the flood fill.

import java.util.*;

public class hw11 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> holder = new LinkedList<>();

        if (color == image[sr][sc] || image.length < 1 || image[0].length < 1) {
            return image;
        }
        ;

        int colorHolder = image[sr][sc];
        holder.add(new int[] { sr, sc });

        while (!holder.isEmpty()) {
            int[] y = holder.remove();
            if (image[y[0]][y[1]] == colorHolder) {
                image[y[0]][y[1]] = color;

                if (y[0] + 1 < image.length) {
                    holder.add(new int[] { y[0] + 1, y[1] }); // down
                }
                if (y[0] >= 1) {
                    holder.add(new int[] { y[0] - 1, y[1] }); // up
                }
                if (y[1] + 1 < image[0].length) {
                    holder.add(new int[] { y[0], y[1] + 1 }); // right
                }
                if (y[1] >= 1) {
                    holder.add(new int[] { y[0], y[1] - 1 }); // left
                }
            }

        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image1 = { { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 } };
        image1 = floodFill(image1, 1, 1, 2);
        for (int[] thing : image1) {
            System.out.println(thing[0] + " " + thing[1] + " " + thing[2]);
        }

        int[][] image2 = { { 0, 0, 0 },
                { 0, 0, 0 } };
        floodFill(image2, 0, 0, 0);
    }
}
