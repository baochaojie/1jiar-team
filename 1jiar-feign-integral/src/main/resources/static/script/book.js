

$(function(){
    initbooklist();
})

//验证用户是否登入
function  inituser(){
    $.ajax({
        url:"/inituser",
        type:"post",
        xhrFields: {
            withCredentials: true
        },
        success:function(data){
            if (data) {
                window.location.href="http://localhost:8773/page/quangbu?url=loginsj";
            }else{
                initsuiji();
            }
            }
    })
}

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


function openAddDlrld() {
    bootbox.dialog({
        title: '历史纪录',
        message: createAddContent("/booklist"),
        closeButton: true,
    })
}


//查询奖品 redis
var arrdlrldtype = [];
function initbooklist(){
    $.ajax({
        url:'/queryprize',
        type:'post',
        data:{
            dltypeid:1,
        },
        success:function(data){
            arrdlrldtype = [];
            var html='<tr>';
            for (var i = 1; i < data.length+1; i++) {
                arrdlrldtype.push(data[i-1].dlrldtyId);
                html+="<td><div  width='300' height='300' style='width:120px; height:100px;background-color:#b9c8bf'><div  width='100' height='70' id="+data[i-1].dlrldtyId+" style=\"margin: 0px 0px 0px 0px\"><img  style=\"margin: 8px 8px 8px 8px\" class='asss' src="+data[i-1].awardImg+" width=\'90\' height=\'60\'><br>"+
                    "<div  style=\"margin: 0px 0px 0px 0px\">"+data[i-1].dlrldName+"</div></div></div></td>";
                if (i==4){
                    html+="<td><div style='width:120px; height:100px;background-color:#ff0000'><a href='javascript:inituser();' ><img  src='http://tableimg.oss-cn-beijing.aliyuncs.com/tableimg/1555723931320.png' style=\"margin: 13px 8px 8px 8px\" width='100' height='70'></img></a></div></td>";
                }
                if (i==3){
                    html+="</tr><tr>";
                }
                if (i==5){
                    html+="</tr><tr>";
                }
            }
            $("#prizesuiji").html(html);
            $("#prizeTypeid").val(1);
        }
    })
}
function initbooklist2(){
    $.ajax({
        url:'/queryprize',
        type:'post',
        data:{
            dltypeid:2,
        },
        success:function(data){
            arrdlrldtype = [];
            var html='<tr>';
            for (var i = 1; i < data.length+1; i++) {
                arrdlrldtype.push(data[i-1].dlrldtyId);
                html+="<td><div  width='300' height='300' style='width:120px; height:100px;background-color:#b9c8bf'><div  width='100' height='70' id="+data[i-1].dlrldtyId+" style=\"margin: 0px 0px 0px 0px\"><img  style=\"margin: 8px 8px 8px 8px\" class='asss' src="+data[i-1].awardImg+" width=\'90\' height=\'60\'><br>"+
                    "<div  style=\"margin: 0px 0px 0px 0px\">"+data[i-1].dlrldName+"</div></div></div></td>";
                if (i==4){
                    html+="<td><div style='width:120px; height:100px;background-color:#ff0000'><a href='javascript:inituser();' ><img  src='http://tableimg.oss-cn-beijing.aliyuncs.com/tableimg/1555723931320.png'style=\"margin: 13px 8px 8px 8px\"  width='100' height='70'></img></a></div></td>";
                }
                if (i==3){
                    html+="</tr><tr>";
                }
                if (i==5){
                    html+="</tr><tr>";
                }
            }
            $("#prizesuiji").html(html);
            $("#prizeTypeid").val(2);
        }
    })
}
function initbooklist3(){
    $.ajax({
        url:'/queryprize',
        type:'post',
        data:{
            dltypeid:3,
        },
        success:function(data){
            arrdlrldtype = [];
            var html='<tr>';
            for (var i = 1; i < data.length+1; i++) {
                arrdlrldtype.push(data[i-1].dlrldtyId);
                html+="<td><div  width='300' height='300' style='width:120px; height:100px;background-color:#b9c8bf'><div  width='100' height='70' id="+data[i-1].dlrldtyId+" style=\"margin: 0px 0px 0px 0px\"><img  style=\"margin: 8px 8px 8px 8px\" class='asss' src="+data[i-1].awardImg+" width=\'90\' height=\'60\'><br>"+
                    "<div  style=\"margin: 0px 0px 0px 0px\">"+data[i-1].dlrldName+"</div></div></div></td></td>";
                if (i==4){
                    html+="<td><div style='width:120px; height:100px;background-color:#ff0000'><a href='javascript:inituser();' ><img  src='http://tableimg.oss-cn-beijing.aliyuncs.com/tableimg/1555723931320.png' style=\"margin: 13px 8px 8px 8px\" width='100' height='70'></img></a></div></td>";
                }
                if (i==3){
                    html+="</tr><tr>";
                }
                if (i==5){
                    html+="</tr><tr>";
                }
            }
            $("#prizesuiji").html(html);
            $("#prizeTypeid").val(3);
        }
    })
}
var intervalID ;
var k=0;
function initsuiji() {
    intervalID = setInterval(sum, 100);
}

var num =0;
function sum (data){
    num = Math.floor(Math.random()*(8 - 1) + 1);
    for (var j=1;j<9 ;j++){
        if (j==num){
            $("#"+arrdlrldtype[num]).css({"background-color":"#ffff00"});
        }else{
            $("#"+arrdlrldtype[j]).css({"background-color":""});
        }
    }
    k+=1;
    if (k==13){
        $("#dlrldtyId").val(arrdlrldtype[num]);
        clearInterval(intervalID);
            $.ajax({
                url:'/saveDlrldBean?data='+data,
                type:'post',
                data:$("#upupform").serialize(),
                dataType:'json',
                success:function(data){
                    if(data!=1){
                        alert("恭喜恭喜")
                    }
                if(data==1){
                          alert("你的积分不足");
                }

                }
            });
        k=0;

    }
}