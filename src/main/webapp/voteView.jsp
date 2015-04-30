<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
 .voteDetail{  border:1px solid red; }
 .voteDetail .voteItem{float: left; width:150px; height: 235px;  margin: 20px; border:1px solid #000033;text-align: center;}
 .voteDetail .voteItem .picdiv{   height:190px;  border:1px solid #ff6600; position:relative;}
 .voteDetail .voteItem img{   width: 150px; position:absolute; bottom:0px; left:0;max-height:190px; margin:0;}
 .voteDetail .voteItem .title{width:100%; }
 .voteDetail .voteItem span{margin-right:20px;}
 .voteDetail .voteItem .pillar{margin-left:auto;margin-right:auto; position:absolute; bottom:0px; left:35%; width:40px; background: yellow;}
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
		<div class="voteItem">
			<div class="picdiv"><img alt="" src="pic.png" /></div>
			<div>
				<div class="title">fafdafafafa</div>
				<span>10</span><button value="21">fd</button>
			</div>
		</div>
		<div class="voteItem">
			<div class="picdiv"><img alt="" src="pic2.png" /></div>
			<div>
				<div class="title">fafdafafafa</div>
				<span>10</span><button value="21">fd</button>
			</div>
		</div>
		<div class="voteItem">
			<div class="picdiv"><div class="pillar" style="height:30px;"></div></div>
			<div>
				<div class="title">fafdafafafa</div>	
				<span>10</span><button value="212">dfd</button>
			</div>
		</div>
	</div>
</div>
 