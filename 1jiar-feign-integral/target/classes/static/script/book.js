<<<<<<< HEAD
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
=======
var arrdlrldtype = [];
function initbooklist(){
    var prizeTypeid = $('#prizeTypeid').val();
    $.ajax({
        url:'/queryprize',
        type:'post',
        data:{
            dltypeid:prizeTypeid,
        },
        success:function(data){
            var html='<tr>';
            for (var i = 1; i < data.length+1; i++) {
                arrdlrldtype.push(data[i-1].dlrldtyId);
                html+="<td><div  width='300' height='300'><div  width='100' height='70' id="+data[i-1].dlrldtyId+" style=\"margin: 0px 0px 0px 0px\"><img  style=\"margin: 5px 5px 5px 5px\" class='asss' src="+data[i-1].awardImg+" width=\'90\' height=\'60\'><br>"+
                    "<div  style=\"margin: 0px 0px 0px 0px\">"+data[i-1].dlrldName+"</div></div></div></td>";
                if (i==4){
                    html+="<td><a href='javascript:initsuiji();' ><img   src=''  width='100' height='70'></img></a></td>";
                }
                if (i==3){
                    html+="</tr><tr>";
                }
                if (i==5){
                    html+="</tr><tr>";
                }
            }
        }
    })
}
var k=0;
function initsuiji() {
        var intervalID = setInterval(sum, 100);
}

var num =0;
function sum (){
    k+=1;
    if (k===13){
        alert(arrdlrldtype[num]);
        k=0;
    }
    num = Math.floor(Math.random()*(8 - 1) + 1);
    for (var j=1;j<9 ;j++){
        if (j==num){
            $("#"+arrdlrldtype[num]).css({"background-color":"#ffff00"});
        }else{
            $("#"+arrdlrldtype[j]).css({"background-color":""});
        }
    }
}
>>>>>>> f4279993763febc7556e25320e911184c3ff1b9a
