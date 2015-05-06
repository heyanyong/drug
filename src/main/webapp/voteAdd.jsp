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
					<label>编 号：</label> <input name="no" type="text" value="${no}"
						readonly="readonly" name="no" size="30" />
				</p>
				<p>
					<input type="hidden" name="createUser.id" value="${loginUser.id}" />
					<label>发起人：</label> <input name="createUser.name" type="text" value="${loginUser.name}"
						readonly="readonly" name="no" size="30" />
				</p>
				<p>
					<label>部 门：</label> <input   type="text" value="${loginUser.structure.name}" readonly="readonly" name="no" size="30" />
				</p>
				<p>
					<label>标 题：</label> <input name="name" class="required"  type="text" size="30" />
				</p>
				<p>
				<label>开始日期：</label>
				<input type="text" name="startTime" class="date required"   size="30" dateFmt="yyyy-MM-dd HH:mm:ss"  /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>结束日期：</label>
				<input type="text" name="endTime"  class="date required" size="30" dateFmt="yyyy-MM-dd HH:mm:ss"   /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			</fieldset>
			<fieldset>
				<legend>内容介绍</legend>
				<dl class="nowrap">
				<dt>内容介绍：</dt>
				<dd>
					<textarea name="content" cols="95" rows="4"></textarea>
				</dd>
			</dl>
			</fieldset>
		
		<div class="divider"></div>
			<div class="panel collapse" minH="180"  style="width:65%;">
				<h1>投票明细 </h1>
				<div>
					<table class="list nowrap itemDetail" addButton="追加明细项" width="100%">
						<thead>
							<tr>
								<th type="del" width="28">删除</th>
								<th type="text" defaultVal="#index#" size="2"  >序号</th>
								<th type="text" name="items[#index#].name" size="60" >名称</th>
								<th type="text" name="items[#index#].voteNum"  size="10" fieldClass="digits">初始票数</th>
								<th type="attach" name="items[#index#].attachment.fileName" lookupGroup="items[#index#].attachment" lookupUrl="depart/attachmentLookup.html" size="30">图片</th>
							</tr>
						</thead>
						<tbody>	</tbody>
					</table>
				</div>
			</div>
			</div>
	</form>
</div>
