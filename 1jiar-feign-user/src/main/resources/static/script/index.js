$(function(){
    initbooklist();
})

function initbooklist(){
    $('#bookTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'../qureyResume',
        type:'post',
        columns:[

            {field:'name'},
            {field:'jiaxidname'},
            {field:'xingb'},
            {field:'aihao'},
            {field:'jiaoyidname'},
            {field:'hengyidname'},
            {field:'shuozaiidname'},


            {field:'123',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.id+');">删除</a>-<a href="javascript:updatebookbyid('+row.id+');">修改</a>'
                }}
        ]
    });
}