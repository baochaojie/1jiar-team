$(function(){
    initbooklist();
})

function initbooklist(){
    alert("1")
    $('#bookTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'../qureyResume',//获取数据地址
        type:'post',
        columns:[
            {checkbox:true},
            {field:'id',title:'ID'},
            {field:'home',title:'剩余积分'},
            {field:'inven',title:'用户id'},
            {field:'calen',title:'抽奖级别'},
            {field:'feny',title:'剩余积分'},
            {field:'owners',title:'用户id'},
            {field:'broker',title:'抽奖级别'},
            {field:'record',title:'剩余积分'},
            {field:'entrust',title:'抽奖级别'},
            {field:'search',title:'剩余积分'},
            {field:'quest',title:'用户id'},
            {field:'consult',title:'抽奖级别'},

            {field:'123',title:'操作',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.id+');">删除</a>-<a href="javascript:updatebookbyid('+row.id+');">修改</a>'
                }}
        ]
    });
}