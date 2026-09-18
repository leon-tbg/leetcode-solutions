package arrays_hashing.p0307_range_sum_query_mutable;

class NumArray {
    private static class SegmentTreeNode{
        SegmentTreeNode left,right;
        int start,end;
        int sum;

        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class SegmentTree {
        private final SegmentTreeNode root;

        SegmentTree(int[] nums) {
            this.root = new SegmentTreeNode(0, nums.length - 1);
            init(root, nums);
        }

        void update(int index, int val) {
            update(root, index, val);
        }

        int query(int l, int r) {
            return query(root, l, r);
        }

        private void init(SegmentTreeNode node, int[] nums) {
            if (node.start == node.end) {
                node.sum = nums[node.start];
                return;
            }

            int mid = (node.end - node.start) / 2 + node.start;

            node.left = new SegmentTreeNode(node.start, mid);
            node.right = new SegmentTreeNode(mid + 1, node.end);

            init(node.left, nums);
            init(node.right, nums);

            node.sum = node.left.sum + node.right.sum;
        }

        private void update(SegmentTreeNode node, int index, int val) {
            if (node.start == node.end) {
                node.sum = val;
                return;
            }

            int mid = (node.end - node.start) / 2 + node.start;

            if (index <= mid) update(node.left, index, val);
            else update(node.right, index, val);

            node.sum = node.left.sum + node.right.sum;
        }

        private int query(SegmentTreeNode node, int l, int r) {
            if (node.start > r || node.end < l) return 0;

            if (node.start >= l && node.end <= r) {
                return node.sum;
            }

            return query(node.left, l, r) + query(node.right, l, r);
        }
    }

    private final SegmentTree tree;

    // Runtime O(n), Memory: O(n)
    public NumArray(int[] nums) {
        tree = new SegmentTree(nums);
    }

    // Runtime O(log n), Memory: O(log n)
    public void update(int index, int val) {
        tree.update(index, val);
    }

    // Runtime: O(log n), Memory: O(log n)
    public int sumRange(int left, int right) {
        return tree.query(left, right);
    }
}
