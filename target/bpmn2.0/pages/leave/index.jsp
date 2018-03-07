<%--
  Created by IntelliJ IDEA.
  User: yqwoe
  Date: 2018/3/7
  Time: 上午11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>请假列表</h1>
<hr/>
<table class="am-table am-table-bd am-table-striped admin-content-table">
    <thead>
    <tr>
        <th>任务ID</th><th>任务名称</th><th>流程实例ID</th><th>流程创建时间</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="tasks" var="task">

        <tr>
            <td><s:property value="#task.id" /></td><td><s:property value="#task.name" /></td>
            <td><s:property value="#task.processInstanceId" /></td>
            <td><s:property value="#task.createTime" /></td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>
