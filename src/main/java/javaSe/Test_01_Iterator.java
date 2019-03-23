package javaSe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author RickYinPeng
 * @ClassName Test_01_Iterator
 * @Description
 * @date 2019/3/22/12:50
 */
public class Test_01_Iterator {
    public static void main(String[] args) {
        ArrayList arrayList  = new ArrayList();
        //arrayList.iterator();
        //arrayList.listIterator();
        //arrayList.listIterator(3);


        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
