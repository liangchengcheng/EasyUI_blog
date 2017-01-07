package com.lcc.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.lcc.dao.LinkDao;
import com.lcc.entity.Link;
import com.lcc.service.LinkService;
import org.springframework.stereotype.Service;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkDao linkDao;

    public List<Link> getLinkData() {
        return linkDao.getLinkData();
    }

    public List<Link> listLinkData(Map<String, Object> map) {
        return linkDao.listLinkData(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return linkDao.getTotal(map);
    }

    public Integer addLink(Link link) {
        return linkDao.addLink(link);
    }

    public Integer updateLink(Link link) {
        return linkDao.updateLink(link);
    }

    public Integer deleteLink(Integer id) {
        return linkDao.deleteLink(id);
    }

}
