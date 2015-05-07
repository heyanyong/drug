<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<style>
 .voteDetail{margin-left: auto; margin-right: auto; }
 .voteDetail .voteItem{float: left; width:150px; height: 255px;  margin: 20px; border:1px solid #DBDBDB;text-align: center;}
 .voteDetail .voteItem .picdiv{   height:190px;   position:relative; overflow: auto;}
 .voteDetail .voteItem img{   width: 150px; position:absolute; bottom:0px; left:0;max-height:190px; margin:0;}
 .voteDetail .voteItem .title{width:100%;padding: 8px 0px; font-size: 15px; }
 .voteDetail .voteItem span{margin-right:20px; color:red;}
 .voteDetail .voteItem .pillar{border-bottom:1px solid yellow;margin-left:auto;margin-right:auto; position:absolute; bottom:0px; left:35%; width:40px; background: yellow;}
</style>
<div class="pageContent article" layoutH="56">
	<h2>${info.name}</h2>
	<div class="base"><span>${info.createDate }</span><span>${info.createUser.name }</span></div>
	 <div class="divider"></div>
	 <div class="content">
	   ${info.content }
	 </div>
	  <div class="divider"></div>
	<div class="voteDetail">
	  <c:forEach items="${info.items}" var="e">
		<div class="voteItem">
			<div class="picdiv"><div class="pillar" style="height:${e.voteNum+1}px;"></div></div>
			<div>
				<div class="title">${e.name}</div>	
				<span>${e.voteNum}票</span><a href="vote/voteTo?voteId=${info.id}&itId=${e.id}" class="icon" target="ajaxTodo"   title="确定要投当前项吗?">投 票</a>
			</div>
		</div>
	  </c:forEach>
	</div>
</div>
 