
package com.qing.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.TokenDao;
import com.qing.entity.TokenEntity;
import com.qing.service.TokenService;
import com.qing.utils.CommonUtil;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class TokenServiceImpl extends ServiceImpl<TokenDao, TokenEntity> implements TokenService {


	@Override
	public String generateToken(Long userId,String account, String tableName, String role) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("user_id", userId).eq("role", role));
		String token = CommonUtil.getRandomString(32);
		Calendar cal = Calendar.getInstance();   
    	cal.setTime(new Date());   
    	cal.add(Calendar.HOUR_OF_DAY, 1);
		if(tokenEntity!=null) {
			tokenEntity.setToken(token);
			tokenEntity.setExpiredTime(cal.getTime());
			this.updateById(tokenEntity);
		} else {
			this.insert(new TokenEntity(userId,account, tableName, role, token, cal.getTime()));
		}
		return token;
	}

	@Override
	public TokenEntity getTokenEntity(String token) {
		TokenEntity tokenEntity = this.selectOne(new EntityWrapper<TokenEntity>().eq("token", token));
		if(tokenEntity == null || tokenEntity.getExpiredTime().getTime()<new Date().getTime()) {
			return null;
		}
		return tokenEntity;
	}

}
