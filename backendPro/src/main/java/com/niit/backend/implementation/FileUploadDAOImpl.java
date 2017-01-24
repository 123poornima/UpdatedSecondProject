package com.niit.backend.implementation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.FileUploadDAO;
import com.niit.backend.model.FileUpload;
import com.niit.backend.model.User;


@EnableTransactionManagement
@Transactional
@Repository("fileUploadDao")
public class FileUploadDAOImpl implements FileUploadDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public FileUploadDAOImpl() {
	}

	public FileUploadDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	//@Transactional
	public void save(FileUpload uploadFile) {
		Session session=sessionFactory.getCurrentSession();
		session.save(uploadFile);
		//session.flush();
		//session.close();
	}
	
	public void upDate(FileUpload uploadFile) {
		Session session=sessionFactory.getCurrentSession();
		session.update(uploadFile);
		//session.flush();
		//session.close();
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public FileUpload getFile(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from FileUpload where username=?");
		query.setParameter(0, username);
        FileUpload uploadFile=(FileUpload)query.setMaxResults(1).uniqueResult();
		//session.close();
		return uploadFile;
	}
}
