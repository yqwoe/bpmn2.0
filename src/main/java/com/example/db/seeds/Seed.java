package com.example.db.seeds;
import org.activiti.engine.identity.*;
import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Seed {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ProcessEngineFactoryBean factoryBean = context.getBean(ProcessEngineFactoryBean.class);
        IdentityService is = context.getBean(IdentityService.class);
        // 添加用户组
        Group empGroup = saveGroup(is, "user", "员工");
        Group manageGroup = saveGroup(is, "deptLeader", "经理");
        Group dirGroup = saveGroup(is, "hr", "人事");
        // 添加用户
        User empA = saveUser(is, "yqwoe"); // 员工a
        User empB = saveUser(is, "yqwoe1"); // 员工b
        User managea = saveUser(is, "managea"); // 经理a
        User manageb = saveUser(is, "manageb"); // 经理b
        User dira = saveUser(is, "hr1"); // 总监a
        // 绑定关系
        saveRel(is, empA, empGroup);
        saveRel(is, empB, empGroup);
        saveRel(is, managea, manageGroup);
        saveRel(is, manageb, manageGroup);
        saveRel(is, dira, dirGroup);

    }

    static User saveUser(IdentityService is, String id) {
        User u = is.newUser(id);
        u.setPassword("123456");
        is.saveUser(u);
        return u;
    }

    static Group saveGroup(IdentityService is, String id, String name) {
        Group g = is.newGroup(id);
        g.setName(name);
        is.saveGroup(g);
        return g;
    }

    static void saveRel(IdentityService is, User u, Group g) {
        is.createMembership(u.getId(), g.getId());
    }
}
