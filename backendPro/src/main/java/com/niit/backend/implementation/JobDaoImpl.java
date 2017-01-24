package com.niit.backend.implementation;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.JobDao;
import com.niit.backend.model.Job;
import com.niit.backend.model.User;

@EnableTransactionManagement
@Transactional
@Repository("jobDao")
public class JobDaoImpl implements JobDao
{
	
	@Transactional
	   public void addJob(Job job)
	   {
		  System.out.println("Entering to addUser.....");
		  sessionFactory.getCurrentSession().saveOrUpdate(job);
	   }
	
	@Override
	public Job getJobDetail(int jobId) {
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		session.close();
		return job;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
		
		@Override
		public void postJob(Job job) {
			Session session=sessionFactory.getCurrentSession();
			session.save(job);
			session.flush();
			session.close();

		}

	/*	@Override
		public List<Job> getAllJobs() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Job");
			List<Job> jobs=query.list();
			session.close();
			return jobs;
		}*/
		@Transactional
		public List<Job> getAllJobs()
		{
			List<Job> list= (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
					
		}
}
