<%--
  Created by IntelliJ IDEA.
  User: yqwoe
  Date: 2018/3/6
  Time: 下午9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>OA系统</title>
</head>

<frameset rows="69,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="${ctx}/pages/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frameset rows="*" cols="195,*" framespacing="0" frameborder="no" border="0">
        <frame src="${ctx}/pages/nav.jsp" name="navFrame" scrolling="Yes" noresize="noresize" id="navFrame" title="leftFrame" />
        <frame src="${ctx}/pages/welcome.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
    </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
