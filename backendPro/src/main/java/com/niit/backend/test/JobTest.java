package com.niit.backend.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.JobDao;

import com.niit.backend.model.Job;


public class JobTest 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
	    JobDao jobDao= (JobDao) context.getBean("jobDao");

		Job job=(Job) context.getBean("job");
		

		job.setJobTitle("Tester");
		job.setJobDescription("kkk");
		job.setPostedOn(new Date(21/12/2016));
		job.setSkillsRequired("C");
		job.setSalary("30000");
		job.setLocation("MYSORE");
		
		
		
		jobDao.addJob(job);

	}

}
