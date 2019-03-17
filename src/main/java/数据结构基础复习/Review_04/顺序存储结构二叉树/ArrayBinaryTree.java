package 数据结构基础复习.Review_04.顺序存储结构二叉树;

/**
 * @author RickYinPeng
 * @ClassName ArrayBinaryTree
 * @Description 顺序存储结构的二叉树
 * @date 2019/2/17/12:33
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    /**
     * 先序遍历的重载方法,如果想要遍历整个树，那就调用这个方法，
     * 如果遍历树的某个子树就调用下面的这个方法，需要传入遍历的子树的根节点在数组中位置
     */
    public void frontShow(){
        frontShow(0);
    }

    /**
     * 顺序存储结构的二叉树的先序遍历（利用顺讯存储的二叉树的性质，看笔记）
     * @param index
     */
    public void frontShow(int index){
        if(data==null || data.length<0){

        }
        //遍历当前节点的内容
        System.out.println(data[index]);

        //遍历左节点 2*index+1
        if(2*index+1<data.length){
            frontShow(2*index+1);
        }
        //处理右子树 2*index+2
        if(2*index+2<data.length){
            frontShow(2*index+2);
        }
    }

}
