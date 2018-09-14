package template.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import template.demo.redis.HashMapping;
import template.demo.redis.ReidsTemplateUse;
import template.demo.redis.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ReidsTemplateUse reidsTemplateUse;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedis(){
        Assert.assertTrue(reidsTemplateUse.addLink("123", "http://localhost") > 0);
    }

    @Test
    public void testRedisGetList(){
        List<String> list = reidsTemplateUse.getLink("123");
        Assert.assertNotNull(list);
    }

    @Test
    public void testListObj(){
        User user = new User("Leo", "http");
        Assert.assertTrue(reidsTemplateUse.addUser("young", user) > 0);
        Assert.assertTrue(reidsTemplateUse.addUserStr("old", user) > 0);
    }

    @Test
    public void testGetList(){
        System.out.println(reidsTemplateUse.getUser("young").toString());
        System.out.println(reidsTemplateUse.getUserStr("old").toString());
    }

    @Autowired
    HashMapping hashMapping;

    @Test
    public void testHash(){
        User user = new User("Leo", "http");
        hashMapping.setUser(user);
        hashMapping.setUserJson(user);
    }

    @Test
    public void testGetUser(){
        User u1 = hashMapping.getUser();
        User u2 = hashMapping.getUserJson();
    }

}
