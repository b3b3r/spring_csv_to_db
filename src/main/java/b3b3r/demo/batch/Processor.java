package b3b3r.demo.batch;

import b3b3r.demo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {
    private  static final Map<String, String> DEPT_NAMES = new HashMap<>();

    public Processor(){
        DEPT_NAMES.put("001", "Finance");
        DEPT_NAMES.put("002", "It");
        DEPT_NAMES.put("003", "Marketing");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        String dep = DEPT_NAMES.get(deptCode);
        user.setDept(dep); // transform code into name
        user.setTime(new Date());//add time
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dep));
        return user;
    }
}
