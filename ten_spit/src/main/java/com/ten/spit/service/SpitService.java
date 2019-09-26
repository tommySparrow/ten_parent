package com.ten.spit.service;

import com.ten.spit.dao.SpitDao;
import com.ten.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    @Autowired
    private MongoTemplate mongoTemplate;

    public Object findAll() {
        return spitDao.findAll();
    }

    public Object findById(String spitId) {
        return spitDao.findById(spitId);
    }

    public void save(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
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

        Example<Spit> example = Example.of(spit, matcher);

        return spitDao.findAll(example);
    }

    public Page<Spit> findByParentid(String parentid, int page, int size) {

        return spitDao.findByParentid(parentid, PageRequest.of(page, size));
    }

    public void thumbup(String spitid) {
//        Spit spit = spitDao.findById(spitid).get();
//        spit.setThumbup((spit.getThumbup() == null ? 0 : spit.getThumbup()) + 1);
//        spitDao.save(spit);

        //性能优化
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(spitid));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }
}
