<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <jsp:include page="common.jsp" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/gray/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script src="easyui/jquery.min.js"></script>
    <script src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="top" style="margin-top: 20px;">
            <div class="top-left col-xs-5">
                <label class="label" style="color: #87CEEB;font-weight: bold;font-size: 20px;">
                    电影租赁系统
                </label>
            </div>
            <div class="col-xs-2">
                <button type="button" id="listShowBtn" class="btn btn-info">显示列表</button>
            </div>
            <div class="top-right col-xs-3 col-xs-offset-2">
                <label class="label" style="color: #87CEEB;font-weight: bold;font-size: 20px;">
                    欢迎：<%=request.getSession().getAttribute("loginUser")%>
                </label>
            </div>
        </div>
    </div>
    <div style="height: 300px">
        <table id="listFilmGrid" class="table">
            <div id="filmDialog"></div>
            <div id="editDialog"></div>
        </table>
    </div>


</body>
<script>
    $(function () {
        $("#listShowBtn").click(function () {

            $("#listFilmGrid").datagrid({
                title:'电影展示列表',
                rownumbers:true,
                striped:true,
                fit:true,
                pagination:true,
                url:'listShow.do',
                columns:[[
                    {field:'filmId',title:'电影ID',width:150,align:'center'},
                    {field:'title',title:'电影名称',width:150,align:'center'},
                    {field:'description',title:'电影描述',width:700,align:'center'},
                    {field:'lanuageName',title:'语言',width:150,align:'center'}
                ]],
                toolbar:[
                    {
                        text:'新建',
                        iconCls:'icon-add',
                        onClick:function(){
                            $('#filmDialog').dialog({
                                title:'新建',
                                width:600,
                                height:350,
                                href:'filmAdd.jsp',
                                buttons:[
                                    {
                                        text:'提交',
                                        iconCls:'icon-ok',
                                        onClick:function(){
                                            $('#filmForm').form('submit',{
                                                success:function(){
                                                    $.messager.show({
                                                        msg:'保存成功'
                                                    });

                                                    $('#filmDialog').dialog('close');

                                                    $('#listFilmGrid').datagrid('load');
                                                }
                                            });
                                        }
                                    },
                                    {
                                        text:'取消',
                                        iconCls:'icon-cancel',
                                        onClick:function(){
                                            $('#filmDialog').dialog('close') ;
                                        }
                                    }
                                ]
                            });
                        }
                    },{
                        iconCls:'icon-remove',
                        text:'删除',
                        onClick:function () {
                            var selectedRow = $("#listFilmGrid").datagrid("getSelected");
                            if(selectedRow == null){
                                $.messager.alert('提示消息','请选择数据');
                                return;
                            }else{
                                var filmId = selectedRow.filmId;
                                $.ajax({
                                    url:'/deleteFilm.do',
                                    type:'POST',
                                    dataType:'json',
                                    data:{"id":JSON.stringify(filmId)},
                                    success:function(e) {
                                        if (e == 1) {
                                            $.messager.show({
                                                msg: '删除成功'
                                            });
                                        } else {
                                            $.messager.show({msg: '删除失败'});
                                        }
                                        $('#listFilmGrid').datagrid('load');
                                    }
                                });
                            }
                        }
                    },{
                        iconCls:'icon-edit',
                        text:'修改',
                        onClick:function () {
                            var row = $("#listFilmGrid").datagrid("getSelected");
                            if (row == null) {
                                $.messager.alert('提示消息','请选择数据');
                                return ;
                            }
                            var filmId = row.filmId;
                            $("#editDialog").dialog({
                                title:'编辑电影信息',
                                width:600,
                                height:350,
                                href:'editFilm.jsp?filmId='+filmId,
                                buttons:[
                                    {
                                        text:'提交',
                                        iconCls:'icon-ok',
                                        onClick:function(){
                                            $('#editForm').form('submit',{
                                                success:function(e) {
                                                    if (e == 1) {
                                                        $.messager.show({
                                                            msg: '修改成功'
                                                        });
                                                    } else {
                                                        $.messager.show({msg: '修改失败'});
                                                    }
                                                    $('#editDialog').dialog('close');
                                                    $('#listFilmGrid').datagrid('load');
                                                }
                                            });
                                        }
                                    },
                                    {
                                        text:'取消',
                                        iconCls:'icon-cancel',
                                        onClick:function(){
                                            $('#editDialog').dialog('close') ;
                                        }
                                    }
                                ]

                            });
                        }

                    }
                ]
            },'json');
        });
    });

</script>
</html>
