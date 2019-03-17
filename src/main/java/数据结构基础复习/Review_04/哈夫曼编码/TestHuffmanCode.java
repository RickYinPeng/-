package 数据结构基础复习.Review_04.哈夫曼编码;

import java.util.*;

/**
 * @author RickYinPeng
 * @ClassName TestHuffmanCode
 * @Description
 * @date 2019/2/19/11:55
 */
public class TestHuffmanCode {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a man";
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编码
        byte[] b = huffmanZip(bytes);

        //使用赫夫曼编码进行解码
        byte[] newBytes = descode(b,huffCodes);

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(newBytes));

        System.out.println(new String(newBytes));


    }

    /**
     * 使用制定的赫夫曼编码表进行解码
     * @param bytes             需要解码的byte数组
     * @param huffCodes     制定的赫夫曼编码表
     * @return
     */
    private static byte[] descode(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        //将byte数组转为一个二进制的字符串
        for (int i = 0;i<bytes.length;i++) {
            byte b = bytes[i];
            boolean flag = (i==bytes.length-1);
            sb.append(byteToBitStr(!flag,b));
        }
        //把字符串按照指定的赫夫曼编码进行解码
        Map<String,Byte> map = new HashMap<>();
        for (Byte aByte : huffCodes.keySet()) {
            map.put(huffCodes.get(aByte),aByte);
        }

        //创建一个结合，用于存byte
        List<Byte> list = new ArrayList<>();

        //处理字符串
        for(int i =0 ;i<sb.length();){
            int count = 1;
            boolean flag = true;
            while (flag){
                String key = sb.substring(i,i+count);
                if(!map.containsKey(key)){
                    count++;
                }else {
                    list.add(map.get(key));
                    flag = false;
                }
            }
            i+=count;
        }

        //System.out.println(list);
        //将集合转为数组
        byte[] b = new byte[list.size()];
        for(int i = 0;i<b.length;i++){
            b[i] = list.get(i);
        }
        return b;
    }

    public static String byteToBitStr(boolean flag,byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }

    /**
     * 赫夫曼编码压缩的方法
     * @param bytes 需要压缩的字节数组
     * @return      返回压缩后的字节数组
     */
    private static byte[] huffmanZip(byte[] bytes) {

        //先统计每一个byte出现的次数，并放入集合中
        List<Node> nodes = getNodes(bytes);

        //创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodes);

        //创建一个赫夫曼编码表
        Map<Byte,String> huffCodes = getCodes(tree);

        //编码
        byte[] b = zip(bytes,huffCodes);

        return b;
    }

    /**
     * 进行赫夫曼编码
     * @param bytes         要编码的byte数组
     * @param huffCodes     赫夫曼编码表
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        //System.out.println(huffCodes);
        StringBuilder sb = new StringBuilder();
        //把需要压缩的byte数组处理成二进制的字符串
        for (byte aByte : bytes) {
            sb.append(huffCodes.get(aByte));
        }
        //定义长度
        int len;
        if(sb.length()%8==0){
            len = sb.length()/8;
        }else {
            len = sb.length()/8+1;
        }
        System.out.println(sb);
        //用于存储压缩后的byte
        byte[] by = new byte[len];

        //记录新的byte的位置
        int index = 0;

        for(int i = 0;i<sb.length();i+=8){
            String substring;
            if(i+8>sb.length()){
                substring= sb.substring(i);
            }else {
                substring= sb.substring(i, i + 8);
            }

            byte num = (byte)Integer.parseInt(substring,2);
            //System.out.println(substring+":"+num);
            by[index] = num;
            index++;
        }

        return by;
    }

    static StringBuilder sb = new StringBuilder();
    static Map<Byte,String> huffCodes = new HashMap<>();

    /**
     * 根据赫夫曼树获取赫夫曼编码
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if(tree==null){
            return null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);

        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        //将上次的StringBuilder传进去
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if(node.data==null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else{
            huffCodes.put(node.data,sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);

            //取出两个权值最低的二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            //创建一棵新的二叉树
            Node parent = new Node(left.weight+right.weight);
            parent.left = left;
            parent.right = right;

            //把取出来的两个二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树即可中
            nodes.add(parent);

        }
        return nodes.get(0);
    }

    /**
     * 将byte数组转为Node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        //存储每一个byte出现了多少次
        Map<Byte,Integer> counts = new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b : bytes) {
            if(!counts.containsKey(b)){
                counts.put(b,1);
            }else {
                counts.put(b,counts.get(b)+1);
            }
        }
        //把每一个键值对转换为一个node对象
        for (Byte aByte : counts.keySet()) {
            nodes.add(new Node(aByte,counts.get(aByte)));
        }
        return nodes;
    }
}
