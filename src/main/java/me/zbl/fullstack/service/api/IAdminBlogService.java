package me.zbl.fullstack.service.api;

import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.Tag;
import me.zbl.fullstack.entity.vo.ArticleDataGridView;
import me.zbl.fullstack.entity.dto.request.TableKeyModel;
import me.zbl.fullstack.entity.dto.form.BlogAddForm;
import me.zbl.fullstack.entity.dto.form.BlogModifyForm;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 后台博客发布接口
 *
 * @author czbcxy
 */
public interface IAdminBlogService {

    /**
     * 添加 文章
     *
     * @param form 表单
     */
    @CacheEvict(value = "blogoInfo")
    void blogAdd(BlogAddForm form);

    /**
     * 根据 id 获取文章
     *
     * @param id id
     * @return 文章实体
     */
    @Cacheable(value = "blogoInfo")
    Article blogSelectByPrimaryKey(Integer id);

    /**
     * 获取所有文章列表
     *
     * @return 文章列表视图实体集合
     */
    List<ArticleDataGridView> getArticleList();

    /**
     * 根据 id 删除文章
     *
     * @param model 数据模型
     */
    @CacheEvict(value = "blogoInfo")
    void blogDelete(TableKeyModel model);

    /**
     * 修改已发布文章
     *
     * @param form 表单
     */
    @CacheEvict(value = "blogoInfo")
    void blogModify(BlogModifyForm form);

    /**
     * 获取tags
     */
    List<Tag> blogSelectTags();
}
