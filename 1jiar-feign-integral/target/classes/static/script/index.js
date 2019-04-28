$(function(){
    MembershipPoint();
    initBookTable();
})




//查看积分
var houseId = 0;
var integralAdd = 0;
function MembershipPoint(){
    $('#MembershipPoint').bootstrapTable({
        toolbar:'#toolbar',
        url:'/QueryMembershipPoint',//获取数据地址
        type:'post',
        columns:[
            {field:'loimg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'userName',title:'用户名'},
            {field:'integralAdd',title:'剩余积分'},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:record();">查看抽奖记录</a>'


                }}
        ]
    });
}

//抽奖页面  用户Id 和 积分
function updatebookbyid(){
   location.href="/choujiangym";
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
 /*   function updatebookbyid(houseId){
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
*/
//抽奖


/*function openAddDlrld(){
    bootbox.dialog({
    title:'添加商品',
        message: createAddContent("/choujiangym"),
        closeButton: true,
})

}*/

//查看抽奖记录
function record(){
    houseId=2;
    $('#DlrldHistoryTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'/queryDlrld?houseId='+houseId,//获取数据地址
        type:'get',
        data:{
        },
        columns:[
            {field:'loimg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'userName',title:'用户名'},
            {field:'integralAdd',title:'剩余积分'},
            {field:'dltyname',title:'抽奖级别'},
            {field:'tame',title:'抽奖时间'},
            {field:'dllname',title:'奖品'},
            {field:'stateId',title:'状体',formatter:function(value,row,index){
                if(value==1){
                    return "未领取";
                }else if(value==2){
                        return "领取";
                }else if(value==3){
                        return "放弃";
                    }
                }},
            {field:'awardImg',title:'产品图片',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'123',title:'操作',formatter:function(value,row,index){
                if(row.stateId==1){
                    return '<a href="javascript:lingqu('+row.dlrIdId+','+row.houseId+');">领取</a><a href="javascript:fangqi('+row.dlrIdId+','+row.houseId+');">放弃</a>';
                }else{
                    return "";
                }
                }
            }
        ]
    });
}

//后台记录
function searchUser(){
    $('#DlrldHistoryTable2').bootstrapTable('refresh');
}

function initBookTable(){
    $('#DlrldHistoryTable2').bootstrapTable({
        toolbar:'#toolbar',
        url:"/queryDlrldht",
        dataType:"json",
        type:"post",
        pagination:true, //是否展示分页
        pageList:[3, 10, 20, 50],//分页组件
        pageNumber:1,
        pageSize:3,//默认每页条数
        sidePagination:'server',//分页方式：client客户端分页，server服务端分页
        striped:true,//显示条纹状表格
        queryParams:function(){
            var userName = $("#userName").val();
            return {
                page:this.pageNumber,
                rows:this.pageSize,
                userName:userName,
            }
        },
        columns:[
            {field:'loimg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'userName',title:'用户名'},
            {field:'integralAdd',title:'剩余积分'},
            {field:'dltyname',title:'抽奖级别'},
            {field:'takeTime',title:'抽奖时间'},
            {field:'dllname',title:'奖品'},
            {field:'stateId',title:'状体',formatter:function(value,row,index){
                    if(value==1){
                        return "未领取";
                    }else if(value==2){
                        return "领取";
                    }else if(value==3){
                        return "放弃";
                    }
                }},
            {field:'awardImg',title:'产品图片',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    if(row.stateId==1){
                        return '<a href="javascript:lingqu('+row.dlrIdId+','+row.houseId+');">领取</a><a href="javascript:fangqi('+row.dlrIdId+','+row.houseId+');">放弃</a>';
                    }else{
                        return "";
                    }
                }
            }
        ]
    })
}
   //领取
    function lingqu(dlrIdId,houseId){
        $.ajax({
            url:'lingquTyped',
            type:'post',
            data:{
                dlrIdId:dlrIdId,
                houseId:houseId
            },
            success:function (data) {
                if(data){
                    toastr.success("领取成功!");
                    record();
                }
            }
        })
    }


//放弃
function fangqi(dlrIdId,houseId){
    $.ajax({
        url:'fangqiTyped',
        type:'post',
        data:{
            dlrIdId:dlrIdId,
            houseId:houseId
        },
        success:function (data) {
            if(data){
                toastr.success("您已放弃");
                record();
            }
        }
    })
}