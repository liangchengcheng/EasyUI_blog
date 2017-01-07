package com.lcc.service;

import com.lcc.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
public interface LinkService {

    public List<Link> getLinkData();

    public List<Link> listLinkData(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);

    public Integer addLink(Link link);

    public Integer updateLink(Link link);

    public Integer deleteLink(Integer id);
}
