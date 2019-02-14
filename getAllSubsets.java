package Adobe.maxAreaInMartrix;
import java.util.*;

public class getAllSubsets {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4};
        List<List<Integer>> res = subsets(n);
        for (List<Integer> l : res) {
            for (int k : l) {
                System.out.print(k);
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << n); i++) {
            String k = Integer.toString(i, 2);
            int length = k.length() - 1;
            int length1 = nums.length - 1;
            List<Integer> list = new ArrayList<Integer>();
            while (length1 >= 0 && length >= 0) {
                if (k.charAt(length) == '1') {
                    list.add(nums[length1]);
                }
                length--;
                length1--;
            }
            res.add(list);
        }
        return res;
    }
}
