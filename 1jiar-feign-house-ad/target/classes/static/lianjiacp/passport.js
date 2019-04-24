/**
 * 链家登录服务
 * 
 * 
lianjiaCasManager.config({
  
  // 登录成功后，注册到本系统，将会采用jsonp方式。传入从cas获取的ticket
  getUserInfo:""
})
 */
var lianjiaCasManager = (function(){
  var $ = {};
  $.joinUrl = function(url,param,noHash){
  if(!url){
    url = location.href;
  }
  if(!param){
    return url;
  }
  var Url = $.parseURL(url);
  
  var args = [];
  for(var i in param){
    if(!i){
      continue;
    }
    args.push(i+"="+encodeURIComponent(param[i]));
  }
  var query = Url.query?(Url.query+"&"+args.join("&")):args.join("&");
  if(query){
    query = "?"+query;
  }
  var path = Url.path;
  if(path){
    path = "/"+path;
  }
  var hash = noHash?"":(Url.hash?("#"+ Url.hash):"");
  return Url.origin+path+query+hash;
}
$.parseURL = function(a){
  if(!a){
    return null;
  }
  var b = /^((?:([A-Za-z]+):(\/{0,3}))?([0-9.\-A-Za-z]+\.[0-9A-Za-z]+)?(?::(\d+))?)(?:\/([^?#]*))?(?:\?([^#]*))?(?:#(.*))?$/, 
    c = ["url","origin", "scheme", "slash", "host", "port", "path", "query", "hash"], 
    d = b.exec(a), e = {};
  if(d)
  for (var f = 0, g = c.length; f < g; f += 1)
      e[c[f]] = d[f] || "";
  return e;
}
$.trim = function(str){
  if(!str){
    return str;
  }
  return str.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,"");
}
$.extend = function(base,opt){
  if(!opt){
    return;
  }
  for(var i in opt){
    base[i] = opt[i];
  }
  return base;
}

$.Deferred = (function(){
  
  return function(){
    var that = {};
  
    var succback = [],
        failback = [];
    var state = "init";
    
    var rsData;
    
    that.done = function(cb){
      if(state == "success"){
        cb(rsData);
      }else if(state == "init"){
        succback.push(cb);
      }
      return that;
    }
    that.fail = function(cb){
      if(state == "fail"){
        cb(rsData);
      }else if(state == "init"){
        failback.push(cb);
      }
      return that;
    }
    that.then = that.done;
    that.resolve = function(data){
      state = "success";
      rsData = data;
      var cb = false;
      while(cb = succback.shift()){
        //console.log("cb:"+cb+" rsData="+rsData);
        cb(rsData);
      }
      
      return that;
    }
    that.reject = function(data){
      state = "fail";
      rsData = data;
      var cb = false;
      while(cb = failback.shift()){
        cb();
      }
    }
    return that;
  }
})();
;
  
  var config = {
    getFirstTicket:"https://upassport.lianjia.com/freshLoginTicket",
    loginUrl:"https://upassport.lianjia.com/login",
    service:"",
    setLoginUrl:"",
    _eventId: 'submit'
  };
  
  var isDev = (function(){
    var href = location.href;
    var url = $.parseURL(href);
    if(url.host.indexOf("dev") >=0 || url.host.indexOf("test") >=0 || url.port){
      return true;
    }
    return false;
  })();
  if(isDev){
    $.extend(config,{
      getFirstTicket:"http://upassport.test.lianjia.com:5201/freshLoginTickett",
      loginUrl:"http://upassport.test.lianjia.com:5201/login"
    })
  }
  
  var exports = {};
  // 配置
  exports.config = function(opt){
    $.extend(config,opt);
  }
  
  /**
 * 登录服务
 *
 *
 */
/**
 * @Description
 * 请求封装，
 *  1.支持ajax  jsonp请求
 *  2.自动转化跨域模式，跨域支持见./xd/XDRequest
 *  
 * 
 * @example

var Trans = require("io/Trans")

var request = new Trans({
  // 请求的url参数
  url:"",
  // 请求method  get post
  method:"get",
  // 返回数据类型  json  jsonp :将采用jsonp方式请求  html：请求的为html
  dataType:"json",
  // 请求参数
  data:{},
  // 超时时间，单位毫秒。
  timeout:30*1000
})

// 发送请求  参数为 对象，
// 请求返回的是 promise 方式
request.request(args,option).done(function(data){
  
}).fail(function(data){
  
})

// 重新设置url ：注意，重新设置url只能设置域名之后的路径。
request.resetUrl(url)

// 设置参数。
request.setArgs(args)

// 清空请求参数
request.clearArgs();
 * 
 */

/**
 * 跨域请求
 *
 */
/**
 * 跨域请求
 * 
 */

/**
 *     __  ___
 *    /  |/  /___   _____ _____ ___   ____   ____ _ ___   _____
 *   / /|_/ // _ \ / ___// ___// _ \ / __ \ / __ `// _ \ / ___/
 *  / /  / //  __/(__  )(__  )/  __// / / // /_/ //  __// /
 * /_/  /_/ \___//____//____/ \___//_/ /_/ \__, / \___//_/
 *                                        /____/
 *
 * @description MessengerJS, a common cross-document communicate solution.
 * @author biqing kwok
 * @version 2.0
 * @license release under MIT license
 */

window.Messenger = (function(){
    // 消息前缀, 建议使用自己的项目名, 避免多项目之间的冲突
    // !注意 消息前缀应使用字符串类型
    var prefix = "[LIANJIA_CROSS]",
        supportPostMessage = 'postMessage' in window;

    // Target 类, 消息对象
    function Target(target, name){
        var errMsg = '';
        if(arguments.length < 2){
            errMsg = 'target error - target and name are both requied';
        } else if (typeof target != 'object'){
            errMsg = 'target error - target itself must be window object';
        } else if (typeof name != 'string'){
            errMsg = 'target error - target name must be string type';
        }
        if(errMsg){
            throw new Error(errMsg);
        }
        this.target = target;
        this.name = name;
    }

    // 往 target 发送消息, 出于安全考虑, 发送消息会带上前缀
    if ( supportPostMessage ){
        // IE8+ 以及现代浏览器支持
        Target.prototype.send = function(msg){
            this.target.postMessage(prefix + msg, '*');
        };
    } else {
        // 兼容IE 6/7
        Target.prototype.send = function(msg){
            var targetFunc = window.navigator[prefix + this.name];
            if ( typeof targetFunc == 'function' ) {
                targetFunc(prefix + msg, window);
            } else {
                throw new Error("target callback function is not defined");
            }
        };
    }

    // 信使类
    // 创建Messenger实例时指定, 必须指定Messenger的名字, (可选)指定项目名, 以避免Mashup类应用中的冲突
    // !注意: 父子页面中projectName必须保持一致, 否则无法匹配
    function Messenger(messengerName, projectName){
        this.targets = {};
        this.name = messengerName;
        this.listenFunc = [];
        prefix = projectName || prefix;
        if(typeof prefix !== 'string') {
            prefix = prefix.toString();
        }
        this.initListen();
    }

    // 添加一个消息对象
    Messenger.prototype.addTarget = function(target, name){
        var targetObj = new Target(target, name);
        this.targets[name] = targetObj;
    };

    // 初始化消息监听
    Messenger.prototype.initListen = function(){
        var self = this;
        var generalCallback = function(msg){
            if(typeof msg == 'object' && msg.data){
                msg = msg.data;
            }
            // 剥离消息前缀
            msg = msg.slice(prefix.length);
            for(var i = 0; i < self.listenFunc.length; i++){
                self.listenFunc[i](msg);
            }
        };

        if ( supportPostMessage ){
            if ( 'addEventListener' in document ) {
                window.addEventListener('message', generalCallback, false);
            } else if ( 'attachEvent' in document ) {
                window.attachEvent('onmessage', generalCallback);
            }
        } else {
            // 兼容IE 6/7
            window.navigator[prefix + this.name] = generalCallback;
        }
    };

    // 监听消息
    Messenger.prototype.listen = function(callback){
        this.listenFunc.push(callback);
    };
    // 注销监听
    Messenger.prototype.clear = function(){
        this.listenFunc = [];
    };
    // 广播消息
    Messenger.prototype.send = function(msg){
        var targets = this.targets,
            target;
        for(target in targets){
            if(targets.hasOwnProperty(target)){
                targets[target].send(msg);
            }
        }
    };

    return Messenger;
})();
;

$.crossRequest = (function(){
  var globalMessanger = new Messenger('LIANJIA_CROSS_MESSAGE', 'LIANJIA-CROSS');
  globalMessanger.listen(function (msg) {
     msg = JSON.parse(msg);
     var name = msg.name;
     if(globalMessanger.targets[name]){
       if(msg.type == "state"){
         globalMessanger.targets[name].readyState = "ready";
         globalMessanger.targets[name].dealReady();
       }else{
         globalMessanger.targets[name].deal(msg.data,msg.success);
       }
     }
  });
  var PageMessage = {};
  
  var Message = function(domain,name){
    var _this = this;
    _this.domain =  domain;
    name = name || $.parseURL(domain).host.replace(/\./g,"-")
    _this.name = name;
    _this.init();
  }
  
  $.extend(Message.prototype,{
    init:function(){
      var _this = this;
      var iframeUrl = _this.domain+"/xd/api?name="+_this.name;
      
      
      var iframe = document.createElement("iframe");
      iframe.id = _this.name;
      iframe.tabindex = "-1";
      iframe.src = iframeUrl;
      iframe.style.display = "none";
      iframe.width = 0;
      iframe.height = 0;
      iframe.title = "empty";
      
      document.body.appendChild(iframe);
      
      _this.iframe = iframe.contentWindow;
      
      globalMessanger.addTarget(_this.iframe, _this.name);
      
      _this.reqArray = [];
      
      globalMessanger.targets[_this.name].deal = function(msg,success){
        globalMessanger.targets[_this.name].isRequest = false;
        
        var request = _this.reqArray.shift(),msgData = false;
        try{
          msgData = msg;
        }catch(e){
        }
        success?request.defer.resolve(msgData):request.defer.reject(msgData);
        _this.next();
      };
      globalMessanger.targets[_this.name].dealReady = function(){
        _this.next();
      };
    },
    next:function(){
      var _this = this;
      if(!globalMessanger.targets[_this.name].readyState){
        return;
      }
      if(_this.reqArray.length && !globalMessanger.targets[_this.name].isRequest){
        globalMessanger.targets[_this.name].isRequest = true;
        var request = _this.reqArray[0];
        var cmd = {
          type:"request",
          data:request.request
        } 
        var str = JSON.stringify(cmd);
        globalMessanger.targets[_this.name].send(str);
      }
    },
    request:function(args){
      var _this = this;
      
      var defer = $.Deferred();
      _this.reqArray.push({
        defer:defer,
        request:args
      })
      _this.next();
      return defer;
    }
  })
  
  return function(domain,name){
    if(PageMessage[domain]){
      return PageMessage[domain];
    }
    return PageMessage[domain] = new Message(domain,name);
  };  
})();


$.XDRequest = (function(){
  var crossRequest = $.crossRequest;
  
  var Request = function(domain,path) {
    var req = crossRequest(domain);
    
    return function(option){
      return req.request(option);
    }
  }

  return Request;
})();

;

$.Trans = (function(require){
   
  var currentOrigin = $.parseURL(location.href).origin;
  var XDRequest = $.XDRequest;
  
  // 判断是否支持跨域
  // var isSupportCORS = (function(){
    // if ('withCredentials' in new XMLHttpRequest()) {
        // /* supports cross-domain requests */
       // return true;
    // }
    // else{
      // // ie ?
      // if(typeof XDomainRequest !== "undefined"){
        // return true;
      // }else{
        // return false;
      // }
    // }
  // });
  var isSupportCORS = false;
  
  function Trans(option){
    // 兼容以前的Trans({})写法
    if(!(this instanceof Trans)){
      return new Trans(option);
    }
    var _this = this;
    var opt = {
      url:"",
      method:"get",
      dataType:"json",
      data:{},
      timeout:30 * 1000
    }
    _this.opt = $.extend(opt,option);
    
    // 判断是否跨域
    var url = $.parseURL(_this.opt.url);
    _this.trans = XDRequest(url.origin);
    
  }
  
  
  $.extend(Trans.prototype,{
    request:function(args,option){
      var opt = {
        success:$.noop,
        fail:$.noop,
        timeout:$.noop,
        timeout:15 * 1000
      }
      $.extend(opt,option)
      
      var deffer = $.Deferred();
      var _this = this;
      $.extend(_this.opt.data,args);
      
      var ajax = _this.trans({
         url:_this.opt.url,
         type:_this.opt.type,
         traditional:true,
         data:_this.opt.data,
         timeout:_this.opt.timeout
      }).done(function(data){
        deffer.resolve(data);
      }).fail(function(data){
         deffer.reject(data);
      });
      return deffer;
    },
    setArgs:function(args){
      $.extend(this.opt.data,args);
    },
    resetUrl:function(url){
      this.opt.url = url;
    },
    clearArgs:function(args){
      if(args){
        for(var i in args){
          if(this.opt.data[i]){
            delete this.opt.data[i];
          }
        }
      }else{
        this.opt.data = {};
      }
    }
  })
  
  return Trans;
})();


$.jsonp = (function(){
   
   var count = 0;
   function getBackName (){
     return "casback"+(new Date().getTime())+""+(count++);
   }
   return function(option){
    
    var opt = {
      url:"",
      data:{},
      success:function(){
        
      },
      fail:function(){
        
      },
      timeout:30 * 1000
    }
    
    $.extend(opt,option);
    if(!opt.data){
      opt.data = {
      }
    }
    var _timeout = false;
    
    var backName = getBackName();
    
    opt.data.callback = backName;
    
    var isBack = false;
    
    function success(data){
      opt.success && opt.success(data);
    }
    function fail(){
      if(!isBack){
        isBack = true;
        clear();
        opt.fail && opt.fail();
      }
      opt.fail && opt.fail();
    }
    function timeout(){
      if(!isBack){
        isBack = true;
        clear();
      }
      //opt.timeout && opt.timeout();
    }
   
    
    
    var url = $.joinUrl(opt.url,opt.data);
    
    var script = document.createElement("script");
    script.type="text/javascript";
    script.charset="utf-8"
    script.src = url;
       script.onerror = function(){
           fail();
       }

       window[backName] = function(data){
           if(isBack){
               return;
           }
           isBack = true;
           clear();
           success(data);
       }
    var head = document.getElementsByTagName("head")[0];
    head.appendChild(script);
    
    function clear(){
      delete window[backName];
      head.removeChild(script);
      clearTimeout(_timeout);
    }
    
    _timeout = setTimeout(function(){
      timeout();
    },opt.timeout)
    

  }
})();



exports.login = function (opt, successcallback, failcallback) {
    var option = {
        // 用户名
        username: "",
        // 密码
        password: "",
        // 验证码
        code: "",
        service: config.service,
        isajax: true,
        _eventId: config._eventId
    };

    $.extend(option, opt);
    function buildLtRequestUrl() {
        var url = config.getFirstTicket;
        var indexOfQuery = url.indexOf("?");
        if (indexOfQuery < 0) {
            url += '?username=' + option.username;
        } else if (indexOfQuery == url.length - 1) {
            url += 'username=' + option.username
        } else {
            url += '&username=' + option.username;
        }
        if (option.code && option.code != '') {
            url += '&code=' + option.code;
        }
        return url;
    }

    function getTicket(cb, fail) {
        var url = buildLtRequestUrl();
        var trans = new $.Trans({
            url: url
        });
        trans.request().then(function (data) {
            cb(data)
        }).fail(function (data) {
            fail && fail(data);
        })
    }

    function loginRequest(option, cb, failcb) {
        var trans2 = new $.Trans({
            url: config.loginUrl,
            type: "post",
            dataType: "html"
        })
        trans2.request(option).then(function (data) {
            cb(data);
        }).fail(function (data) {
            failcb && failcb(data);
        })
    }

    function requestCurrent(args, success, fail) {
        $.jsonp({
            url: config.setLoginUrl,
            data: args,
            success: function (data) {
                success && success(data);
            },
            fail: function () {
                fail && fail();
            }
        })
    }
    getTicket(function (data) {
        var json = data;
        if (json.code == 200) {
            //直接登陆
            successcallback(data)
        } else {

            if (json && json.code && json.code == 500) {
                //需要辅助验证
                failcallback(data);
                return false;
            }
            var ticket = json.data;
            var execution = json.execution;
            option.lt = ticket;
            if (!option.service) {
                option.service = location.href;
            }
            option.execution = execution;
            loginRequest(option, function (data) {
                if (data.code == 200) {
                    requestCurrent({
                        service: option.service,
                        ticket: data.data
                    }, successcallback, failcallback)
                } else {
                    failcallback(data)
                }
            }, failcallback)
        }


    }, failcallback)
};;
  
  　
  return exports;
})();
