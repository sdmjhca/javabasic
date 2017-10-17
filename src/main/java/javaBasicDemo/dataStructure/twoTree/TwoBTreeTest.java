package javaBasicDemo.dataStructure.twoTree;

/**
 * @author JHMI on 2017/9/4.
 */
public class TwoBTreeTest<E extends Comparable> {
    private static Tree root;
    private static class Tree<E>{
        E item;
        Tree left;
        Tree Right;

        public Tree(E item, Tree left, Tree right) {
            this.item = item;
            this.left = left;
            Right = right;
        }
    }

    public void add(E e){
        if(root == null){
            root = new Tree(e,null,null);
            return;
        }
        addTree(root,e);

    }

    private void addTree(Tree<E> parent,E e){

        //当前节点和根节点比较
        if(e.compareTo(parent.item) < 0){
            //和左节点比较
            if(parent.left == null){
                parent.left = new Tree(e,null,null);
                return;
            }
            addTree(parent.left,e);
        }else{
            if(parent.Right == null){
                parent.Right = new Tree(e,null,null);
                return;
            }
            addTree(parent.Right,e);
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

    public void iterator(TwoBTreeTest<E> test){
        test.dfs(test.root);
    }

}
