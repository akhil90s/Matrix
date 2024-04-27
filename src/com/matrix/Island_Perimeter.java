package com.matrix;

public class Island_Perimeter {

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		int result = islandPerimeter(grid);
		System.out.println(result);

	}

	private static int perimeter = 0;

	public static int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					traverse(grid, i, j);
					break;
				}
			}
		}
		return perimeter;
	}

	private static void traverse(int[][] grid, int row, int col) {
		if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[row].length - 1 || grid[row][col] == 0) {
			perimeter++;
			return;
		}
		if (grid[row][col] == -1) {
			return;
		}
		grid[row][col] = -1;
		traverse(grid, row + 1, col);
		traverse(grid, row, col + 1);
		traverse(grid, row - 1, col);
		traverse(grid, row, col + 1);
	}

}
