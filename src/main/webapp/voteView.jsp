<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
 .voteDetail{position: absolute;}
 .voteDetail .voteItem{float: left; width:150px; height: 220px;  margin: 20px; }
 .voteDetail .voteItem img{ position: absolute;bottom:30px;  width: 150px;}
 .voteDetail .voteItem p{position: absolute; bottom: 0px; height:20px;width: 150px; line-height:20px;text-align: center;}
 .voteDetail .voteItem span{margin-right:20px;}
 .voteDetail .voteItem .pillar{margin-left:auto;margin-right:auto;bottom:30px;width:40px; background: yellow;}
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
			<img alt="" src="images/profile-pic.jpg" />
			<p>
				<span>10票</span><button value="投票">投票</button>
			</p>
		</div>
		<div class="voteItem">
			<img alt="" src="images/profile-pic.jpg" />
			<p>
				<span>10票</span><button value="投票">投票</button>
			</p>
		</div>
		<div class="voteItem">
			<div class="pillar" style="height:30px;"></div>
			<p>
				<span>10票</span><button value="投票">投票</button>
			</p>
		</div>
	</div>
</div>
 