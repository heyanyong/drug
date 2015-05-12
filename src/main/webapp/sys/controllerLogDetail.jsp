<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.conlogtab{margin-top:30px; margin-left:10%; height:450px; overflow: auto; }
.conlogtab table {     width:90%; }
.conlogtab td{ border:1px solid #a1cbee;word-wrap:break-word;  }
.conlogtab .tabtitle{white-space: nowrap;line-height: 20px; width:17%; text-align: center;background: #f6f5fb;font-weight: bold; letter-spacing: 2px;}
</style>
<div class="conlogtab">
<table >
  <tr>
    <td class="tabtitle">记录时间</td>
    <td>${info.createDate }</td>
  </tr>
  <tr>
    <td class="tabtitle">登录用户</td>
    <td>${info.userName }</td>
  </tr>
  <tr>
    <td class="tabtitle">用户账号</td>
    <td>${info.userNo }</td>
  </tr>
  <tr>
    <td class="tabtitle">IP地址</td>
    <td>${info.ip }</td>
  </tr>
  <tr>
    <td class="tabtitle">操作</td>
    <td>${info.methodCnName }</td>
  </tr>
  <tr>
    <td class="tabtitle">通信参数</td>
    <td>${info.argsContent }</td>
  </tr>
  <tr>
    <td class="tabtitle">触发对象</td>
    <td>${info.methodFullName }</td>
  </tr>
  <tr>
    <td class="tabtitle">触发方法</td>
    <td>${info.methodName }</td>
  </tr>
  <tr>
    <td class="tabtitle">返回值</td>
    <td>${info.returnValue }</td>
  </tr>
  
</table>
</div>
