package javaBasicDemo.dataStructure.twoTree;

/**
 * @author JHMI on 2017/9/4.
 */
public class TwoBtreeMain {
    public static void main(String[] args) {
        /*TwoBTreeTest<Integer> twoBTreeTest = new TwoBTreeTest();
        int[] number = {7,6,11,2,6,9,15};//数组
        for (int num : number){
            twoBTreeTest.add(num);//for each方法向树中添加数据
        }

        twoBTreeTest.iterator(twoBTreeTest);*/

        AVLTreeTest<Integer> twoBTreeTest = new AVLTreeTest();
        int[] number = {3,2,1,2,6,9,15};//数组
        for (int num : number){
            twoBTreeTest.add(num);//for each方法向树中添加数据
        }

        twoBTreeTest.iterator(twoBTreeTest);
    }

}
