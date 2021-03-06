package com.niit.backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.FileUploadDAO;
import com.niit.backend.dao.JobDao;
import com.niit.backend.model.Job;
import com.niit.backend.model.FileUpload;

public class UploadFileTest {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		FileUploadDAO fileUploadDao= (FileUploadDAO) context.getBean("fileUploadDao");

		FileUpload uploadFile=(FileUpload) context.getBean("uploadFile");
		uploadFile.setFileName("gggg");  
		String s = "hello blob";
		byte b[] = s.getBytes();
		uploadFile.setData(b);
		uploadFile.setUsername("poornima");
		
		fileUploadDao.save(uploadFile);
		

	}

}
