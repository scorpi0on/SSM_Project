package com.ssm.dao;

import com.ssm.po.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDao {
    int getNewsCount(@Param("keywords") String keywords, @Param("newsListCategoryId") Integer newsListCategoryId);
    List<News> findNewsList(@Param("keywords") String keywords, @Param("newsListCategoryId") Integer newsListCategoryId, @Param("startRows") Integer startRows, @Param("pageSize") Integer pageSize);

    News getNewsByNewsId(Integer newsId);
    //返沪插入记录数的整数
    int addNews(News news);
    int updateNews(News news);
    int setNewsPublishStatus(News news);
    int delNews(Integer newsId);
}
