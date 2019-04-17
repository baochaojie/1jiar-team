$(function(){
    MembershipPoint();
    inittypee();
})




//查看积分
function MembershipPoint(){
    $('#MembershipPoint').bootstrapTable({
        toolbar:'#toolbar',
        url:'/QueryMembershipPoint',//获取数据地址
        type:'post',
        columns:[
            {checkbox:true},
            {field:'awardImg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'dlrIdId',title:'ID'},
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
    alert(houseId);
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
                $("#dlrIdId").val(data.dlrIdId);
                $("#prizeTypeid").val(data.prizeTypeid);
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
                            url:'/saveprize',
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
            {field:'awardImg',title:'用户头像',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'dlrIdId',title:'ID'},
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
/*
function initTree(){
    $.ajax({
        url:'/typelist',
        type:'post',
        data:{},
        dataType:'json',
        success:function(data){
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html+="<div class='ass' width='200' height='300'><div  style=\"margin: 20px 0px 0px 100px\"><a  href='javascript:typrid("+data[i].id+")' style=\" color:#666; font-size:40px;\" >"+data[i].text+"</a></div></div><br>";
            }
            html+="<br>";
            $("#myTree").html(html);
        }
    })
}
function productionlist(){
    $.ajax({
        url:'/productionlist',
        type:'post',
        data:{},
        dataType:'json',
        success:function(data){
            var html = "";
            for (var i = 0; i < data.length; i++) {
               html+="<div class='asss'  width='200' height='300'><div  style=\"margin: 20px 0px 0px 100px\"><a href='javascript:productionbyid("+data[i].id+")'  style=\" color:#666; font-size:40px;\" >"+data[i].text+"</a></div></div><br>";
            }
            html+="<div class='ass'  width='200' height='300'><div  style=\"margin: 20px 0px 0px 60px\"><a href='javascript:initlist()'  style=\" color:#666; font-size:40px;\" >查询全部</a></div></div>"
            $("#myTreeto").html(html);
        }
    })
}
function typrid(id) {
    $("#typeidbyid").val(id);
    initbooklist();
}
function productionbyid(id) {
    $("#productionidbyid").val(id);
    initbooklist();
}
function initlist() {
    $("#productionidbyid").val(null);
    $("#typeidbyid").val(null);
    initbooklist();
}
initbooklist();
function initbooklist(){
    var typeid = $('#typeidbyid').val();
    var productionid = $('#productionidbyid').val();
    $.ajax({
        url:'/booklist',
        type:'post',
        data:{
            typeid:typeid,
            productionid:productionid
        },
        success:function(data){
            var html='<tr>';
            var int = 1;
            for (var i = 0; i < data.length; i++) {
                html+="<td><div  width='370' height='400'><div  style=\"margin: 0px 0px 0px 50px\"><img class='asss' src=../"+data[i].img+" width=\'320\' height=\'340\'><br>"+
                "<div  style=\"margin: 0px 0px 0px 120px\">商品名称："+data[i].name+"<br>"+
                "商品类型："+data[i].typeidname+"<br>"+
                "商品产地："+data[i].productionidname+"</div></div></div></td>";
                if (int%4==0){
                    html+="</tr><tr>";
                }
                int++;
            }
            $("#bookTable").html(html);
        }
    })
}*/
/*
initbooklist();
function initbooklist(){
    $('#bookTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'booklist',//获取数据地址
        clickToSelect: true, //是否启用点击选中行
        queryParams:function(){
            return {
            }
        },
        columns:[
            {checkbox:true},
            {field:'id',title:'ID'},
            {field:'name',title:'图书名称'},
            {field:'typeidname',title:'图书类型'},
            {field:'productionidname',title:'出版地区'},
            {field:'img',title:'图书封面',formatter:function(data){
                    return "<img src=../"+data+" width='50' height='50'>";
                }},
            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.id+');">加入购物车</a>'
                }}
        ]
    });
}*/

