package com.example.db.seeds;

import com.example.action.UserAction;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.activiti.engine.*;

public class Deploy {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ProcessEngineFactoryBean factoryBean = context.getBean(ProcessEngineFactoryBean.class);
        // 存储服务
        RepositoryService rs = context.getBean(RepositoryService.class);
        Deployment dep = rs.createDeployment().addClasspathResource("leave.bpmn").deploy();
        ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
        rs.addCandidateStarterGroup(pd.getId(), "user");

        UserAction user = context.getBean(UserAction.class);
    }
}
