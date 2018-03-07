<%@ include file="/commons/taglibs.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: yqwoe
  Date: 2018/3/7
  Time: 下午2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><s:property value="title"/></h1>
<hr/>
<table class="am-table am-table-bd am-table-striped admin-content-table">
    <thead>
    <tr>
        <th>任务ID</th><th>任务名称</th><th>流程实例ID</th><th>流程创建时间</th><th>操作</th>
    </tr>
    </thead>
    <tbody>
    <script>
        function onOk(form_id){
            var myform=$('#'+form_id); //得到form对象
            var tmpInput=$("<input type='text' name='approved'/>");
            tmpInput.attr("value", true);
            myform.append(tmpInput);
            myform.submit();
        }
        function onCancel(form_id){

            var myform=$('#'+form_id); //得到form对象
            var tmpInput=$("<input type='text' name='approved'/>");
            tmpInput.attr("value", false);
            myform.append(tmpInput);
            myform.submit();
        }
    </script>
    <s:iterator value="tasks" var="task">

        <tr>
            <td><s:property value="#task.id" /></td><td><s:property value="#task.name" /></td>
            <td><s:property value="#task.processInstanceId" /></td>
            <td><s:property value="#task.createTime" /></td>
            <td>
                <form action="deptAudit" method="post" id="form_<s:property value="#task.id" />">
                    <input type="hidden" name="taskId" value="<s:property value="#task.id" />"/>
                    <button onclick="onOk('form_<s:property value="#task.id" />')" class="am-btn am-btn-default am-btn-xs" >同意</button>
                    <button onclick="onCancel('form_<s:property value="#task.id" />')" class="am-btn am-btn-danger am-btn-xs">拒绝</button>
                </form>
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>
