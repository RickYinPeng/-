package 数据结构拔高.循环队列;

/**
 * @author RickYinPeng
 * @ClassName CircularQueue
 * @Description
 * @date 2019/3/13/0:00
 */
public class CircularQueue {
    //数组：items，循环队列保存元素的地方
    private String[] items;
    //数组大小，总的循环队列的大小
    private int n = 0;

    //队头下标
    private int head = 0;

    //队尾下标
    private int tail = 0;

    //初始化，申请一个大小为capacity的循环队列（数组）
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        //队列满了
        if((tail+1)%n==head){
            return false;
        }
        items[tail] = item;
        tail = (tail+1)%n;
        return true;
    }

    //出队
    public String dequeue(){
        //如果head==tail表示队列为空
        if(head==tail){
            return null;
        }
        String ret = items[head];
        head = (head+1)%n;
        return ret;
    }
}
