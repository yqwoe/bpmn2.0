<%--
  Created by IntelliJ IDEA.
  User: yqwoe
  Date: 2018/3/7
  Time: 下午12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>



<h1>请假申请</h1>
<hr/>

<form action="leave" class="am-form am-form-inline" method="post">
 <div class="am-tab-panel am-fade am-in am-active" id="tab1">
            <div class="am-g am-margin-top">
                <div class="am-u-sm-4 am-u-md-2 am-text-right">
                    开始日期
                </div>
                <div class="am-u-sm-8 am-u-md-10">
                        <div class="am-form-group am-form-icon">
                            <i class="am-icon-calendar"></i>
                            <input type="date" class="am-form-field am-input-sm" name="startDate" placeholder="日期">
                        </div>
                </div>
            </div>
     <div class="am-g am-margin-top">
         <div class="am-u-sm-4 am-u-md-2 am-text-right">
             结束日期
         </div>
         <div class="am-u-sm-8 am-u-md-10">
                 <div class="am-form-group am-form-icon">
                     <i class="am-icon-calendar"></i>
                     <input type="date" class="am-form-field am-input-sm" name="endDate" placeholder="日期">
                 </div>
         </div>
     </div>
     <div class="am-g am-margin-top">
         <div class="am-u-sm-4 am-u-md-2 am-text-right">
             请假原因
         </div>
         <div class="am-u-sm-8 am-u-md-4">
             <input type="text" class="am-input-sm" name="reason">
         </div>
         <div class="am-hide-sm-only am-u-md-6">*必填</div>
     </div>
        </div>
<div class="am-margin">
    <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交申请</button>
</div>

</form>
</body>
</html>
