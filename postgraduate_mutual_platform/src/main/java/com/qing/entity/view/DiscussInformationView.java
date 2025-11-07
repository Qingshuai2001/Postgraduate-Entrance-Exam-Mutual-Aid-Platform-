package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.DiscussInformationEntity;
import org.apache.commons.beanutils.BeanUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("discussinformation")
public class DiscussInformationView extends DiscussInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussInformationView(){
	}

 	public DiscussInformationView(DiscussInformationEntity discussInformationEntity){
 	try {
			BeanUtils.copyProperties(this, discussInformationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
