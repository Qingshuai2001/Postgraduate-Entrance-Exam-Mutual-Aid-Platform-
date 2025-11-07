package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.StudentEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("student")
public class StudentView extends StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public StudentView(){
	}

 	public StudentView(StudentEntity studentEntity){
 	try {
			BeanUtils.copyProperties(this, studentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
