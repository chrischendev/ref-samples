package com.chris.elk;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * create by: Chris Chan
 * create on: 2019/7/30 11:53
 * use for:
 */
public interface StuDao extends ElasticsearchRepository<Stu, String> {
}
