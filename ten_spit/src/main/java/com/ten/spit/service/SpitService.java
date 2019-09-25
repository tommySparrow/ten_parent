package com.ten.spit.service;

import com.ten.spit.dao.SpitDao;
import com.ten.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

@Service
@Transactional(rollbackFor = Exception.class)
public class SpitService {

    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;

    //CRUD
    public Object findAll() {
        return spitDao.findAll();
    }


    public Object findById(String spitId) {
        return spitDao.findById(spitId);
    }

    public void save(Spit spit) {
        spit.set_id(idWorker.nextId()+"");
        spitDao.save(spit);
    }

    public void update(Spit spit) {
        spitDao.save(spit);
    }

    public void deleteById(String spitId) {
        spitDao.deleteById(spitId);
    }
}
