package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsSiteDao;
import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.service.DrmsSiteService;
@Service(value="DrmsSiteService")
public class DrmsSiteServiceImpl implements DrmsSiteService {
	@Autowired
	private DrmsSiteDao drmsSiteDao;
	public int updateDrmsSite(DrmsSite drmsSite) {
		// TODO Auto-generated method stub
		return drmsSiteDao.updateDrmsSite(drmsSite);
	}

	public int insertDrmsSite(DrmsSite drmsSite) {
		// TODO Auto-generated method stub
		return drmsSiteDao.insertDrmsSite(drmsSite);
	}

	public List<DrmsSite> searchDrmsSiteAll() {
		// TODO Auto-generated method stub
		return drmsSiteDao.searchDrmsSiteAll();
	}
	public List<DrmsSite> searchDrmsSiteAll(int siteId) {
		// TODO Auto-generated method stub
		return drmsSiteDao.searchDrmsSiteAll();
	}

	public List<DrmsSite> searchDrmsSiteById(int siteId) {
		// TODO Auto-generated method stub
		return drmsSiteDao.searchDrmsSiteById(siteId);
	}

}
