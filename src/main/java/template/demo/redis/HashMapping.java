package template.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by peishen on 2018/09/13
 **/
@Service
public class HashMapping {

    @Resource(name = "redisTemplate")
    private HashOperations<String, byte[], byte[]> hashOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> jsonHashOps;

    HashMapper<Object, byte[], byte[]> objectHashMapper = new ObjectHashMapper();

    HashMapper<Object, String, Object> jsonHashMapper = new Jackson2HashMapper(false);

    public void setUser(User user){
        hashOperations.putAll("user:objHash", objectHashMapper.toHash(user));
    }

    public void setUserJson(User user){
        jsonHashOps.putAll("user:objJson", jsonHashMapper.toHash(user));
    }

    public User getUser(){
        Map<byte[], byte[]> entries = hashOperations.entries("user:objHash");
        return (User) objectHashMapper.fromHash(entries);
    }

    public User getUserJson(){
        Map<String, Object> entries = jsonHashOps.entries("user:objJson");
        return (User) jsonHashMapper.fromHash(entries);
    }
}
