package me.zbl.fullstack.service.api;

import me.zbl.fullstack.entity.vo.TagView;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 文章标签相关业务接口
 *
 * @author czbcxy
 */
public interface ITagService {

  /**
   * 获取所有 Tag 视图
   *
   * @return Tag 视图
   */
  @Cacheable(value = "tagListView")
  List<TagView> getAllTagView();
}
