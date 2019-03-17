package 数据结构基础复习.Review_05.图;

/**
 * 顶点类
 */
public class Vertex {
    private String value;

    /**
     * 访问标志位：默认false
     */
    public boolean visited;

    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value='" + value + '\'' +
                '}';
    }
}
