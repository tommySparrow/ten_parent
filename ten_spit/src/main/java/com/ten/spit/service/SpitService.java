package com.ten.spit.service;

import com.ten.spit.dao.SpitDao;
import com.ten.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public Object findByExample() {

        Spit spit = new Spit();
        spit.setContent("好");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.startsWith());

        Example<Spit> example = Example.of(spit,matcher);

        return spitDao.findAll(example);
    }
}
