package HKU2021.March;

/**
 * 307. Range Sum Query - Mutable
 * 线段树
 */
public class RangeSumQueryMutable307 {

    private int[] tree;
    int n;

    public RangeSumQueryMutable307(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    /**
     * 如果索引 i 处的元素不是一个叶节点，
     * 那么其左子节点和右子节点分别存储在索引为 2i 和 2i+1 处
     *
     * @param nums Original array
     */
    private void buildTree(int[] nums) {
        // build origin
        for (int i = n, j = 0; i < 2 * n; i++, j++) {
            tree[i] = nums[j];
        }

        //build sum
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int index, int val) {
        index += n;
        tree[index] = val;
        while (index > 0) {
            int left = index;
            int right = index;

            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }

            tree[index / 2] = tree[left] + tree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left += n;
        right += n;

        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSumQueryMutable307 rs = new RangeSumQueryMutable307(new int[]{-28, -39, 53, 65, 11, -56, -65, -39, -43, 97});
        System.out.println(rs.sumRange(5, 6));
        rs.update(9, 27);
//        System.out.println();
        System.out.println(rs.sumRange(2, 3));
        System.out.println(rs.sumRange(6, 7));
//        rs.update(1,-82);
//        rs.update(3,-72);
    }
}
