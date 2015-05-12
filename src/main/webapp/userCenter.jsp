<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.conlogtab{margin-top:30px; margin-left:10%; height:450px; overflow: auto; }
.conlogtab table {     width:90%; }
.conlogtab td{ border:1px solid #a1cbee;word-wrap:break-word;line-height: 20px; padding:5px; }
.conlogtab .tabtitle{white-space: nowrap;line-height: 20px; width:17%; text-align: center;background: #f6f5fb;font-weight: bold; letter-spacing: 2px;}
</style>
<div class="conlogtab">
<table >
  <tr>
    <td class="tabtitle">用户名</td>
    <td>${loginUser.name }</td>
  </tr>
  <tr>
    <td class="tabtitle">账号</td>
    <td>${loginUser.no}</td>
  </tr>
  <tr>
    <td class="tabtitle">入职日期</td>
    <td>${loginUser.entryDate}</td>
  </tr>
  <tr>
    <td class="tabtitle">登记手机号</td>
    <td>${loginUser.phone}</td>
  </tr>
  <tr>
    <td class="tabtitle">登记邮箱</td>
    <td>${loginUser.email}</td>
  </tr>
 
  
</table>
</div>
