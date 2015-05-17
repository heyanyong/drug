<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>XX科技有限公司办公系统</title>
<link href="themes/css/login.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
</head>

<body>
	<div class="wrap">
		<div class="banner-show" id="js_ban_content">
			<div class="cell bns-01">
				<div class="con"></div>
			</div>
			<div class="cell bns-02" style="display: none;">
				<div class="con">
					<a href="#" target="_blank" class="banner-link"> <i>圈子</i></a>
				</div>
			</div>
			<div class="cell bns-03" style="display: none;">
				<div class="con">
					<a href="#" target="_blank" class="banner-link"> <i>企业云</i></a>
				</div>
			</div>
		</div>
		<div class="banner-control" id="js_ban_button_box">
			<a href="javascript:;" class="left">左</a> <a href="javascript:;"
				class="right">右</a>
		</div>
		<script type="text/javascript">
			;
			(function() {

				var defaultInd = 0;
				var list = $('#js_ban_content').children();
				var count = 0;
				var change = function(newInd, callback) {
					if (count)
						return;
					count = 2;
					$(list[defaultInd]).fadeOut(400, function() {
						count--;
						if (count <= 0) {
							if (start.timer)
								window.clearTimeout(start.timer);
							callback && callback();
						}
					});
					$(list[newInd]).fadeIn(400, function() {
						defaultInd = newInd;
						count--;
						if (count <= 0) {
							if (start.timer)
								window.clearTimeout(start.timer);
							callback && callback();
						}
					});
				}

				var next = function(callback) {
					var newInd = defaultInd + 1;
					if (newInd >= list.length) {
						newInd = 0;
					}
					change(newInd, callback);
				}

				var start = function() {
					if (start.timer)
						window.clearTimeout(start.timer);
					start.timer = window.setTimeout(function() {
						next(function() {
							start();
						});
					}, 8000);
				}

				start();

				$('#js_ban_button_box').on('click', 'a', function() {
					var btn = $(this);
					if (btn.hasClass('right')) {
						//next
						next(function() {
							start();
						});
					} else {
						//prev
						var newInd = defaultInd - 1;
						if (newInd < 0) {
							newInd = list.length - 1;
						}
						change(newInd, function() {
							start();
						});
					}
					return false;
				});

			})();
		</script>
		<div class="container">
			<div class="register-box">
			 <form action="checkLogin" method="post" id="loginForm" >
				<div class="reg-form" id="js-form-mobile">
					<div class="failMsg">
						&nbsp;<c:if test="${param.loginMsg==1}">用户名或密码错误</c:if>
					</div>
					<div class="cell">
						<label for="userNo">账号</label> <input type="text"
							name="no" id="userNo" class="text" maxlength="11" />
					</div>
					<div class="cell">
						<label for="password">密码</label> <input type="password"
							name="password" id="password" class="text" />
					</div>
					<div style="padding-left: 60px; font-size: 15px;">
						<input type="checkbox" id="isRemember" />&nbsp;&nbsp;记住用户名
					</div>
					<div class="bottom" onclick="userLogin()">
						<a class="button btn-green"> 立即登录</a>
					</div>

					</div>
			 </form>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		var isRemember = $.cookie("isRemember");
		if (isRemember == "true") {
			$("#isRemember").attr("checked", true);
			$("#userNo").val($.cookie("userNo"));
			$("#password").focus();
		} else {
			$("#userNo").focus();
		}
	});
	function userLogin() {
		if ($("#isRemember").attr("checked")) {
			var userNo = $("#userNo").val();
			$.cookie("isRemember", "true", {
				expires : 15
			});
			$.cookie("userNo", userNo, {
				expires : 15
			}); // 存储一个带7天期限的 cookie
		} else {
			$.cookie("isRemember", "false", {
				expires : -1
			}); // 删除 cookie
			$.cookie("userNo", '', {
				expires : -1
			});
		}
		$("#loginForm").submit();
	}
	
	
	$(function() {
		document.onkeydown = function(e) {
			var ev = document.all ? window.event : e;
			if (ev.keyCode == 13) {
				userLogin();
			}
		}
	});
</script>
</html>