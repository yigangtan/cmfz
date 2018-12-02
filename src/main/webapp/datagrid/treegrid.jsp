<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<script type="text/javascript">
    $(function(){
        $('#chapter_tg').treegrid({
            url:'${pageContext.request.contextPath}/chapter/selectAll.do',
            idField:'id',
            treeField:'title',
            columns:[[
                {field:'title',title:'名字'},
                {field:'duwnPath',title:'下载路径'},
                {field:'size',title:'章节大小'},
                {field:'duration',title:'章节时长'},
            ]],
            fitColumns:true,
            fit:true,
            toolbar: [{
                text:"专辑详情",
                iconCls: 'icon-edit',
                handler: function(){

                    var row=$("#chapter_tg").treegrid("getSelected");
                    if(row==null){
                        alert("请先选中专辑")
                    }else{
                        if(row.count==null){
                            alert("请先选中专辑")
                        }else{
                            $("#chapter_ff").form("load",row);
                            $("#coverImg").prop("src","${pageContext.request.contextPath}/img/"+row.coverImg);
                            $('#album').dialog("open");
                        }
                    }
                }
            },'-',{
                text:"添加专辑",
                iconCls: 'icon-help',
                handler: function(){
                    $("#chapter_add").dialog("open");
                }
            },'-',{
                text:"添加章节",
                iconCls: 'icon-help',
                handler: function(){
                    var row=$("#chapter_tg").treegrid("getSelected");
                    if(row==null){
                        alert("请先选中专辑")
                    }else{
                        if(row.count==null){
                            alert("请先选中专辑")
                        }else{
                            $("#p_id").prop("value",row.id);
                            alert(row.id);
                            $('#chapter_dd').dialog("open");
                        }
                    }
                }
            },'-',{
                text:"下载音频",
                iconCls: 'icon-help',
                handler: function(){
                    var row=$("#chapter_tg").treegrid("getSelected");
                    if(row==null){
                        alert("请先选中章节")
                    }else{
                        if(row.count!=null){
                            alert("请先选中章节")
                        }else{
                            //alert("下载");
                            location.href="${pageContext.request.contextPath}/chapter/download?url="+row.duwnPath+"&title="+row.title;
                        }
                    }
                }
            }],
            onDblClickRow:function(row){
                $('#audio').dialog("open");
                $("#audio_id").prop("src","${pageContext.request.contextPath}/upload/"+row.duwnPath)
            }
        });
        $('#album').dialog({
            title: '专辑详情',
            width: 400,
            height: 200,
            closed: true,
        });
        $('#audio').dialog({
            title: '播放',
            width: 400,
            height: 200,
            closed: true,
        });
        $('#chapter_ff').form();

        $('#chapter_dd').dialog({
            title: '添加章节',
            width: 400,
            height: 200,
            closed: true,
            buttons:[{
                text:'保存',
                iconCls:'icon-edit',
                handler:function(){
                    $('#chapter_fl').form("submit",{
                        url:"${pageContext.request.contextPath}/chapter/add",
                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-help',
                handler:function(){
                    $('#chapter_dd').dialog("close");
                }
            }],
        });
        $('#chapter_fl').form();
        //将id为addDg的元素转化为dialog控件
        $("#chapter_add").dialog({
            title: '添加专辑',
            width: 300,
            closed: true,
            buttons:[{
                text:'保存',
                handler:function(){
                    console.info("11111111");
                    audioSubmit()
                }
            },{
                text:'关闭',
                handler:function(){
                    $("#chapter_add").dialog("close")
                }
            }],
        });
        //将id为addDg的元素转化为dialog控件----END----
        //form表单控件
        // $("#chapter_fa").form();
        //form表达控件----END----

        function audioSubmit() {
           // ajax
        }
    })

</script>

<table id="chapter_tg"></table>
<div id="album">
    <form id="chapter_ff" method="post">
        <div>
            专辑名称：<input class="easyui-validatebox" type="text" name="title" data-options="required:true" />
        </div>
        <div>
            专辑作者：<input class="easyui-validatebox" type="text" name="author" data-options="required:true" />
        </div>
        <div>
            专辑简介：<input class="easyui-validatebox" type="text" name="desc" data-options="required:true" />
        </div>
        <div>
            <img src="" id="coverImg">
        </div>
    </form>
</div>

<div id="chapter_dd">
    <form id="chapter_fl" method="post" enctype="multipart/form-data">
        <div>
            章节名称：<input id="name" class="easyui-validatebox" type="text" name="title" data-options="required:true" />
        </div>
        <div>
            <input type="file" name="chapter">
        </div>
        <div>
            <input type="hidden" name="id" value="" id="p_id">
        </div>
    </form>
</div>

<div id="chapter_add">
    <from id="chapter_fa" method="post" enctype="multipart/form-data">
        专辑标题：<input class="easyui-validatebox" type="text" name="title"><br/>
        章节数：<input class="easyui-validatebox" type="text" name="count"><br/>
        评分：<input class="easyui-validatebox" type="text" name="score"><br/>
        作者：<input class="easyui-validatebox" type="text" name="author"><br/>
        播音：<input class="easyui-validatebox" type="text" name="broadCast"><br/>
        简介：<input class="easyui-validatebox" type="text" name="desc"><br/>
        封面：<input type="file" name="myImg">

    </from>
</div>

<div id="audio">
    <audio id="audio_id" src="" autoplay="autoplay" controls="controls" loop="loop"></audio>
</div>