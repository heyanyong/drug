<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DMS</title>
<link href="themes/default/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="themes/css/core.css" rel="stylesheet" type="text/css" media="screen" />
<link href="themes/css/print.css" rel="stylesheet" type="text/css" media="print" />
<link href="uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen" />
<link href="themes/css/extend.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>

<script src="js/dwz.core.js" type="text/javascript"></script>
<script src="js/dwz.util.date.js" type="text/javascript"></script>
<script src="js/dwz.validate.method.js" type="text/javascript"></script>
<script src="js/dwz.barDrag.js" type="text/javascript"></script>
<script src="js/dwz.drag.js" type="text/javascript"></script>
<script src="js/dwz.tree.js" type="text/javascript"></script>
<script src="js/dwz.accordion.js" type="text/javascript"></script>
<script src="js/dwz.ui.js" type="text/javascript"></script>
<script src="js/dwz.theme.js" type="text/javascript"></script>
<script src="js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="js/dwz.navTab.js" type="text/javascript"></script>
<script src="js/dwz.tab.js" type="text/javascript"></script>
<script src="js/dwz.resize.js" type="text/javascript"></script>
<script src="js/dwz.dialog.js" type="text/javascript"></script>
<script src="js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="js/dwz.cssTable.js" type="text/javascript"></script>
<script src="js/dwz.stable.js" type="text/javascript"></script>
<script src="js/dwz.taskBar.js" type="text/javascript"></script>
<script src="js/dwz.ajax.js" type="text/javascript"></script>
<script src="js/dwz.pagination.js" type="text/javascript"></script>
<script src="js/dwz.database.js" type="text/javascript"></script>
<script src="js/dwz.datepicker.js" type="text/javascript"></script>
<script src="js/dwz.effects.js" type="text/javascript"></script>
<script src="js/dwz.panel.js" type="text/javascript"></script>
<script src="js/dwz.checkbox.js" type="text/javascript"></script>
<script src="js/dwz.history.js" type="text/javascript"></script>
<script src="js/dwz.combox.js" type="text/javascript"></script>
<script src="js/dwz.print.js" type="text/javascript"></script>
<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="js/my.extend.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="themes/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
$(function(){
	DWZ.init("dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>
  <body>
	<div id="layout">
		 <div id="header">
			<div class="headerNav">
				<a class="logo" href="/">标志</a>
				<ul class="nav">
					<li><a href="user/center" target="navTab" rel="userCenter">${loginUser.name}</a></li>
					<li><a href="changepwd.html" target="dialog" width="400" height="200">设置</a></li>
					<li><a href="logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div> 
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<div>收缩</div>
				</div>
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2> <span>Folder</span>商务管理 </h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>常用单据</a>
								<ul>
									<li><a href="pay/list" target="navTab" rel="payList">付款申请</a></li>
									<li><a href="supplier/list" target="navTab" rel="supplierList">供应商管理</a></li>
									<li><a href="customer/list" target="navTab" rel="customerList">客户管理</a></li>
								</ul>
							</li>
							<c:if test="${!empty shangwu_dm}">
							<li><a>部门报表</a>
								<ul><li><a href="pay/list" target="navTab" rel="payList">付款申请</a></li>
									<li><a href="supplier/list" target="navTab" rel="supplierList">部门供应商</a></li>
									<li><a href="customer/list" target="navTab" rel="customerList">部门客户汇总</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty shangwu_cm}">
							<li><a>汇总报表</a>
								<ul><li><a href="pay/list" target="navTab" rel="payList">付款申请</a></li>
									<li><a href="supplier/list" target="navTab" rel="supplierList">供应商汇总</a></li>
									<li><a href="customer/list" target="navTab" rel="customerList">客户汇总</a></li>
								</ul>
							</li>
							</c:if>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2> <span>Folder</span>行政管理 </h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>常用单据</a>
								<ul>
									<li><a href="vote/list" target="navTab" rel="voteList">办公用品申购</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">投票管理</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">活动审批</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">名片申请</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">用车申请</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">印章使用申请</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">印章新刻申请</a></li>
								</ul>
							</li>
							<c:if test="${!empty xingzheng_dm}">
							<li><a>部门报表</a>
								<ul>
									<li><a href="vote/list" target="navTab" rel="voteList">投票管理</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">活动审批</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty xingzheng_cm}">
							<li><a>汇总报表</a>
								<ul>
									<li><a href="vote/list" target="navTab" rel="voteList">投票管理</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">活动审批</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty xingzheng_mm}">
							<li><a>维护管理</a>
								<ul>
									<li><a href="vote/list" target="navTab" rel="voteList">投票管理</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">固定资产采购申请</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">固定资产采购合同</a></li>
									<li><a href="vote/list" target="navTab" rel="voteList">固定资产库存管理</a></li>
								</ul>
							</li>
							</c:if>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2> <span>Folder</span>人力资源 </h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>常用单据</a>
								<ul>
									<li><a href="leave/persList" target="navTab" rel="leavePersList">加班申请</a></li>
									<li><a href="leave/persList" target="navTab" rel="leavePersList">请假申请</a></li>
									<li><a href="signException/list" target="navTab" rel="signExceptionList">个人考勤记录</a></li>
									<li><a href="sign/list" target="navTab" rel="signList">考勤异常申请</a></li>
									<li><a href="enrol/list" target="navTab" rel="enrolList">用人需求</a></li>
									<li><a href="quit/list" target="navTab" rel="quitAdd">离职申请</a></li>
								</ul>
							</li>
							<c:if test="${!empty renliziyuan_dm}">
							<li><a>部门报表</a>
								<ul>
									<li><a href="leave/deptList" target="navTab" rel="leaveDeptList">部门请假列表</a></li>
									<li><a href="sign/list" target="navTab" rel="signList">考勤记录总表</a></li>
									<li><a href="enrol/list" target="navTab" rel="userAdd">用人需求报表</a></li>
									<li><a href="quit/list" target="navTab" rel="quit/addList">离职申请报表</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty renliziyuan_cm}">
							<li><a>汇总报表</a>
								<ul>
									<li><a href="leave/list" target="navTab" rel="leaveList">请假列表</a></li>
									<li><a href="sign/list" target="navTab" rel="signList">考勤记录总表</a></li>
									<li><a href="enrol/list" target="navTab" rel="userAdd">用人需求报表</a></li>
									<li><a href="quit/list" target="navTab" rel="quit/addList">离职申请报表</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty renliziyuan_mm}">
							<li><a>维护管理</a>
								<ul>
									<li><a href="user/list" target="navTab" rel="userList">用户管理</a></li>
									<li><a href="userAdd.jsp" target="navTab" rel="userList">添加用户</a></li>
									<li><a href="role/list" target="navTab" rel="roleList">角色管理</a></li>
									<li><a href="structure/show" target="navTab" rel="structureList">部门管理</a></li>
								</ul>
							</li>
							</c:if>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2> <span>Folder</span>账务管理 </h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>常用单据</a>
								<ul>
									<li><a href="expense/list" target="navTab" rel="expenseList">费用报销</a></li>
									<li><a href="expense/list" target="navTab" rel="expenseList">预算调整申请</a></li>
								</ul>
							</li>
							<c:if test="${!empty caiwu_dm}">
							<li><a>部门报表</a>
								<ul>
									<li><a href="expense/list" target="navTab" rel="expenseList">费用报销报表</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty caiwu_cm}">
							<li><a>汇总报表</a>
								<ul>
									<li><a href="expense/list" target="navTab" rel="expenseList">费用报销报表</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${!empty caiwu_mm}">
							<li><a>维护管理</a>
								<ul>
									<li><a href="budget/list" target="navTab" rel="budgetList">部门预算维护</a></li>
									<li><a href="subject/list" target="navTab" rel="subjectList">费用科目维护</a></li>	
								</ul>
							</li>
							</c:if>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2> <span>Folder</span>信息管理 </h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a>资讯管理</a>
								<ul>
									<li><a href="article/add" target="navTab" rel="articleAdd">新增文章</a></li>
									<li><a href="article/list" target="navTab" rel="articleList">文章列表</a></li>
								</ul>
							</li>
							<li><a>通知公告</a>
								<ul>
									<li><a href="article/add" target="navTab" rel="articleAdd">新增文章</a></li>
									<li><a href="article/list" target="navTab" rel="articleList">文章列表</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>风控管理
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="newPage1.html" target="navTab" rel="dlg_page">合同审批</a></li>
							<li><a href="newPage1.html" target="navTab" rel="dlg_page">业务审批</a></li>
						</ul>
					</div>
					<c:if test="${!empty system_root}">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>系统管理
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="menu/show" target="navTab" rel="menuList">菜单设置</a></li>
							<li><a href="flow/flowList" target="navTab" rel="flowList">系统流程</a></li>
							<li><a href="flow/deployList" target="navTab" rel="deployList">流程部署</a></li>
							<li><a href="flow/instanceList" target="navTab" rel="instanceList">流程跟踪</a></li>
							<li><a href="controllerLog/list" target="navTab" rel="controllerLogList">操作记录</a></li>
							<li><a href="role/list" target="navTab" rel="roleList">权限管理</a></li>
							<li><a href="sysurl/list" target="navTab" rel="sysurlList">URL维护</a></li>
							<li><a href="monitoring" target="_blank" rel="monitoring">服务器运行监控</a></li>
						</ul>
					</div>
					</c:if>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="pageFormContent" layoutH="60">
							 <div class="oftenFunction">
								<p>
									<a href="sign/list?show=dialog" target="dialog" height="300"
										rel="signListDialog" title="考勤查询"><img
										src="themes/clock.png" /></a><span>考勤查询</span>
								</p>
								<p>
									<a href="user/list?show=dialog" target="dialog" height="300"
										rel="userListDialog" title="通讯录查询"><img
										src="themes/ico06.png" /></a><span>通讯录查询</span>
								</p>
								<p>
									<a  rel="userMessageDialog" title="个人消息"><img
										src="themes/mail.png" /></a><span>个人消息</span>
								</p>
								<p>
									<a href="notice/list?show=dialog" target="dialog" height="300"
										rel="noticeListDialog" title="备忘录">
										<img src="themes/ico02.png" /></a><span>备忘录</span>
								</p>
								<p>
									<a href="upload/diskList?show=dialog" target="dialog" height="300"
										rel="diskListDialog" title="文档记录"><img
										src="themes/d01.png" /></a><span>文档记录</span>
								</p>
							</div>
							 <div class="lastNews">
								<ul>
									<c:forEach items="${news}" var="e">
									<li><a href="article/view/${e.id}" target="navTab" rel="article${e.id}">${e.name}</a><span>${e.createDate}</span></li>
									</c:forEach>
									<c:if test="${!empty vote}">
									<li><a href="vote/view/${vote.id}" target="navTab" rel="vote${vote.id}"><img src="images/vote.png"/>&nbsp;${vote.name}</a><span>${vote.createDate}</span></li>
									</c:if>
								</ul>
							</div> 
							<div class="clear"></div>
							<div class="taskCenter" id="personTaskList">
									 
							</div>
							 <div class="static">
								<div id="chartHolder"></div>
							</div>
						</div>
						<!--main-->
					</div>
				</div>
			</div>
		</div>

	</div>
	<div id="footer">
		Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">XX科技有限公司版权所有</a>
	</div>
</body>

<script>
	var taskTimer;
	//function loadTask()
	// {
	   $("#personTaskList").loadUrl("flow/taskList",null, null);
	// }
	//taskTimer= window.setInterval("loadTask()",10000); 
	
	title = "October Browser Statistics";
	titleXpos = 180;
	titleYpos = 22;

	/* Pie Data */
	pieRadius = 85;
	pieXpos = 98;
	pieYpos = 150;
	pieData = ${countData};
	pieLegend = ${countItem};

	pieLegendPos = "east";

	$(function() {
		var r = Raphael("chartHolder");
		r.text(titleXpos, titleYpos, title).attr({
			"font-size" : 20
		});

		var pie = r.piechart(pieXpos, pieYpos, pieRadius, pieData, {
			legend : pieLegend,
			legendpos : pieLegendPos
		});
		pie.hover(function() {
			this.sector.stop();
			this.sector.scale(1.1, 1.1, this.cx, this.cy);
			if (this.label) {
				this.label[0].stop();
				this.label[0].attr({
					r : 7.5
				});
				this.label[1].attr({
					"font-weight" : 800
				});
			}
		}, function() {
			this.sector.animate({
				transform : 's1 1 ' + this.cx + ' ' + this.cy
			}, 500, "bounce");
			if (this.label) {
				this.label[0].animate({
					r : 5
				}, 500, "bounce");
				this.label[1].attr({
					"font-weight" : 400
				});
			}
		});
	});
</script>
</html>
