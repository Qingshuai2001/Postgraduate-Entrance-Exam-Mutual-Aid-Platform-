const api = {

    // 客服
    chatpage:'chat/page?sort=add_time&order=desc&isReply=1',
    chatbyuseridpage: 'chat/page?sort=add_time&order=asc&userId=',
    chatsave: 'chat/save',
    // 论坛
    forumpage: 'forum/page?parentId=0&sort=add_time&order=desc',
    forumdelete : 'forum/delete',
    forumsave: 'forum/save',
    foruminfo: 'forum/info/',
    forumupdate: 'forum/update',
    // 路线
    routepage : 'route/page',
    routedelete: 'route/delete',
    routeinfo: 'route/info/',
    routesave: 'route/save',
    routeupdate: 'route/update',
    // 配置
    configpage: 'config/page',
    configdelete: 'config/delete',
    configinfo: 'config/info/',
    configsave: 'config/save',
    configupdate: 'config/update',

    orderpage: 'orders/page',
    orderdelete: 'orders/delete',
    orderinfo: 'orders/info/',
    ordersave: 'orders/save',
    orderupdate: 'orders/update',

}

export default api