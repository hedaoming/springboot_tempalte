package template.demo.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by peishen on 2018/09/13
 **/
@Service
public interface UserRepository extends CrudRepository<User, String> {
}
