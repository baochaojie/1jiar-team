$(function(){
    initTree();
})

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
                        url:".."+node.href
                    });
                }
            })
        }
    })
}
