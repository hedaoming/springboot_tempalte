package template.demo.redis;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by peishen on 2018/09/13
 **/
@Service
public class ReidsTemplateUse {

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @Resource(name = "stringRedisTemplate")
    private ListOperations<String, String> strListOps;

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listObjOps;

    @Resource(name = "stringRedisTemplate")
    private ListOperations<String, Object> strListObjOps;

    public User getUser(String group){
        return (User) listObjOps.range(group, 0, 1).get(0);
    }

    public User getUserStr(String group){
        return (User) strListObjOps.range(group, 0, 1).get(0);
    }

    public Long addUser(String group, User user){
        return listObjOps.leftPush(group, user);
    }

    public Long addUserStr(String group, User user){
        return strListObjOps.leftPush(group, user.toString());
    }

    public Long addLink(String userId, String url){
//        return listOps.leftPush(userId, url);
        return strListOps.leftPush(userId, url);
    }

    public List<String> getLink(String userId){
        return listOps.range(userId, 0 , -1);
    }



}
