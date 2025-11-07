package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.StudentEntity;
import com.qing.entity.TeacherEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("teacher")
public class TeacherView extends TeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TeacherView(){
	}

 	public TeacherView(TeacherEntity TeacherEntity){
 	try {
			BeanUtils.copyProperties(this, TeacherEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
