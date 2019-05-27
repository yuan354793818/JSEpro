<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="cn.speedit.application.cache.SystemConfigCache"%>
<%@taglib prefix="s" uri="sfw"%>
<% 	String globalLargeEquipmentPrice = SystemConfigCache.getConfigValue("large_equipment_price");
	cn.speedit.framework.util.CommonFun.setAttribute2PageContext(pageContext,"globalLargeEquipmentPrice", globalLargeEquipmentPrice);
	cn.speedit.framework.util.CommonFun.setAttribute2PageContext(pageContext,"assets_count", SystemConfigCache.getConfigValue("assets_count", "1"));
%>
<s:page title="变动业务记录" disvalidpermission="true">
	<script src="res/assets/js/initAssets.js"></script>
	<%-- <s:navigation icon="bars">
		<s:navigation.node href="e?page=assets.personal.index" text="个人业务"></s:navigation.node>
		<s:navigation.node href="e?page=assets.personal.change.list" text="变动业务"></s:navigation.node>
	</s:navigation> --%>
	<c:import url="/e?page=assets.common.include.businessEntry">
		<c:param name="business_role" value="personal" />
		<c:param name="business_type" value="change" />
		<c:param name="business_type_name" value="变动业务" />
	</c:import>
	<s:tab>
		<s:tab.panel title="变动业务列表" name="变动业务列表" active="true" icon="list">
			<s:table.toolbar>
			</s:table.toolbar>
			<s:datatable action="assets.personal.change.queryAssetsChange" item="changelist" id="changelist" sortable="true" template="assets.business"
				onpaint="businessChangeRow" totals="共$[count(num)]笔, $[sum(num)]台件在办, $[sum(cancel_num)]台件被驳回, 总值$[sum(money)]元." exportname="变动业务列表">
				<s:datatable.column field="businessCode" name="业务类别" sortable="true" width="70" sortfield="business_code" important="1" />
				<s:datatable.column field="assetsType" name="资产类别" sortable="true" width="60" available="${fn:escapeXml(assets_count eq 1 )}" important="1" />
				<s:datatable.column field="bpmNo" name="业务号" sortable="true" width="50" sortfield="bpm_no" important="1" />
				<s:datatable.column field="subject" name="业务主题" sortable="true" important="1" />
				<s:datatable.column field="requestTime" name="申请时间" sortable="true" type="datetime" format="yy-MM-dd HH:mm" defaultsort="desc" width="90" important="1" />
				<s:datatable.column field="num" name="在办数量" sortable="true" width="30" type="number" important="1" />
				<s:datatable.column field="money" name="在办价值" type="currency" sortable="true" width="80" important="1" />
                <s:datatable.column field="changeprice" name="变动金额" type="currency" sortable="true" width="80" important="1" />
				<s:datatable.column field="cancelNum" name="驳回数量" sortable="true" width="30" important="1" />
				<s:datatable.column field="state" name="业务状态" sortable="true" width="80" important="1" />
                <s:datatable.column field="nodeTime" name="到达当前节点时间" sortable="true" type="datetime" format="yy-MM-dd HH:mm" width="90" hide="true" />
				<s:datatable.column field="op" name="操作" nodata="true" width="160" important="1" />
			</s:datatable>
		</s:tab.panel>
	</s:tab>
</s:page>
<script type="text/javascript">
	//businessRole、businessType 业务列表页面必须定义
    var businessRole = "personal";
    var businessType = "change";
    var globalLargeEquipmentPrice = "${fn:escapeXml(globalLargeEquipmentPrice)}";
    
	$(document).ready(function() {

		query();
	});
	function query() {
		$("#changelist")[0].setExtendData($("form:first").getData());
		$("#changelist")[0].refresh();
	}

	function excel() {
		$("#changelist")[0].setExtendData($("form:first").getData());
		$("#changelist")[0].exportExcel();
	}
	
</script>