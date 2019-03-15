package com.ypy.arithmetic.tree;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:    树
* @Author:         ypy
* @Date:           2019/3/15 15:42
*/
public class Tree {

    /**
     * 节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 方法描述：    根据前序遍历和中序遍历重构二叉树
     * @auther:    ypy
     * @data:      2019/3/15 15:42
     * @param:
     * @return:
     **/
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0 || in.length==0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int flag = -1;
        //查找中序遍历中根节点的位置
        //左边为该根节点的左子树，右边为右子树
        for (int i=0; i<in.length; i++) {
            if (in[i] == pre[0]) {
                flag = i;
                break;
            }
        }
        //在先序遍历中查找子树的根节点
        List<Integer> leftTreeInList = new ArrayList(in.length);
        List<Integer> rightTreeInList = new ArrayList(in.length);
        for (int i=0; i<in.length; i++) {
            if (i < flag) {
                leftTreeInList.add(in[i]);
            } else if (i > flag) {
                rightTreeInList.add(in[i]);
            }
        }
        //左子树根节点
        for (int i=0; i<pre.length; i++) {
            if (leftTreeInList.contains(pre[i])) {
                int[] leftTreePre = new int[leftTreeInList.size()];
                int[] leftTreeIn = new int[leftTreeInList.size()];
                for (int j=0; j<leftTreeInList.size(); j++) {
                    leftTreePre[j] = pre[i];
                    i++;
                }
                for (int k=0; k<leftTreeInList.size(); k++) {
                    leftTreeIn[k] = leftTreeInList.get(k);
                }
                root.left = reConstructBinaryTree(leftTreePre,leftTreeIn);
                break;
            }
        }
        //右子树根节点
        for (int i=0; i<pre.length; i++) {
            if (rightTreeInList.contains(pre[i])) {
                int[] rightTreePre = new int[rightTreeInList.size()];
                int[] rightTreeIn = new int[rightTreeInList.size()];
                for (int j=0; j<rightTreeInList.size(); j++) {
                    rightTreePre[j] = pre[i];
                    i++;
                }
                for (int k=0; k<rightTreeInList.size(); k++) {
                    rightTreeIn[k] = rightTreeInList.get(k);
                }
                root.right = reConstructBinaryTree(rightTreePre,rightTreeIn);
                break;
            }
        }
        return root;
    }
}
