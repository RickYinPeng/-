package JSON解析;

/**
 * @author RickYinPeng
 * @ClassName Reader
 * @Description
 * @date 2019/5/6/14:36
 */
public class Reader {

    private String json;

    public Reader() {
    }

    public Reader(String json) {
        this.json = json;
        nextWithNoSpace();
    }

    //去掉空格和一些非必须字符
    public void nextWithNoSpace() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{' || c == '}' || c == '\'') {
                continue;
            }
            stringBuilder.append(c);
        }
        this.json = stringBuilder.toString();
    }

    //获取下一段符合要求的String字符串
    //name:tom , age:20
    public String getNextString() {
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == ':' || c == ',') {
                flag = true;
                break;
            }
            stringBuilder.append(c);
        }
        if (flag) {
            json = this.json.substring(i + 1);
        }else {
            json = "";
        }
        return stringBuilder.toString();
    }

    //获取下一段符合要求的int
    public int getNextInt() {
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == ':' || c == ',') {
                flag = true;
                break;
            }
            stringBuilder.append(c);
        }
        if (flag) {
            json = this.json.substring(i + 1);
        }else {
            json = "";
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    //数据是否解析完成
    public boolean dataHasEnd() {
        if (json.length() > 0) {
            return false;
        }
        return true;
    }

    //当然你还可以添加获取Double,char,byte,short,boolean等类型的数据
}
