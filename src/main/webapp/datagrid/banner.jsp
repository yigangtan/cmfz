<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

    <script type="text/javascript">
        $(function(){
            //将id为addDg的元素转化为dialog控件
            $("#addDg").dialog({
                title: '添加轮播图',
                width: 300,
                closed: true,
                buttons:[{
                    text:'保存',
                    handler:function(){
                        $("#addForm").form("submit",{
                            url:"${pageContext.request.contextPath}/viewpager/add.do",
                            success: function(reslut){
                                alert(reslut);
                            }
                        })
                    }
                },{
                    text:'关闭',
                    handler:function(){
                        $("#addDg").dialog("close")
                    }
                }],
            });
            //将id为addDg的元素转化为dialog控件----END----

            //form表单控件
            $("#addForm").form({});
            //form表达控件----END----

            //alert(1);
            $('#dg').edatagrid({
                url:'${pageContext.request.contextPath}/viewpager/selectAll.do',
                pagination:true,
                pageSize:3,
                pageList:[
                    3,6,9
                ],
                columns:[[
                    {field:'id',title:'',width:20},
                    {field:'title',title:'名字',width:100},
                    {field:'status',title:'状态',width:100,editor:{
                        type:"text",
                        options:{
                            required:true,
                        }
                        }},
                    {field:'desc',title:'描述',width:100},
                ]],
                fit:true,
                fitColumns:true,
                toolbar: [
                {
                    text:"添加",
                    iconCls: 'icon-edit',
                    handler: function(){
                        $("#addDg").dialog("open")
                    }
                },'-',
                {
                    text:"修改",
                    iconCls: 'icon-help',
                    handler: function(){
                        //修改选中行
                        var row=$('#dg').edatagrid("getSelected");
                        if(row==null){
                            $.messager.show({
                                title:'警告',
                                msg:'请先选择要操作的行。',
                                showType:'show',
                                style:{
                                    right:'',
                                    top:document.body.scrollTop+document.documentElement.scrollTop,
                                    bottom:''
                                }
                            });
                        }
                        else{
                            //将当前行编程课编辑模式
                            var index=$('#dg').edatagrid("getRowIndex",row);
                            $('#dg').edatagrid("editRow",index);
                        }
                    }
                },'-',
                {
                    text:"删除",
                    iconCls: 'icon-help',
                    handler: function(){
                        var row=$('#dg').edatagrid("getSelected");
                        $.ajax({
                            url:"${pageContext.request.contextPath}/viewpager/delete.do",
                            type:"post",
                            data:'id='+row.id,
                            success:function(result){
                                if(result){
                                    alert("删除成功！");
                                    $("#dg").edatagrid("load");
                                }else{
                                    alert("删除失败");
                                }
                            },
                            dataType:"json"
                        })
                    }
                },'-',
                {
                    text:"保存",
                    iconCls: 'icon-help',
                    handler: function(){
                        var row=$('#dg').edatagrid("getSelected");
                        $('#dg').edatagrid("saveRow");

                        $.ajax({
                            url:"${pageContext.request.contextPath}/viewpager/update.do",
                            type:"post",
                            data:'id='+row.id+'&status='+row.status,
                            success:function(result){
                                if(result){
                                    alert("修改成功！");
                                    $("#dg").edatagrid("load");
                                }else{
                                    alert("修改失败");
                                }
                            },
                            dataType:"json"
                        })
                    }
                }],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>时间: ' + rowData.date + '</p>' +
                        '<p>描述: ' + rowData.desc + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
        })

    </script>

    <table id="dg"></table>
    <div id="addDg">
        <form id="addForm" method="post" enctype="multipart/form-data">
            图片名称：<input name="title"><br/>
            图片简介：<input name="desc"><br/>
            图片地址：<input name="myImg" type="file"><br/>
            图片状态：<input type="radio" name="status" value="0">展示<input type="radio" name="type" value="1">不展示<br/>
        </form>
    </div>
