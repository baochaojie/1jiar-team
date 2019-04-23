$(function(){
    initbooklist();
})

function initbooklist(){
    $('#bookTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'../qureyResume',
        type:'post',
        columns:[

            {field:'name',title:'用户姓名'},
            {field:'jiaxidname',title:'家乡市'},
            {field:'jiaoxidname',title:'家乡省'},

            {field:'xingb',title:'性别',

                formatter: function(value,row,index){
                    return value==1?"男":value==2?"女":value==3?"人妖":"";
                }},
            {field:'aihao',title:'爱好',
                formatter: function(value,row,index){
                    return value==1?"游泳":value==2?"机车":value==3?"看书":value==4?"打球":value==5?"慢跑":value==6?"极限":value==7?"交流":value==8?"玩":"";
                }},
            {title:'教育',field:'jiaoyidname',},
            {field:'hengyidname',title:'行业'},
            {field:'shuozaiidname',title:'所在城市'},
            {field:'shuosiname',title:'所在城市'},


            {field:'123',formatter:function(value,row,index){
                    return '<a href="javascript:shanchu('+row.id+');">删除</a>'
                }}
        ]
    });
}

function shanchu(id){
    bootbox.confirm({
        size: "small",
        message: "删除的数据",
        callback:function(result){
            if(result){
                $.ajax({
                    url:"../deleteuser",
                    type:'post',
                    data:{
                        id:id
                    },
                    dataType:'json',
                    success:function(data){
                        if(data){
                            tiaojianchaxun();
                        }else{
                            bootbox.alert({
                                size:"small",
                                title:"提示",
                                message:"删除失败",
                            });
                        }

                    }

                })
            }
        }
    })

}





