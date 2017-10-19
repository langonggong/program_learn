package leetcode;


import pojo.TreeNode;

/**
 * @author lanxu
 * @url https://www.nowcoder.com/practice/e08819cfdeb34985a8de9c4e6562e724?tpId=46&tqId=29030&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * @email xu.lan@renren-inc.com
 * @create 2017年10月19 23:58
 **/
public class minimum_depth_of_binary_tree {
  public class Solution {
    public int run(TreeNode root) {
      if (root == null) {
        return 0;
      } else if (root.left == null && root.right == null) {
        return 1;
      } else if (root.left == null) {
        return run(root.right) + 1;
      } else if (root.right == null) {
        return run(root.left) + 1;
      } else {
        return Math.min(run(root.left), run(root.right)) + 1;
      }
    }
  }

  public static void main(String[] args) {

  }
}