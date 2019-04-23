
$(function(){
    inittype();
    queryprize2();
})
function tiaojianchaxun(){
    $('#prizeTable').bootstrapTable('refresh');
}
//查看奖品
function  queryprize2(){
    $('#prizeTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'/queryprize2',//获取数据地址
        type:'post',
        columns:[
            {checkbox:true},
            {field:'dlrldtyId',title:'ID'},
            {field:'integName',title:'奖品级别'},
            {field:'dlrldName',title:'奖品类型'},
            {field:'awardImg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.dlrldtyId+');">删除</a>'
                }}
        ]
    });
}
//+<a href="javascript:xuigaitype('+row.dlrldtyId+');">修改</a>

//回显
function xuigaitype(dlrldtyId){
    //打开修改弹框
    openAdd();
    //初始化表单数据
    inittype();
    //查询回显数据
    $.ajax({
        url:'/saveprize',
        type:'post',
        async:false,//同步
        data:{dlrldtyId:dlrldtyId},
        dataType:'json',
        success:function(data) {
            $("#prizeId").val(data.prizeId);
            $("#dlrldName").val(data.dlrldName);
            $("#headImg").val(data.headImg);
        }
    })
}

//单删
function shanchu(ids){
    $.ajax({
        url:'/deleteTyped',
        type:'post',
        data:{
            ids:ids
        },
        success:function(data){
            if (data) {
                toastr.success("删除成功!");
                tiaojianchaxun();
            }
        }
    })
}

    //查询抽奖级别
    function inittype(){
        $.ajax({
            url:'/typelist',
            type:'post',
            async:false,
            data:{},
            dataType:'json',
            success:function(data){
                var html='<option value="-1" >请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html+='<option value='+data[i].dltypeid+' >'+data[i].dltypeName+'</option>';
                }
                $("#prizeId").html(html);
            }
        });
    }




//新增

var res;
function createAddContent(url){
    $.ajax({
        url:url,
        async:false,
        success:function(data){
            res = data;
        }
    });
    return res;
}

function openAdd(){
    bootbox.dialog({
        title:'添加商品',
        message: createAddContent("/prize"),
        closeButton: true,
        buttons : {
            "success" : {
                "label" : "<i class='icon-ok'></i> 保存",
                "className" : "btn-sm btn-success",
                "callback" : function() {
                    $.ajax({
                        url:'/saveprize',
                        type:'post',
                        data:$("#addbookform").serialize(),
                        dataType:'json',
                        success:function(data){
                            if(data){
                                tiaojianchaxun();
                            }else{
                                bootbox.alert({
                                    size: "small",
                                    title: "提示",
                                    message: "新增失败！",
                                    buttons: {
                                        ok: {
                                            label: '确定',
                                            className: 'btn-success'
                                        }
                                    }
                                })
                            }}
                    });
                }
            },
            "cancel" : {
                "label" : "<i class='icon-info'></i> 取消",
                "className" : "btn-sm btn-danger",
                "callback" : function() {

                }
            }
        }

    });
}

