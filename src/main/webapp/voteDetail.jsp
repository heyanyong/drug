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
					<label>编号：</label> <input name="no" type="text" value="${info.no}"
						readonly="readonly" name="no" size="30" />
				</p>
				<p>
					<label>标题：</label> <input name="name" class="required" value="${info.name}"
						type="text" size="30" />
				</p>
			</fieldset>
			<fieldset>
				<legend>内容介绍</legend>
				<dl class="nowrap">
				<dt>内容介绍：</dt>
				<dd>
					<textarea name="content" cols="95" rows="4">${info.content}</textarea>
				</dd>
			</dl>
			</fieldset>
		
		<div class="divider"></div>
			<div class="panel collapse" minH="180"  style="width:65%;">
				<h1>投票明细 </h1>
				<div>
					<table class="list nowrap itemDetail" addButton="新建从表1条目" width="100%">
						<thead>
							<tr>
								<th type="del" width="28">删除</th>
								<th type="text" defaultVal="#index#" size="2"  >序号</th>
								<th type="text" name="items[#index#].name"  >名称</th>
								<th type="text" name="items[#index#].voteNum"  size="6" fieldClass="digits">初始票数</th>
								<th type="attach" name="items[#index#].attachment.fileName" lookupGroup="items[#index#].attachment" lookupUrl="depart/attachmentLookup.html" size="12">图片</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${info.items}" var="e" varStatus="es">
							<tr class="unitBox">
								<td><a href="javascript:void(0)" class="btnDel ">删除</a></td>
								<td><input type="text" name="" value="${es.index}" size="2"
									class="textInput"></td>
								<td><input type="text" name="items[${es.index}].name" value="${e.name}"
									size="12" class="textInput"></td>
								<td><input type="text" name="items[${es.index}].voteNum" value="${e.voteNum}"
									size="6" class="digits textInput"></td>
								<td><input type="hidden" name="items[${es.index}].attachment.id"><input
									type="text" name="items[0].attachment.fileName" size="12"
									readonly="readonly" class="textInput readonly"><a
									class="btnAttach" href="depart/attachmentLookup.html"
									lookupgroup="items[0].attachment" lookuppk="id" width="560"
									height="300" title="查找带回">查找带回</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			</div>
	</form>
</div>
