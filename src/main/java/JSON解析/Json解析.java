package JSON解析;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author RickYinPeng
 * @ClassName JSON解析.Json解析
 * @Description
 * @date 2019/5/6/13:42
 * {
 * "employees":
 * [
 * {
 * "firstName":"John" ,
 * "lastName":"Doe"
 * },
 * {
 * "firstName":"Anna" ,
 * "lastName":"Smith"
 * },
 * {   "firstName":"Peter",
 * "lastName":"Jones"
 * }
 * ]
 * }
 */
public class Json解析 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

/*        JSON解析.employee e1 = new JSON解析.employee("张三", "李四");
        JSON解析.employee e2 = new JSON解析.employee("张三", "李四");
        JSON解析.employee e3 = new JSON解析.employee("张三", "李四");
        JSON解析.employee e4 = new JSON解析.employee("张三", "李四");

        ArrayList arrayList = new ArrayList();
        arrayList.add(e1);
        arrayList.add(e2);
        arrayList.add(e3);
        arrayList.add(e4);

        String json = JSON.toJSONString(arrayList);
        *//*Object json = JSON.toJSON(arrayList);*//*

        System.out.println(s1);
        System.out.println(s2);
        String[] split = json.split("\\}");

        for (String s : split) {
            System.out.println(s);
        }*/

        String jsonStr = "[{'name':'tom','age':20},{'name':'tom','age':20},{'name':'tom','age':20}]";
        ArrayList arrayList = explainJson(jsonStr);
        System.out.println(arrayList);
    }

    public static ArrayList explainJson(String json) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String s1 = json.replaceAll("\\[", "");
        String s2 = s1.replaceAll("\\]", "");
        String[] split = json.split("\\{");

        StringBuilder[] stringBuilders = new StringBuilder[split.length];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        /*int index = 0;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (c == '}' && i != s2.length() - 1) {
                index++;
            }
            stringBuilders[index].append(c);
        }*/
        String[] split1 = s2.split("\\}");
        for(int i = 0;i<split1.length;i++){
            if(i==0){
                split1[i].concat("}");
            }else {
                split1[i] = split1[i].substring(1);
                split1[i].concat("}");
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0;i<stringBuilders.length-1;i++) {
            User user = explain(split1[i]);
            arrayList.add(user);
        }
        return arrayList;
    }

    public static User explain(String jsonStr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //将jsonStr目标字符串进行解析
        Reader reader = new Reader(jsonStr);

        //通过反射获取User的实例方法：
        //这也就是为啥Json解析时，所有的JavaBean都必须含有一个无参数构造器的原因
        User user = User.class.getConstructor().newInstance();

        //循环解析字符串:
        while (!reader.dataHasEnd()) {

            //获取目标端的String字符串
            //String nextStr = reader.getNextString();

            //通过反射获取User的属性
            Field[] fields = User.class.getDeclaredFields();
            //遍历所有的属性,查找属性名与nextString对应的字段
            //这也就是为啥JavaBean对应的字段与Json中对应的属性名一致了

            for (Field field : fields) {
                String fileName = field.getName();
                String jsonKey = reader.getNextString();
                if (fileName.equals(jsonKey)) {
                    //如果一致，查看这个属性是什么类型的：

                    //如果是Int类型的，那么可以告诉Reader，下一段解析你给我出个int类型的数据就行
                    if (field.getType() == Integer.class || field.getType() == int.class) {
                        //获取目标数据
                        int value = reader.getNextInt();

                        //通过反射将目标值注入：
                        field.setAccessible(true);
                        field.set(user, value);

                    }

                    //String类型数据
                    else if (field.getType() == String.class) {
                        String value = reader.getNextString();
                        //同理直接注入
                        field.setAccessible(true);
                        field.set(user, value);

                    } else {
                        //....其他类型数据
                    }
                }
            }
        }
        return user;
    }
}

class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class employee {
    String firstName;
    String lastName;

    public employee() {
    }

    public employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "JSON解析.employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

