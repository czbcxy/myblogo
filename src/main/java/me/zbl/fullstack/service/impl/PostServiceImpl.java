package me.zbl.fullstack.service.impl;

import me.zbl.fullstack.entity.Article;
import me.zbl.fullstack.entity.vo.PostView;
import me.zbl.fullstack.entity.dto.form.ArticleSearchForm;
import me.zbl.fullstack.mapper.ArticleMapper;
import me.zbl.fullstack.service.api.IPostsService;
import me.zbl.fullstack.service.base.BaseViewTransableService;
import me.zbl.fullstack.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 博客业务实现类
 *
 * @author czbcxy
 */
@Service
public class PostServiceImpl extends BaseViewTransableService<Article, PostView> implements IPostsService {

    @Autowired
    ArticleMapper mPostMapper;

    @Override
    public List<PostView> getPostList() {
        List<Article> hot = mPostMapper.getPostViewAllHotArticles();
        List<Article> newarticles = mPostMapper.getPostViewAllArticlesByToday();
        List<Article> articles = mPostMapper.getPostViewAllArticles();
        List<Article> articles1 = SortingAlgorithm(newarticles, articles);
        hot.addAll(articles1);
        List<PostView> postViewList = transEntityToView(hot);
        return postViewList;
    }

    private List<Article> SortingAlgorithm( List<Article> newarticles,List<Article> articles ){
        List<Article> list = new ArrayList<>();
        List<Integer> randem = BaseUtils.getRandem(newarticles.size());
        randem.forEach(x->list.add(newarticles.get(x)));
        List<Integer> randem1 = BaseUtils.getRandem2(articles.size());
        for (int i = 0; i < randem1.size(); i++) {
            if (list.size()>=15)
                break;
            list.add(articles.get(randem1.get(i)));
        }
        return list;
    }

    @Override
    @Deprecated
    public List<PostView> getPostListByDate(Date start, Date end) {
        return null;
    }

    @Override
    public List<PostView> getPostListByTagId(Integer tagId) {
        List<Article> articlelist = mPostMapper.getArticleListByTagId(tagId);
        List<PostView> postViewList = transEntityToView(articlelist);
        return postViewList;
    }

    @Override
    public List<PostView> getPostListByArticleCondition(ArticleSearchForm form) {
        Article article = new Article();
        article.setTitle(form.getName());
        List<Article> articleList = mPostMapper.getArticleListByCondition(form);
        return transEntityToView(articleList);
    }

    @Override
    protected List<PostView> transEntityToView(List<Article> entityList) {
        List<PostView> postViewsList = new ArrayList<>();
        Iterator it = entityList.iterator();
        while (it.hasNext()) {
            Article article = (Article) it.next();
            PostView postView = new PostView(article);
            postViewsList.add(postView);
        }
        return postViewsList;
    }
}
