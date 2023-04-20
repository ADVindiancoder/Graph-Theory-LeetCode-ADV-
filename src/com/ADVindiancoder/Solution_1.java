package com.ADVindiancoder;

public class Solution_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solution.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Base case: no change needed
        if (image[sr][sc] == newColor) {
            return image;
        }
        // Perform DFS search
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int color, int newColor) {
        // Base case: out of bounds or pixel color is not same as starting pixel color
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) {
            return;
        }
        // Mark pixel as new color
        image[i][j] = newColor;
        // Recursive DFS search on neighboring pixels
        dfs(image, i+1, j, color, newColor);
        dfs(image, i-1, j, color, newColor);
        dfs(image, i, j+1, color, newColor);
        dfs(image, i, j-1, color, newColor);
    }
}
