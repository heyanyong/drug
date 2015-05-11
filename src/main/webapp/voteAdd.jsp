<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent" >
	<form method="post" action="vote/save"
		class="pageForm required-validate "
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>基本信息</legend>
				<p>
					<input type="hidden" name="createUser.id" value="${loginUser.id}" />
					<label>编 号：</label> <input name="no" type="text" value="${no}" readonly="readonly" size="30" />
				</p>
				<p>
					<label>发起人：</label> <input type="text" value="${loginUser.name}" readonly="readonly" size="30" />
				</p>
				<p>
					<label>部 门：</label> <input type="text" value="${loginUser.structure.name}" readonly="readonly" size="30" />
				</p>
				<p>
					<label>标 题：</label> <input name="name" class="required"  type="text" size="30" />
				</p>
				
				<p> <label>显示投票人：</label>
				    <input type="radio" name="isShowVoter" value="true" checked="checked"/>是  
       				<input type="radio" name="isShowVoter" value="false"/>否
				</p>
				<p> <label>状态：</label>
				    <select name="isOpen" >
						<option value="true">马上开启</option>
						<option value="false">禁止投票</option>
					</select>
				</p>
				<p>
					 <label>开始时间：</label>
					 <input type="text" name="startTime" class="date required" size="30" dateFmt="yyyy-MM-dd HH:mm:ss" />
					 <a class="inputDateButton" href="javascript:;">选择</a>
				</p>
				<p>
					<label>结束时间：</label> 
					<input type="text" name="endTime" class="date required" size="30" dateFmt="yyyy-MM-dd HH:mm:ss" />
					<a class="inputDateButton" href="javascript:;">选择</a>
				</p>
			</fieldset>
			<fieldset>
				<legend>内容介绍</legend>
					<textarea class="editor" name="content" rows="5" cols="100" tools="simple"></textarea>
			</fieldset>
		
		<div class="divider"></div>
			<div class="panel collapse" minH="150"  style="width:50%;">
				<h1>投票明细 </h1>
				<div>
					<table class="list nowrap itemDetail" addButton="追加明细项" width="100%">
						<thead>
							<tr>
								<th type="del" width="28">删除</th>
								<th type="text" defaultVal="#index#" size="1"  >序号</th>
								<th type="text" name="items[#index#].name" size="50" >名称</th>
								<th type="text" name="items[#index#].voteNum"  size="6" fieldClass="digits">初始票数</th>
							</tr>
						</thead>
						<tbody>	</tbody>
					</table>
				</div>
			</div>
			</div>
	</form>
</div>
