package com.matrix;

public class Flood_Fill {

	public static void main(String[] args) {

		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int color = 2;
		int[][] result = floodFill(image, sr, sc, color);
		printMatrix(result);
		System.out.println(result);

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int posColor = image[sr][sc];
		traverse(image, posColor, color, sr, sc);
		return image;
	}

	private static void traverse(int[][] image, int posColor, int color, int row, int col) {
		if (row < 0 || row > image.length - 1 || col < 0 || col > image[row].length - 1
				|| image[row][col] != posColor) {
			return;
		}
		if (image[row][col] == posColor) {
			image[row][col] = color;
		}
		traverse(image, posColor, color, row + 1, col);
		traverse(image, posColor, color, row, col + 1);
		traverse(image, posColor, color, row - 1, col);
		traverse(image, posColor, color, row, col - 1);
	}

	private static void printMatrix(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}

}
