package template.demo;

import org.junit.Test;

/**
 * Created by peishen on 2018/09/28
 **/
public class exception {

    public void testException(){
        try{
            int i  = 2;
            throw new Exception();
        }catch (Exception e){
            System.out.println("llll");
        }
        System.out.println("ddfadfs");
    }

    @Test
    public void test(){
        testException();
    }
}
