//
//     initbooklist();
// function initbooklist(){
//     $('#bookTable').bootstrapTable({
//         toolbar:'#toolbar',
//         url:'queryDlrld',//获取数据地址
//         clickToSelect: true, //是否启用点击选中行
//         queryParams:function(){
//             return {
//             }
//         },
//         columns:[
//             {checkbox:true},
//             {field:'dlrIdId',title:'ID'},
//             {field:'integralAdd',title:'剩余积分'},
//             {field:'houseId',title:'用户id'},
//             {field:'dltyname',title:'抽奖级别'},
//             {field:'dley',title:'抽奖所用积分'},
//             {field:'tame',title:'抽奖时间'},
//             {field:'dllname',title:'奖品'},
//             {field:'awardImg',title:'图书封面',formatter:function(data){
//                     return "<img src="+data+" width='50' height='50'>";
//                 }},
//             {field:'123',title:'操作',formatter:function(value,row,index){
//                     return '<a href="javascript:shanchu('+row.id+');">删除</a>-<a href="javascript:updatebookbyid('+row.id+');">修改</a>'
//                 }}
//         ]
//     });
// }
// function tiaojianchaxun(){
//     $('#bookTable').bootstrapTable('refresh');
// }