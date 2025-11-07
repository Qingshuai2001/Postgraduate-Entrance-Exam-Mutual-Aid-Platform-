package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qing.common.R;
import com.qing.entity.ChatEntity;
import com.qing.service.ChatService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ChatEntity chat, HttpServletRequest request){
//		chat.setUserId((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<ChatEntity> ew = new EntityWrapper<ChatEntity>();
		PageUtils page = chatService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chat), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChatEntity chat, HttpServletRequest request){
		chat.setUserId((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<ChatEntity> ew = new EntityWrapper<ChatEntity>();
		PageUtils page = chatService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chat), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChatEntity chat = chatService.selectById(id);
        return R.ok().put("data", chat);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChatEntity chat, HttpServletRequest request){
    	chat.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		chat.setAddTime(new Date());
    	if(StringUtils.isNotBlank(chat.getAsk())) {
			chatService.updateForSet("is_reply=0", new EntityWrapper<ChatEntity>().eq("user_id", request.getSession().getAttribute("userId")));
    		chat.setUserId((Long)request.getSession().getAttribute("userId"));
    		chat.setIsReply(1);
    	}
    	if(StringUtils.isNotBlank(chat.getReply())) {
    		chatService.updateForSet("is_reply=0", new EntityWrapper<ChatEntity>().eq("user_id", chat.getUserId()));
    		chat.setAdminId((Long)request.getSession().getAttribute("userId"));
    	}
        chatService.insert(chat);
        return R.ok();
    }

    /**
     * 发布聊天消息
     * @param chat
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChatEntity chat, HttpServletRequest request){
        chat.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        chat.setUserId((Long)request.getSession().getAttribute("userId"));
        if(StringUtils.isNotBlank(chat.getAsk())) {
            chatService.updateForSet("is_reply=0", new EntityWrapper<ChatEntity>().eq("user_id", request.getSession().getAttribute("userId")));
            chat.setUserId((Long)request.getSession().getAttribute("userId"));
            chat.setIsReply(1);
        }
        if(StringUtils.isNotBlank(chat.getReply())) {
            chatService.updateForSet("is_reply=0", new EntityWrapper<ChatEntity>().eq("user_id", chat.getUserId()));
            chat.setAdminId((Long)request.getSession().getAttribute("userId"));
        }
        chatService.insert(chat);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChatEntity chat, HttpServletRequest request){
        chatService.updateById(chat);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chatService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
