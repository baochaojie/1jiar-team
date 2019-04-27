$(function () {
    initjdd()
})

function initjdd() {
    $.ajax({
        url:"../findAgent",
        success:function (result) {
            var html = "";
               $.each(function(index,obj){
                   var html='\n' +
                       '        <div class="pic_panel"><a href="https://dianpu.lianjia.com/1000000010092765">\n' +
                       '            <img onerror="this.src=\'https://s1.ljcdn.com/feroot/pc/asset/img/jingjiren/noimg.jpg?_v=20190418174907\';" src="'+obj.argentImg+"></a></div>\n' +
                       '        <div class="info-panel"><div class="agent-name clear-fl" data-id="3">\n' +
                       '            <a href="https://dianpu.lianjia.com/1000000010092765" class="h1 fl">'+obj.agentName+'</a><span class="position fl">'+obj.agentJob+'</span><a class="lianjiaim-createtalkAll im-talk fl" data-role="lianjiaim-createtalk" title="在线咨询" data-ucid="1000000010092765" data-source-port="PC:ershou_jingjiren_shop"></a></div>\n' +
                       '            <div class="col-1">\n' +
                       '                <div class="main-plate"><span class="mp-title">所属门店:&nbsp;<i id="icon_pin"></i></span><a data-coord="116.172401,39.775096" id="mapShow"><span>'+obj.store+'</span></a></div>\n' +
                       '        <div class="achievement"><span>联系电话:&nbsp;&nbsp;'+obj.agentPhone+'</span></div>\n' +
                       '        <div class="label"><span class="owner_trust_mark">房东信赖</span><span class="good_comment_mark">客户热评</span><span class="good_saler_mark">销售达人</span><span class="top_guider_mark">带看活跃</span><span class="law_expert">法律顾问</span><span class="abroad_expert">海外顾问</span></div></div><div class="m-qrcode" data-show="0"><div class="num">综合评分：'+obj.score+'</div><div class="icon-qrcode" data-url="https://m.link.lianjia.com/store/share/resume?agentId=1000000010092765&amp;from=dianpu"></div><div class="txt">我比您看到的更有料</div>\n' +
                       '    </div>\n' +
                       '    </div>\n' +
                       '    '
                   $("#jdd").html(html)

            })

        }
    })
}