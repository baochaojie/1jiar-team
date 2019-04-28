houseId=2;
    $('#DlrldHistoryTable').bootstrapTable({
        toolbar:'#toolbar',
        url:'/queryDlrld?houseId='+houseId,//获取数据地址
        type:'post',
        striped:true,
        columns:[
            {field:'loimg',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'userName'},
            {field:'integralAdd'},
            {field:'dltyname'},
            {field:'tame'},
            {field:'dllname'},
            {field:'stateId',formatter:function(value,row,index){
                    if(value==1){
                        return "未领取";
                    }else if(value==2){
                        return "领取";
                    }else if(value==3){
                        return "放弃";
                    }
                }},
            {field:'awardImg',formatter:function(data){
                    return "<img src="+data+" width='50' height='50'>";
                }},
            {field:'123',formatter:function(value,row,index){
                    if(row.stateId==1){
                        return '<a href="javascript:lingqu('+row.dlrIdId+','+row.houseId+');">领取</a><a href="javascript:fangqi('+row.dlrIdId+','+row.houseId+');">放弃</a>';
                    }else{
                        return "";
                    }
                }
            }
        ]
    });
