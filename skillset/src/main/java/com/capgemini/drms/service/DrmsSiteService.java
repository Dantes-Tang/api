package com.capgemini.drms.service;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import com.capgemini.drms.model.DrmsSite;
@Repository
public interface DrmsSiteService {
	public int updateDrmsSite(DrmsSite drmsSite);
	public int insertDrmsSite(DrmsSite drmsSite);       
	public List<DrmsSite> searchDrmsSiteAll();
	public List<DrmsSite> searchDrmsSiteById(int siteId);
}
