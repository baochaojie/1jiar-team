//登录
function login(){
    $("#loginForm").form('submit',{
        url:'../login1',
        success:function(data){
            data = JSON.parse(data);
            if(data.code!=0){
                $.messager.alert('提示',data.msg,'error')
            }else{
                window.location.href="<%=path%>/bootstrap.jsp";
            }
        }
    })
} 