package javaBasicDemo.dataStructure.twoTree;

/**
 * @author JHMI on 2017/9/4.
 * 二叉平衡树
 */
public class AVLTreeTest<E extends Comparable> {
    private static Tree root;

    private static class Tree<E>{
        E item;
        Tree left;
        Tree Right;

        int high;//定义树的高度，记录每个节点的深度---------------avl树

        public Tree(E item, Tree left, Tree right) {
            this.item = item;
            this.left = left;
            Right = right;
            high = 0;
        }
    }

    public void add(E e){
        if(root == null){
            root = new Tree(e,null,null);
            root.high = Math.max(height(root.left),height(root.Right)) + 1;
            return;
        }
        addTree(root,e);

    }

    private void addTree(Tree<E> parent,E e){
        //当前节点和根节点比较
        if(e.compareTo(parent.item) < 0){
            //和左节点比较
            if(parent.left == null){
                Tree<E> node = new Tree(e,null,null);
                parent.left = node;
                //计算叶子节点的高度
                node.high = 1;
                parent.high = Math.max(height(parent.left),height(parent.Right)) + 1;
                return;
            }

            addTree(parent.left,e);
            //计算每个父节点的高度
            parent.high = Math.max(height(parent.left),height(parent.Right)) + 1;
            //进行左右子树高度比较
            //进行旋转判断
            if(height(parent.left) - height(parent.Right) > 1){
                root = leftLeftRotation(parent);
            }
        }else{
            if(parent.Right == null){
                Tree node = new Tree(e,null,null);
                node.high = 1;
                parent.Right = node;
                parent.high = Math.max(height(parent.left),height(parent.Right)) + 1;
                return;
            }
            addTree(parent.Right,e);
            parent.high = Math.max(height(parent.left),height(parent.Right)) + 1;
        }
    }

    //DFS遍历二叉树
    private void dfs(Tree nodeBegin) {
        Tree node = nodeBegin;//从头开始遍历
        //如果遍历到null了，证明这一支已经遍历完毕，直接返回
        if (node == null) {
            return;
        }
        dfs(node.left);//遍历左支
        dfs(node.Right);//遍历右支
        System.out.println(node.item);//在遍历完左右支后再打印这个节点
        return;
    }
    private int height(Tree<E> node){
        if(node != null)
            return node.high;
        return 0;
    }

    public void iterator(AVLTreeTest<E> test){
        test.dfs(test.root);
    }

    /*
 * LL：左左对应的情况(左单旋转)。
 *
 * 返回值：旋转后的根节点
 */
    private Tree<E> leftLeftRotation(Tree<E> k2) {
        Tree<E> k1;

        k1 = k2.left;
        k2.left = k1.Right;
        k1.Right = k2;

        k2.high = Math.max( height(k2.left), height(k2.Right)) + 1;
        k1.high = Math.max( height(k1.left), k2.high) + 1;

        return k1;
    }
}
