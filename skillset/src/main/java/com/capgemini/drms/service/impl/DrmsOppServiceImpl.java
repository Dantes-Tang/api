package com.capgemini.drms.service.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsAccountDao;
import com.capgemini.drms.dao.DrmsDemandDao;
import com.capgemini.drms.dao.DrmsOppDao;
import com.capgemini.drms.model.DrmsAccount;
import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsDemandStatus;
import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.service.DrmsOppService;

@Service
public class DrmsOppServiceImpl implements DrmsOppService
{
    @Autowired
    private DrmsOppDao drmsOppDao;
    @Autowired
    private DrmsAccountDao drmsAccountDao;
    @Autowired
    private DrmsDemandDao drmsDemandDao;

    public List<DrmsOpp> getDrmsOpp()
    {
        return drmsOppDao.getDrmsOpp();
    }

    public int insertDrmsOpp(DrmsOpp drmsOpp)
    {

        String accountName = drmsOpp.getDrmsAccount().getAccountName();
        StringBuffer stringBuffer = new StringBuffer();
        String shortName = null;
        DrmsAccount drmsAccount = drmsAccountDao
                .getDrmsAccountByName(accountName);
        shortName = drmsAccount.getShortName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String year = sdf.format(date);

        int count = drmsOppDao.countAccountOpp(drmsOpp.getDrmsAccount());
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumIntegerDigits(4);
        nf.setMinimumIntegerDigits(4);

        stringBuffer.append(shortName).append(year)
                .append(nf.format(count + 1));

        drmsOpp.setOppShowId(stringBuffer.toString());

        return drmsOppDao.insertDrmsOpp(drmsOpp);
    }
    
    public int updateDrmsOpp(DrmsOpp drmsOpp)
    {
  
        if("Closed".equals(drmsOpp.getDrmsStatus().getStatusName())){
            
           
            List<DrmsDemand> drmsDemands = drmsDemandDao.searchDrmsDemandById(drmsOpp.getOppId());
            
            for (DrmsDemand closedDrmsDemand : drmsDemands)
            {
                DrmsDemandStatus drmsDemandStatus = new DrmsDemandStatus();
                drmsDemandStatus.setDmdStatusId(7);
                closedDrmsDemand.setDrmsDemandStatus(drmsDemandStatus);
                drmsDemandDao.updateDrmsDemand(closedDrmsDemand);
            }
        }
        
        return drmsOppDao.updateDrmsOpp(drmsOpp);
    }
    
	@Override
	public List<DrmsOpp> getDrmsOppByStatus() {
		// TODO Auto-generated method stub
		return drmsOppDao.getDrmsOppByStatus();
	}

}
