public class MergeTwoArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }
        int insertIndex = nums1.length - 1;
        int mIndex = m - 1;
        int nIndex = n - 1;
        while (nIndex >= 0) {
            if (mIndex >= 0 && nums2[nIndex] > nums1[mIndex]) {
                nums1[insertIndex] = nums2[nIndex];
                insertIndex--;
                nIndex--;
            } else {
                if (mIndex >= 0) {
                    nums1[insertIndex] = nums1[mIndex];
                    mIndex--;
                    insertIndex--;
                } else {
                    nums1[insertIndex] = nums2[nIndex];
                    nIndex--;
                    insertIndex--;
                }

            }
        }
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
    }

    public void betterMerge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = nums1.length-1;
        while (m>=0 && n>=0) {
            nums1[insertIndex] = nums1[m-1] > nums2[n-1] ? nums1[-1 + m--] : nums2[-1 + n--];
            insertIndex--;
        }

        while (n>=0) {
            nums1[insertIndex] = nums2[n-1];
            n--;
            insertIndex--;
        }
    }
}
