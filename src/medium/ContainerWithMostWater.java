package medium;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max_area = 0;
        int max_start = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] <= max_start) {
                continue;
            }
            max_start = height[i];
            for (int j = i; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > max_area) {
                    max_area = area;
                }
            }
        }
        return max_area;

    }
    //官方答案
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 4, 2, 11, 0, 11, 5, 11, 13, 8};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.print(containerWithMostWater.maxArea(height));
    }
}
