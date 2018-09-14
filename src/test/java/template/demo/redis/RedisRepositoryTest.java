package template.demo.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import template.demo.BaseTest;

/**
 * Created by peishen on 2018/09/13
 **/
public class RedisRepositoryTest extends BaseTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testUser(){
        User user = new User("Leo", "url");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }
}
