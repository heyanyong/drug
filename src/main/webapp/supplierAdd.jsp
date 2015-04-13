<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="supplier/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>基本信息</legend>
			<p>
				<label>供应商编号：</label>
				<input name="no" type="text"   value="${no}" readonly="readonly" size="30"/>
			</p>
			<p>
				<label>供应商全称：</label>
				<input name="name" class="required" type="text" size="30"   />
			</p>
			<p>
				<label>简称：</label>
				<input name="simpleName"   type="text"  size="30"  />
			</p>
			<p>
				<label>英文名称：</label>
				<input name="englishName"   type="text" size="30"  />
			</p>
			
			
			</fieldset>
			<fieldset>
				<legend>相关信息</legend>
			<p>
				<label>所属客户：</label>
				<input type="hidden" name="customer.id"/>
				<input type="text" class="required" name="customer.name" size="30" readonly="readonly"/>
				<a class="btnLook"  href="customer/list?show=dialog" lookupGroup="customer"  width="500" >查找带回</a>		
			</p>
			<p>
				<label>银行账号：</label>
				<input name="devUser"  type="text" size="30"   />
			</p>
			<p>
				<label>开户行：</label>
				<input name="devUser"  type="text" size="30"   />
			</p>
			<p>
				<label>开发人员：</label>
				<input name="devUser"  type="text" size="30" />
			</p>
			<p>
				<label>开发部门：</label>
				<input name="devDepartment" value=""  type="text" size="30"/>
			</p>
			</fieldset>
			<fieldset>
				<legend>其它信息</legend>
				<p>
			<label>供应商类型：</label>
				<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="个人">个人</option>
					<option value="公司" selected>公司</option>
				</select>
			</p>
				<p>
				<label>联系人：</label>
				<input name="contactPerson"   type="text" size="30"   value="${info.contactPerson}"/>
			</p>
			<p>
				<label>联系电话：</label>
				<input name="phone"   type="text" size="30"   value="${info.phone}"/>
			</p>
			<p>
				<label>通讯地址：</label>
				<input name="address"   type="text" size="30"   value="${info.address}"/>
			</p>
			<p>
				<label>营业执照号：</label>
				<input type="text" name="certificationNo" size="30" />
			</p>
			<p>
				<label>公司成立日期：</label>
				<input type="text" name="foundDate" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>所属行业：</label>
				<input type="text" name="industry"  size="30" />
			</p>
			<p>
				<label>法人姓名：</label>
				<input type="text" size="30" name="legalPerson" />
			</p>
			<dl class="nowrap">
				<dt>主要经营产品：</dt>
				<dd>
					<textarea name="textarea1" cols="88" rows="2" name="mainBusiness">${mainBusiness }</textarea>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="textarea1" cols="88" rows="2" name="remark">${info.remark}</textarea>
				</dd>
			</dl>
			</fieldset>
		</div>
		
	</form>
</div>
