initTree();
<<<<<<< HEAD
initusername();
function initusername(){
alert(1)
    $.ajax({
        url:'../qureyResume',
        type:'post',
        data:{},
        success:function(data){
            $("#name").text(data);
=======

//初始化用户名称展示
initusername();
function initusername(){

    $.ajax({
        url:'../inituserphone',
        type:'post',
        data:{},
        success:function(data){
            $("#mingz").text(data);
>>>>>>> d4dce33e0d3a5a4d6549271c7fd88daddea9a7ac
        }
    })

}
function initTree(){
    $.ajax({
        url:"../findTree",
        type:"post",
        success:function(data){
            $('#myTree').treeview({
                data:data,
                onNodeSelected:function(event, node) {
                    $.addtabs({iframeHeight: 550});
                    $.addtabs.add({
                        id:node.id,
                        title:node.text,
                        url:"../"+node.href
                    });
                }
            })
        }
    })
}
