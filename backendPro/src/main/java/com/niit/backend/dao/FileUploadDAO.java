package com.niit.backend.dao;

import com.niit.backend.model.FileUpload;

public interface FileUploadDAO 
{
	void save(FileUpload uploadFile);
	void upDate(FileUpload uploadFile);
	FileUpload getFile(String username);
}
