<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="pageContent">
	<form id="leaveDetailF" method="post" action="leave/update" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><a class="buttonActive" class="close"  href="javascript:navTab.closeCurrentTab();"><span>关闭</span></a></li>
				<c:if test="${!(param.taskDes eq 'over')}"> 
				<c:if test="${(loginUser.no eq info.createUser.no)||fn:contains(param.taskDes, '修改')}">
				<li><a class="buttonActive" href="javascript:saveBill('leaveDetailF');"><span>保存</span></a></li>
				</c:if>
				<c:if test="${(loginUser.no eq info.createUser.no)&&(!empty param.dealer)}">
				<li><a class="buttonActive" href="flow/recall?instanceId=${param.processInstanceId}" target="ajaxTodo"><span>撤消流程</span></a></li>
				</c:if>
				<c:if test="${fn:contains(param.taskDes, '转办')}">
				<li><a class="buttonActive" href="sys/taskTransfer.jsp?taskId=${param.taskId}" target="dialog" ><span>任务转交</span></a></li>
				</c:if>
				<c:if test="${!empty param.dealer}">
				<li><a class="buttonActive" href="sys/taskDeal.jsp?processInstanceId=${param.processInstanceId}&taskId=${param.taskId}" target="dialog" ><span>办理任务</span></a></li>
				</c:if>
				</c:if>
			</ul>
		</div>
		<div class="pageFormContent leaveBill" layoutH="56">
			<p>
				<label>编号：</label> <input name="no" type="text" readonly="readonly" value="${info.no}" size="30"/>
			</p>
			<p>
				<label>申请人：</label> <input   value="${info.createUser.name}" readonly="readonly" type="text"	size="30"/>
			</p>
			<p>
				<label>申请工号：</label> <input   value="${info.createUser.no}" readonly="readonly" type="text"	size="30"/>
			</p>
			<p>
				<label>部门：</label> <input type="text"  size="30" readonly="readonly" value="${info.createUser.structure.name}" />
			</p>
			<p>
				<label>开始日期：</label>
				<input type="text" name="startDate" class="date required" value="<fmt:formatDate value='${info.startDate}' pattern='yyyy-MM-dd HH:mm:ss'/>"  size="30" dateFmt="yyyy-MM-dd HH:mm:ss"   size="30" dateFmt="yyyy-MM-dd HH:mm:ss"  /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>结束日期：</label>
				<input type="text" name="endDate"  class="date required" value="<fmt:formatDate value='${info.endDate}' pattern='yyyy-MM-dd HH:mm:ss'/>"  size="30" dateFmt="yyyy-MM-dd HH:mm:ss"   /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>总小时数：</label> <input type="text"    size="30" name="hours" value="${info.hours }" onclick="calculateHours()" />
			</p>
			<p>
				<label>请假类型：</label> <select name="type">
					<option value="">请选择</option>
					<option value="事假" selected="selected">事假</option>
					<option value="补休假">补休假</option>
					<option value="年假">年假</option>
					<option value="产假">产假</option>
				</select>
			</p>
			<p>
				<label>工作交接人：</label>
				<input type="hidden" name="cadidate.id" value="${info.cadidate.id }" />
				<input type="text"  name="cadidate.name" size="30" value="${info.cadidate.name }"  readonly="readonly" lookupGroup="cadidate" />
				<a class="btnLook" href="userLookup.jsp" lookupGroup="cadidate">查找带回</a>		
			</p>
			<dl class="nowrap">
				<dt>请假说明：</dt>
				<dd>
					<textarea name="reason" cols="95" rows="6" >${info.reason }</textarea>
				</dd>
			</dl>
		<input  type="hidden"  name="createUser.id" value="${info.createUser.id}"/>
		<input  type="hidden"  name="id" value="${info.id}"/>
		<input  type="hidden"  name="flowId" value="${info.flowId}"/>
		<input  type="hidden"  name="status" value="${info.status}"/>
		<input type="hidden" name="createDate" value="<fmt:formatDate value='${info.createDate}' pattern='yyyy-MM-dd'/>"/>
<%-- <div class="information">
			 <p>
			 	<input  type="hidden" readonly="readonly" name="createUser.id" value="${info.createUser.id}" />
				<label>创建人：</label> <input  type="text" readonly="readonly" value="${info.createUser.name}" />
			</p>
			 <p>
				<label>创建人账号：</label> <input  type="text" readonly="readonly" value="${info.createUser.no}" />
			</p>
			 <p>
				<label>最后更新人：</label> <input  type="text" readonly="readonly" value="${info.updateUser.name}" />
			</p>
			 <p>
				<label>更新人账号：</label> <input  type="text" readonly="readonly" value="${info.updateUser.no}" />
			</p>
			 <p>
				<label>最后更新时间：</label> <input  type="text" readonly="readonly" value="${info.updateDate}" />
			</p>
			</div> --%>
			<div class="divider"></div>
			<div class="comments" >
			<table  >
			<thead>
			  <tr>
			    <th width="130">流程节点</th>
			    <th width="80">办理人</th>
			    <th width="155">任务结束</th>
			    <th width="35">结果</th>
			    <th>批注</th>
			  </tr>
			</thead>
			<tbody>
			<c:forEach items="${comments}" var="e">
			  <tr>
			    <td>${e[0]}</td>
			    <td><code>${e[1]}</code></td>
			    <td>
			    <%-- 开始：<fmt:formatDate value='${e[2]}' pattern='yyyy-MM-dd HH:mm:ss'/><br />
			   结束： --%><fmt:formatDate value="${e[3]}"  pattern='yyyy-MM-dd HH:mm:ss'/></td>
			    <td>${e[4]}</td>
			    <td>${e[5]}</td>
			  </tr>
			  </c:forEach>
			  </tbody>
			</table>
			</div>
		</div>
	</form>
</div>

<script>
	if ("${param.dealer}".length>1) {
		editCtrl("#leaveDetailF", "${param.taskDes}");
	}
	function saveBill(form) {
		$("#" + form).attr("action", "leave/update");
		$("#" + form).submit();
	}
	function getDate(strDate) {
		var st = strDate;
		var a = st.split(" ");
		var b = a[0].split("-");
		var c = a[1].split(":");
		var date = new Date(b[0], b[1], b[2], c[0], c[1], c[2])
		return date;
	}
	function calculateHours() {
		var startDate = $(".leaveBill input[name='startDate']").val();
		var endDate = $(".leaveBill input[name='endDate']").val();
		if (startDate != "" && endDate != "") {
			var hours = getDate(endDate).getTime()
					- getDate(startDate).getTime();
			$(".leaveBill input[name='hours']").val(
					Math.ceil(hours / (1000 * 3600)));
		}
	}
</script>