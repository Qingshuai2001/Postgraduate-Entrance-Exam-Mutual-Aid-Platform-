
package com.qing.service;

import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.TokenEntity;



/**
 * token
 */
public interface TokenService extends IService<TokenEntity> {

   	String generateToken(Long userId,String account,String tableName, String role);

	TokenEntity getTokenEntity(String token);
}
