$(function(){
    initbooklist();
})

function initbooklist(){
    $('#bookTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'../qureyResume',
        type:'post',
        columns:[

            {field:'home'},
            {field:'inven'},
            {field:'calen'},
            {field:'feny'},
            {field:'owners'},
            {field:'broker'},
            {field:'record'},
            {field:'entrust'},
            {field:'search'},
            {field:'quest'},
            {field:'consult'},

            {field:'123',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.id+');">删除</a>-<a href="javascript:updatebookbyid('+row.id+');">修改</a>'
                }}
        ]
    });
}