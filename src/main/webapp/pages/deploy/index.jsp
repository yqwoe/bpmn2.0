<%--
  Created by IntelliJ IDEA.
  User: yqwoe
  Date: 2018/3/8
  Time: 上午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>流程部署</h1>
<hr/>

<form action="deploy" class="am-form am-form-inline" method="post" enctype="multipart/form-data">
    <div class="am-tab-panel am-fade am-in am-active" id="tab1">
        <div class="am-g am-margin-top">
            <div class="am-u-sm-8 am-u-md-4">
                <input type="file" class="am-input-sm" name="file">
                <div class="am-hide-sm-only am-u-md-6">*支持文件格式*.bpmn/png/zip</div>
            </div>
        </div>
    </div>
    <div class="am-margin">
        <button type="submit" class="am-btn am-btn-primary am-btn-xs">部署</button>
    </div>
</form>
<br/>
<br/>
<br/>
<br/>
<br/>

<s:iterator value="pids" var="pid">

    <h1><s:property value="#pid" /></h1>

    <img src="read-image?pid=<s:property value="#pid" />"/>
    <br/>
</s:iterator>
</body>
</html>
