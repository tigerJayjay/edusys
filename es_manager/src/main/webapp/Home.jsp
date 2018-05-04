<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>管理信息系统</title>
<script src="resources/Scripts/jquery.min.js" type="text/javascript"></script>
<script src="resources/Res/easyui/jquery.easyui.min.js"
	type="text/javascript"></script>
<script src="resources/Res/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<link href="resources/Res/easyui/themes/default/easyui.css"
	rel="stylesheet" type="text/css" />
<link href="resources/Content/default.css" rel="stylesheet"
	type="text/css" />
<link href="resources/Res/easyui/themes/icon.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript">

        var iframeid = "";
        $(function () {


            addTab("首页", "Home_right.jsp", "tu1112", false);
            $('ul li a').click(function () {
                var tabTitle = $(this).text();
                var url = $(this).attr("rel"); //获取地址
                var id = $(this).attr("id"); //获取id
                var icon = $(this).attr("icon"); //获取图标
                if (icon == "") {
                    icon = "icon-save";
                }
                addTab(tabTitle, url, icon, true, id);
                iframeid = id;
                
            });

            tabCloseEven();

            $('#loginOut').click(function () {

                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function (r) {

                    if (r) {
                        location.href = '/user/logout';
                    }
                });
            });
            $('#ChangePassword').click(function () {
                showMyWindow("修改密码", "Account/ChangePassword");

            });

        })

        function addTab(subtitle, url, icon, closable, id) {

            if (!$('#tabs').tabs('exists', subtitle)) {
                $('#tabs').tabs('add', {
                    title: subtitle,
                    content: createFrame(url, id),
                    closable: closable
                    , icon: icon
                });
            } else {
                $('#tabs').tabs('select', subtitle);

            }
            tabClose();
        }

        function createFrame(url, id) {
            var s = '<iframe id="' + id + '" name="myIframe" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:99.6%;overflow-y: auto; "></iframe>';
            return s;
        }
        function tabClose() {
            /*双击关闭TAB选项卡*/
            $(".tabs-inner").dblclick(function () {
                var subtitle = $(this).children(".tabs-closable").text();
                $('#tabs').tabs('close', subtitle);
            })
            /*为选项卡绑定右键*/
            $(".tabs-inner").bind('contextmenu', function (e) {
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });

                var subtitle = $(this).children(".tabs-closable").text();

                $('#mm').data("currtab", subtitle);
                $('#tabs').tabs('select', subtitle);
                return false;
            });
        }
        //绑定右键菜单事件
        function tabCloseEven() {
            //刷新
            $('#mm-tabupdate').click(function () {
                var currTab = $('#tabs').tabs('getSelected');
                var url = $(currTab.panel('options').content).attr('src');
                $('#tabs').tabs('update', {
                    tab: currTab,
                    options: {
                        content: createFrame(url, iframeid)
                    }
                })
            })
            //关闭
            $('#mm-tabclose').click(function () {
                var currtab_title = $('#mm').data("currtab");
                $('#tabs').tabs('close', currtab_title);
            })


            //退出
            $("#mm-exit").click(function () {
                $('#mm').menu('hide');
            })
        }
        function WindowClose(id) {
            $('#myWindowC').dialog("close");
        }
        function showIdWindow(title, href, width, height, modal, minimizable, maximizable, scrolling) {
            var scrollingVal = (scrolling === undefined ? "yes" : scrolling);
            $('#myWindowC').window({
                title: title,
                width: width === undefined ? 600 : width,
                height: height === undefined ? 450 : height,
                content: '<iframe scrolling="' + scrollingVal + '" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>',
                //        href: href === undefined ? null : href, 
                modal: modal === undefined ? true : modal,
                minimizable: minimizable === undefined ? false : minimizable,
                maximizable: maximizable === undefined ? false : maximizable,
                shadow: false,
                cache: false,
                closed: false,
                collapsible: false,
                resizable: false,
                loadingMessage: '正在加载数据，请稍等片刻......'
            });

        }
        function showMyWindow(title, href, width, height, modal, minimizable, maximizable, scrolling) {
            var scrollingVal = (scrolling === undefined ? "yes" : scrolling);
            $('#myWindow').window({
                title: title,
                width: width === undefined ? 600 : width,
                height: height === undefined ? 450 : height,
                content: '<iframe scrolling="no" frameborder="0"  src="' + href + '" style="width:100%;height:99%;"></iframe>',
                //        href: href === undefined ? null : href, 
                modal: modal === undefined ? true : modal,
                minimizable: minimizable === undefined ? false : minimizable,
                maximizable: maximizable === undefined ? false : maximizable,
                shadow: false,
                cache: false,
                closed: false,
                collapsible: false,
                resizable: false,
                loadingMessage: '正在加载数据，请稍等片刻......'
            });

        }
//        function popen1(sbid) {
//            showMyWindow("查看详细数据", "C_Car/XiangXi/" + sbid, 880, 600);
//            //alert("aaaaaaaaaaa");
//        }
        function WinIdClose() {
            $('#myWindow').dialog("close");
            //刷新当前tabs
            var currTab = self.parent.$('#tabs').tabs('getSelected'); //获得当前tab
            var tab = currTab.panel('options').tab;
         var url = $(currTab.panel('options').content).attr('src');
           // self.parent.$('#tabs').aa();
           // currTab.find('iframe').$("#flexigridData").datagrid("reload");
           // currTab.find('iframe').$("#flexigridData").datagrid("clearSelections");
            self.parent.$('#tabs').tabs('update', {
                tab: currTab,
                options: {
                         // $("#flexigridData").datagrid("reload");
                           // $("#flexigridData").datagrid("clearSelections");
                   // content: createFrame(url)
                }
            });
        }

    </script>
<style type="text/css">
body {
	font-family: 微软雅黑, 新宋体;
}

a {
	color: Black;
	text-decoration: none;
}

.easyui-tree li {
	margin: 5px 0px 0px 0px;
	padding: 1px;
}

#mainlogo {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 575px;
	height: 72px;
}

#center {
	padding-left: 575px;
	padding-right: 425px;
}

#mainctrl {
	position: absolute;
	top: 0px;
	right: 0px;
	height: 72px;
	width: 425px;
}

.top {
	height: 76px;
	background-color: #7CB2EE;
	/*background-image: url(resources/images/top-back.gif);*/
	background-image: url(resources/images/top-bg.jpg);
	background-repeat: repeat-y;
}

.wel {
	height: 30px;
	line-height: 30px;
	color: White;
	font-size: 14px;
	text-align: right;
	padding-right: 5px;
}

.ctr {
	vertical-align: middle;
	margin-top: 18px;
	height: 24px;
	text-align: right;
	background-image: url(resources/images/beijing.gif);
	background-repeat: repeat-x;
}

.ctr li {
	float: left;
	list-style: none;
}

.zi {
	padding-right: 16px;
	padding-left: 3px;
}

a.v1:visited, a.v1:active, a.v1:link {
	font-size: 14px;
	color: #000;
	text-decoration: none;
}

a.v1:hover {
	font-size: 14px;
	color: #005500;
	text-decoration: none;
}
</style>
</head>



<body class="easyui-layout">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="resources/images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 76px; line-height: 20px; color: #fff; font-family: 微软雅黑, 黑体">
		<div class="top">
			<div id="mainlogo"></div>
			<div id="center"></div>
			<div id="mainctrl">
				<div class="wel">
					用户：${login.account}</div>
				<div class="ctr">
					<li><img src="resources/images/yuanjiao.gif" alt="" /></li>
					<li><a href="#"> <img src="resources/images/mimaxiugai.gif" alt=""
							border="0" /></a></li>
					<li class="zi"><a href="#" id="ChangePassword" class="v1">密码修改</a></li>
					<li><a href="#"> <img src="resources/images/anquantuichu.gif" alt=""
							border="0" /></a></li>
					<li class="zi"><a href="#" id="loginOut" class="v1">安全退出</a></li>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div region="west" hide="true" split="true" title="导航菜单"
		style="width: 180px;" id="west">
		<div class="easyui-accordion" fit="true" border="false">
			<div data-options="iconCls:'tu0504'" title="学生管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
					<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="student/studentManager.jsp" id="2012112012281385937501e2fd52680">学生信息管理</a></li>
					
					</ul>
				</div>
			</div>
			<div data-options="iconCls:'tu0625'" title="教师管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="teacher/teacherManager.jsp" id="2012112012281385937501e2fd52680">教师信息管理</a></li>
						<li data-options="iconCls:'tu0704'"><a href="#" icon="tu0704"
							rel="teacher/teacherAward.jsp" id="201212031328455625000985c1d85f8">奖惩管理</a></li>
						<li data-options="iconCls:'tu0625',state:'closed'"><span>考评管理</span>
							<ul>
								<li data-options="iconCls:'tu0704'"><a href="#"
									icon="tu0704"
									rel="teacher/teacherCheck.jsp"
									id="201608161504590864212ee28a7920e">考评内容管理</a></li>
									<li data-options="iconCls:'tu0704'"><a href="#"
									icon="tu0704"
									rel="teacher/checkResult.jsp"
									id="201608161504590864212ee28a7920e">查看考评统计</a></li>
								
							</ul>
					     </li>
						<li data-options="iconCls:'tu0704'"><a href="#" icon="tu0704"
							rel="teacher/workExpre.jsp" id="20121203142326921875036722b4844">工作经历管理</a></li>
					</ul>
				</div>
			</div>


			<div data-options="iconCls:'tu0625'" title="教材管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu0704'"><a href="#" icon="tu0704"
							rel="book/book.jsp"
							id="201212031457004218750f6733c399e">教材管理</a></li>
						<li data-options="iconCls:'tu0704'"><a href="#" icon="tu0704"
							rel="book/bookBuyInfo.jsp"
							id="201212031457004218750f6733c399e">教材购买管理</a></li>
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="book/bookReserve.jsp" id="2012120315004764062502a4e5a9f40">教材预定管理</a></li>
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="book/bookPay.jsp"
							id="201212031501329375000b277965adc">教材收款管理</a></li>
					</ul>
				</div>
			</div>
			<div data-options="iconCls:'tu0625'" title="考务管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="exam/examArrange.jsp" id="2012120315420426562501c03cd9fab">考试安排</a></li>
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="exam/examAbnor.jsp" id="2012120315424664062507fe78cee2b">考场异常情况管理</a></li>
							<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="exam/invigilate.jsp" id="2012120315424664062507fe78cee2b">监考安排</a></li>
					</ul>
				</div>
			</div>
			<div data-options="iconCls:'tu0625'" title="教室管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="classroom/classroomNoUse.jsp" id="2012120315420426562501c03cd9fab">可用教室</a></li>
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="classroom/classroomAll.jsp" id="2012120315424664062507fe78cee2b">全部教室使用信息</a></li>
					</ul>
				</div>
			</div>
			<div data-options="iconCls:'tu0625'" title="日志管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="logger/logger.jsp" id="2012120315420426562501c03cd9fab">系统操作记录</a></li>
					</ul>
				</div>
			</div>
			<div data-options="iconCls:'tu0504'" title="权限管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="systemmanager/SysPerson.jsp" id="2012120315420426562501c03cd9fab">用户管理</a></li>
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="systemmanager/SysRole.jsp" id="2012120315420426562501c03cd9fab">角色管理</a></li>
					</ul>
				</div>
			</div>
			<div data-options="iconCls:'tu0625'" title="排课管理">
				<div class="easyui-panel" fit="true" border="false">
					<ul class="easyui-tree">
						<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="examSchedule/course.jsp" id="2012120315420426562501c03cd9fab">课程管理</a></li>
							<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="examSchedule/courseBook.jsp" id="2012120315420426562501c03cd9fab">课程教材管理</a></li>
							<li data-options="iconCls:'tu1001'"><a href="#" icon="tu1001"
							rel="examSchedule/schedule.jsp" id="2012120315420426562501c03cd9fab">手动排课</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden;">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
	</div>
	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
	</div>
	<div id="myWindow"></div>
	<div id="myWindowC"></div>

</body>
</html>
