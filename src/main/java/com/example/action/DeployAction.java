package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

public class DeployAction  extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(this.getClass());

    RepositoryService repositoryService;

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    File file;
    String fileFileName;
    String fileContentType;

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public File getFile() {
        return file;

    }

    public void setFile(File file) {
        this.file = file;
    }
    InputStream resource;

    public InputStream getResource() {
        return resource;
    }

    public void setResource(InputStream resource) {
        this.resource = resource;
    }

    List<String> pids;
    RuntimeService runtimeService;

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public List<String> getPids() {
        return pids;
    }

    public void setPids(List<String> pids) {
        this.pids = pids;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String execute()throws Exception{
        //1.拿到ServletContext
        ServletContext servletContext = ServletActionContext.getServletContext();
        //2.调用realPath方法，获取根据一个虚拟目录得到的真实目录
        String realPath = servletContext.getRealPath("/WEB-INF/file");
        File fileTmp = new File(realPath);
        if(!fileTmp.exists()) fileTmp.mkdir();

        if(file != null&&file.isFile()){
            //上传文件
            FileUtils.copyFile(file,new File(fileTmp,fileFileName));
            InputStream inputStream = new FileInputStream(file);
            String extension = FilenameUtils.getExtension(fileFileName);
            DeploymentBuilder deployment = repositoryService.createDeployment();
            if("zip".equals(extension) || "bar".equals(extension)){
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                deployment.addZipInputStream(zipInputStream);

            }else{
                deployment.addInputStream(fileFileName,inputStream);
            }
           Deployment deploy = deployment.deploy();
            resource = repositoryService.getResourceAsStream(deploy.getId(),fileFileName);

        }
        pids = new ArrayList<String>();
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().list();
        for(ProcessInstance instance : processInstances){
            pids.add(instance.getId());
        }

        return "success";
    }
}
