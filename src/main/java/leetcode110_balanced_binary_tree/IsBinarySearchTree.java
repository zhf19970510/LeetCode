package leetcode110_balanced_binary_tree;

public class IsBinarySearchTree {
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(TreeNode x) {
        if(x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int max = x.val;
        int min = x.val;
        if(leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if(rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = true;
        if(leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if(rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        boolean leftMaxLessX = leftInfo == null || leftInfo.max < x.val;
        boolean rightMinMoreX = rightInfo == null || rightInfo.min > x.val;

        if(!leftMaxLessX || !rightMinMoreX) {
            isBST = false;
        }

        return new Info(isBST, max, min);
    }


}
