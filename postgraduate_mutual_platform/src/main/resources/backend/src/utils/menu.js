const menu = {
    list() {
        return [
            {"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"考生管理","menuJump":"列表","tableName":"student"},{"buttons":["新增","查看","修改","删除"],"menu":"教师管理","menuJump":"列表","tableName":"teacher"}],"menu":"用户管理"},
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"考研资讯","menuJump":"列表","tableName":"information"}],"menu":"资讯管理"},
                    {"child":[{"buttons":["发布","查看","修改","删除","审核"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴管理"},
                    {"child":[{"buttons":["上传","查看","修改","删除","审核"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"},{"buttons":["查看","修改","删除"],"menu":"已交易资料","menuJump":"列表","tableName":"sellMaterial"},{"buttons":["发布","查看","修改","删除","发货"],"menu":"资料订单","menuJump":"列表","tableName":"materialOrder"}],"menu":"资料管理"},
                    {"child":[{"buttons":["发布","查看","修改","删除","审核"],"menu":"商品信息列表","menuJump":"列表","tableName":"commodity"},{"buttons":["查看","修改","删除"],"menu":"已交易商品","menuJump":"列表","tableName":"sellCommodity"},{"buttons":["发布","查看","修改","删除","发货"],"menu":"商品订单","menuJump":"列表","tableName":"commodityOrder"}],"menu":"商品管理"},
                    {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"经验贴分类","menuJump":"列表","tableName":"category"},{"buttons":["新增","查看","修改","删除"],"menu":"资讯分类","menuJump":"列表","tableName":"informationcategory"},
                            {"buttons":["新增","查看","修改","删除"],"menu":"资料分类","menuJump":"列表","tableName":"materialcategory"},{"buttons":["新增","查看","修改","删除"],"menu":"商品分类","menuJump":"列表","tableName":"commoditycategory"} ],"menu":"分类管理"},
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"论坛帖子","tableName":"forum"}],"menu":"论坛管理"},
                    {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图列表","tableName":"config"},{"buttons":["新增","查看","修改","删除"],"menu":"客服处理","tableName":"clerk"}],"menu":"系统管理"},
                    {"child":[{"buttons":["查看","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},{"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},{"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},{"buttons":["查看"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],
                "frontMenu":[{"child":[{"buttons":["查看"],"menu":"考研资讯列表","menuJump":"列表","tableName":"information"}],"menu":"考研资讯模块"},
                    {"child":[{"buttons":["查看"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴模块"},
                    {"child":[{"buttons":["查看"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"}],"menu":"资料信息模块"}],"roleName":"管理员","tableName":"admin"},
            {"backMenu":[
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"我的经验贴"},
                    {"child":[{"buttons":["上传","查看","修改","删除"],"menu":"资料列表","menuJump":"列表","tableName":"material"},{"buttons":["查看","修改","删除"],"menu":"已交易资料","menuJump":"列表","tableName":"sellMaterial"},{"buttons":["发布","查看","修改","删除","发货"],"menu":"资料订单","menuJump":"列表","tableName":"materialOrder"}],"menu":"我的资料"},
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"商品列表","menuJump":"列表","tableName":"commodity"},{"buttons":["查看","修改","删除"],"menu":"已交易商品","menuJump":"列表","tableName":"sellCommodity"},{"buttons":["发布","查看","修改","删除","发货"],"menu":"商品订单","menuJump":"列表","tableName":"commodityOrder"}],"menu":"闲置商品"},
                    {"child":[{"buttons":["查看","删除"],"menu":"收藏中心","tableName":"store"}],"menu":"我的收藏"},
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"帖子列表","tableName":"forum"}],"menu":"我的帖子"},
                    {"child":[{"buttons":["新增","查看","修改","删除"],"menu":"地址列表","tableName":"address"}],"menu":"地址簿"},
                    {"child":[{"buttons":["查看"],"menu":"已支付订单","tableName":"orders/已支付"},{"buttons":["查看"],"menu":"已完成订单","tableName":"orders/已完成"},{"buttons":["查看"],"menu":"已取消订单","tableName":"orders/已取消"},{"buttons":["查看"],"menu":"已退款订单","tableName":"orders/已退款"},{"buttons":["查看","确认收货"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"我的订单"}],
                "frontMenu":[{"child":[{"buttons":["查看"],"menu":"考研资讯列表","menuJump":"列表","tableName":"information"}],"menu":"考研资讯模块"},
                    {"child":[{"buttons":["查看"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴模块"},
                    {"child":[{"buttons":["查看"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"}],"menu":"资料信息模块"}],"roleName":"考生","tableName":"student"},
            {"backMenu":[
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"我的经验贴"},
                    {"child":[{"buttons":["上传","查看","修改","删除"],"menu":"资料列表","menuJump":"列表","tableName":"material"},{"buttons":["查看","修改","删除"],"menu":"已交易资料","menuJump":"列表","tableName":"sellMaterial"},{"buttons":["发布","查看","修改","删除","发货"],"menu":"资料订单","menuJump":"列表","tableName":"materialOrder"}],"menu":"我的资料"},
                    {"child":[{"buttons":["发布","查看","修改","删除"],"menu":"帖子列表","tableName":"forum"}],"menu":"我的帖子"},],
                "frontMenu":[{"child":[{"buttons":["查看"],"menu":"考研资讯列表","menuJump":"列表","tableName":"information"}],"menu":"考研资讯模块"},
                    {"child":[{"buttons":["查看"],"menu":"经验贴列表","menuJump":"列表","tableName":"experience"}],"menu":"经验贴模块"},
                    {"child":[{"buttons":["查看"],"menu":"资料信息列表","menuJump":"列表","tableName":"material"}],"menu":"资料信息模块"}],"roleName":"教师","tableName":"teacher"}]
    }
}
export default menu;
