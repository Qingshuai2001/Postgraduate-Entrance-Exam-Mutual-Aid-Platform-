
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '300px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人信息',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的帖子',
	url: '../forum/list-my.html'
},

{
	name: '我的订单',
	url: '../orders/list.html'
},

{
	name: '我的地址簿',
	url: '../address/list.html'
},

{
	name: '收藏中心',
	url: '../store/list.html'
},

{
    name: '购物车',
    url: '../cart/list.html'
},
    {
        name: '管理员客服在线',
        url: '../chat/chat.html'
    },
// {
//     name: '后台管理',
//     url: 'http://localhost:8081/index/'
// }
]


var indexNav = [

{
	name: '考研资讯',
	url: './pages/information/list1.html'
}, 
{
	name: '经验贴',
	url: './pages/experience/list1.html'
}, 
{
	name: '资料信息',
	url: './pages/material/list.html'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.html'
}, 
]

// var adminurl =  "http://localhost:8080/postgraduate/admin/dist/index.html";
var adminurl =  "http://localhost:8081/index/";


var cartFlag = false

var chatFlag = false

var systemName = '考研互助平台'


chatFlag = true
cartFlag = true


var menu = [
    {"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"考研资讯","menuJump":"列表","tableName":"information"}],"menu":"考研资讯管理"},
                 {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"考生","menuJump":"列表","tableName":"student"}],"menu":"考生管理"},
                 {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"经验贴","menuJump":"列表","tableName":"experience"}],"menu":"经验贴管理"},
                 {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"资料信息","menuJump":"列表","tableName":"material"}],"menu":"资料信息管理"},
                 {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"资料分类","menuJump":"列表","tableName":"ziliaofenlei"}],"menu":"资料分类管理"},
                 {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"论坛管理","tableName":"forum"}],"menu":"论坛管理"},
                 {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},
                         {"buttons":["新增","查看","修改","删除"],"menu":"客服管理","tableName":"kefuguanli"}],"menu":"系统管理"},
                 {"child":[{"buttons":["查看"],"menu":"未支付订单","tableName":"orders/未支付"},
                         {"buttons":["查看","发货"],"menu":"已支付订单","tableName":"orders/已支付"},
                         {"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},
                         {"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},
                         {"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},
                         {"buttons":["查看"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],
    "frontMenu":[{"child":[{"buttons":["查看"],"menu":"考研资讯列表","menuJump":"列表","tableName":"information"}],"menu":"考研资讯模块"},
                 {"child":[{"buttons":["查看"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴模块"},
                 {"child":[{"buttons":["查看"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"}],"menu":"资料信息模块"}],"roleName":"管理员","tableName":"admin"},
    {"backMenu":[{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"store"}],"menu":"我的收藏管理"},
                 {"child":[{"buttons":["查看"],"menu":"未支付订单","tableName":"orders/未支付"},
                         {"buttons":["查看"],"menu":"已支付订单","tableName":"orders/已支付"},
                         {"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},
                         {"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},
                         {"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},
                         {"buttons":["查看","确认收货"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],
     "frontMenu":[{"child":[{"buttons":["查看"],"menu":"考研资讯列表","menuJump":"列表","tableName":"information"}],"menu":"考研资讯模块"},
         {"child":[{"buttons":["查看"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴模块"},
         {"child":[{"buttons":["查看"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"}],"menu":"资料信息模块"}],"roleName":"考生","tableName":"student"},
    {"backMenu":[{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"store"}],"menu":"我的收藏管理"},
            {"child":[{"buttons":["查看"],"menu":"未支付订单","tableName":"orders/未支付"},
                    {"buttons":["查看"],"menu":"已支付订单","tableName":"orders/已支付"},
                    {"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},
                    {"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},
                    {"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},
                    {"buttons":["查看","确认收货"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],
        "frontMenu":[{"child":[{"buttons":["查看"],"menu":"考研资讯列表","menuJump":"列表","tableName":"information"}],"menu":"考研资讯模块"},
            {"child":[{"buttons":["查看"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴模块"},
            {"child":[{"buttons":["查看"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"}],"menu":"资料信息模块"}],"roleName":"教师","tableName":"teacher"}]



var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
