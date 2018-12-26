package me.zbl.fullstack.service.api;

import me.zbl.fullstack.entity.vo.PostView;
import me.zbl.fullstack.entity.dto.form.ArticleSearchForm;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.List;

/**
 * 博客服务接口
 *
 * @author czbcxy
 */
public interface IPostsService {

  /**
   * 获取所有博客
   *
   * @return 博客视图实体集合
   */
  @Cacheable(value = "projects")
  List<PostView> getPostList();

  /**
   * 根据日期条件获取博客
   *
   * @param start 起始时间
   * @param end   结束时间
   *
   * @return 博客视图集合
   */
//  @Cacheable(value = "")
  List<PostView> getPostListByDate(Date start, Date end);

  /**
   * 根据 Tag ID 查找文章
   *
   * @param tagId tag ID
   *
   * @return 文章
   */
  @Cacheable(value = "tagList")
  List<PostView> getPostListByTagId(Integer tagId);

  /**
   * 根据 具体条件筛选文章
   *
   * @param form 条件表单
   *
   * @return 文章
   */
  @Cacheable(value = "profileOfInfo")
  List<PostView> getPostListByArticleCondition(ArticleSearchForm form);
}
