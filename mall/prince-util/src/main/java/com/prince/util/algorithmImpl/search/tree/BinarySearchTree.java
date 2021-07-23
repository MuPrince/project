package com.prince.util.algorithmImpl.search.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Prince
 * @description: 二叉树查找
 * 基本思想：二叉查找树是先对待查找的数据进行生成树，确保树的左分支的值小于右分支的值，然后在就行和每个节点的父节点比较大小，查找最适合的范围。
 * 这个算法的查找效率很高，但是如果使用这种查找方法要首先创建树。
 * <p>
 * 　　          二叉查找树（BinarySearch Tree，也叫二叉搜索树，或称二叉排序树Binary Sort Tree）或者是一棵空树，或者是具有下列性质的二叉树：
 * 　　               1）若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 　　               2）若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 　　               3）任意节点的左、右子树也分别为二叉查找树。
 * 　　          二叉查找树性质：对二叉查找树进行中序遍历，即可得到有序的数列。
 * 复杂度分析: 它和二分查找一样，插入和查找的时间复杂度均为O(logn)，但是在最坏的情况下仍然会有O(n)的时间复杂度。
 * 原因在于插入和删除元素的时候，树没有保持平衡。我们追求的是在最坏的情况下仍然有较好的时间复杂度，这就是平衡查找树设计的初衷。
 * @time 2020/9/25 14:03
 */
public class BinarySearchTree {

    /**
     * @description : 递归遍历树
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Prince
     * @date 2020/9/28 13:32
     */
    public List<Integer> OrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = OrderTraversal(root.left);
        List<Integer> right = OrderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }

    /**
     * @description : 前序遍历树 自己->左子节点->右子节点
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Prince
     * @date 2020/9/28 13:51
     */
    public List<Integer> PreorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * @description : 中序遍历 左子节点->自己->右子节点
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Prince
     * @date 2020/9/28 13:53
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
    
    /**
     * @description : 后序遍历 左子节点->右子节点->自己
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Prince
     * @date 2020/9/28 13:57
     */
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right == null && node.left == null) {
                result.add(stack.pop().val);
            }
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode current = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (prev == null || prev.left == current || prev.right == current){
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                result.add(current.val);
                stack.pop();
            }
            prev = current;
        }
        return result;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
