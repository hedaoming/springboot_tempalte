package template.demo.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peishen on 2018/10/16
 **/
public class CollectMethod {
    static List<Person> personList = new ArrayList();
    static{
        personList.add(new Person("Leo",14));
        personList.add(new Person("Amy", 22));
        personList.add(new Person("Mike", 34));
    }


    public void getMinMax(){
        personList.stream().distinct();
    }
}

