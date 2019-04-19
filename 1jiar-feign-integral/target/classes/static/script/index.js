$(function(){
    MembershipPoint();
})




//查看积分
function MembershipPoint(){
    $('#MembershipPoint').bootstrapTable({
        toolbar:'#toolbar',
        url:'/QueryMembershipPoint',//获取数据地址
        type:'post',
        columns:[
            {checkbox:true},
            {field:'dlrIdId',title:'ID'},
            {field:'loimg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'userName',title:'用户名'},
            {field:'integralAdd',title:'剩余积分'},
            {field:'houseId',title:'用户id'},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:record('+row.houseId+');">查看抽奖记录</a>-<a href="javascript:updatebookbyid('+row.houseId+');">抽奖</a>'
                }}
        ]
    });
}

//查询抽奖级别
function inittypee() {
    $.ajax({
        url: '/typelist',
        type: 'post',
        async: false,
        data: {},
        dataType: 'json',
        success: function (data) {
            var html = '<option value="-1" >请选择</option>';
            for (var i = 0; i < data.length; i++) {
                html += '<option value=' + data[i].dltypeid + ' >' + data[i].dltypeName + '</option>';
            }
            $("#prizeTypeid").html(html);
        }
    });
}
//回显
    function updatebookbyid(houseId){
        //打开修改弹框
        openAddDlrld();
        //初始化表单数据
        inittypee();
        //查询回显数据
        $.ajax({
            url:'/querydlrldId',
            type:'post',
            async:false,//同步
            data:{houseId:houseId},
            dataType:'json',
            success:function(data) {
                $("#prizeTypeid").val(data.prizeTypeid);
                $("#dlrIdId").val(data.dlrIdId);
                $("#integralAdd").val(data.integralAdd);
                $("#houseId").val(data.houseId);
                $("#dlrldtyId").val(data.dlrldtyId);
                //$(".chosen-select").val($("#type").val());
            }
        })
    }

//抽奖
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

    function openAddDlrld(){
        bootbox.dialog({
            title:'抽奖',
            message: createAddContent("/choujiang"),
            closeButton: true,
            buttons : {
                "success" : {
                    "label" : "<i class='icon-ok'></i> 保存",
                    "className" : "btn-sm btn-success",
                    "callback" : function() {
                        $.ajax({
                            url:'/saveDlrldBean',
                            type:'post',
                            data:$("#upupform").serialize(),
                            dataType:'json',
                            success:function(data){
                                if(data){
                                        MembershipPoint();
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
                            MembershipPoint();
                    }
                }
            }

        });
    }



//查看抽奖记录
function record(houseId){
    $('#DlrldHistoryTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'/queryDlrld?houseId='+houseId,//获取数据地址
        type:'get',
        data:{
        },
        columns:[
            {checkbox:true},
            {field:'dlrIdId',title:'ID'},
            {field:'loimg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'userName',title:'用户名'},
            {field:'integralAdd',title:'剩余积分'},
            {field:'houseId',title:'用户id'},
            {field:'dltyname',title:'抽奖级别'},
            {field:'dley',title:'抽奖所用积分'},
            {field:'tame',title:'抽奖时间'},
            {field:'dllname',title:'奖品'},
            {field:'stateId',title:'状体',formatter:function(value,row,index){
                if(value==1){
                    return "未领取";
                }
                    if(value==2){
                        return "领取";
                    }
                    if(value==3){
                        return "放弃";
                    }
                }},
            {field:'awardImg',title:'产品图片',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.id+');">领取</a>-<a href="javascript:updatebookbyid('+row.id+');">放弃</a>'
                }}
        ]
    });
}
