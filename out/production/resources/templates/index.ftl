<html lang="zh">
<#-- 博客列表页 -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${articleTitle!'书中人'}</title>

<#-- EditorMD -->
    <link href="/vendor/editor/css/editormd.css" rel="stylesheet">

<#-- landing-page -->
    <link rel="stylesheet" href="/vendor/landing-page/landing-page.min.css">

<#-- 自定义 样式 -->
<#include "public/front_custom_css.ftl">

<#-- CSS -->
<#include "public/front_css.ftl">
</head>

<body>

<#assign page_index = 1>
<#-- s-nav.ftl -->
<#include "public/nav.ftl">
<#-- e-nav.ftl -->
<!-- 落地页 -->
<#--<header class="masthead text-white text-center"-->
        <#--style="background-image: url('http://blackrockdigital.github.io/startbootstrap-clean-blog/img/home-bg.jpg')">-->
    <#--<div class="overlay"></div>-->
    <#--<div class="container">-->
        <#--<div class="row">-->
            <#--<div class="col mx-auto text-left pl-5">-->
                <#--<h1>书中人-BLOGO</h1>-->
                <#--<h3>初问不识书中意，再读已是书中人</h3>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</header>-->
<div class="container container-fluid mt-5 mb-5">
<#--<img src="http://blackrockdigital.github.io/startbootstrap-clean-blog/img/home-bg.jpg" alt="">-->
    <div class="row">
        <div class="col-md-1">
        </div>
    <#-- s 左侧 -->
        <div class="col-md-7">
            <ul class="list-unstyled">
            <#if postlist??>
                <div style="height: 30px"></div>
                <#if (postlist?size>0)>
                    <#list postlist as post>
                        <div style="font-family: "Microsoft YaHei", Helvetica, "Meiryo UI", "Malgun Gothic", "Segoe UI", "Trebuchet MS", "Monaco", monospace, Tahoma, STXihei, "华文细黑", STHeiti, "Helvetica Neue", "Droid Sans", "wenquanyi micro hei", FreeSans, Arimo, Arial, SimSun, "宋体", Heiti, "黑体", sans-serif">
                            <a href="/blog/${post.id!""}" class="text-dark" target="_parent">
                                <h5 style="font-size: 20px;">${post.title!""} </h5>
                            </a>
                            <p style="color:#868e96,font-family: "Microsoft YaHei", Helvetica, "Meiryo UI", "Malgun Gothic", "Segoe UI", "Trebuchet MS", Monaco, monospace, Tahoma, STXihei, "华文细黑", STHeiti, "Helvetica Neue", "Droid Sans", "wenquanyi micro hei", FreeSans, Arimo, Arial, SimSun, "宋体", Heiti, "黑体", sans-serif;">&nbsp;&nbsp;&nbsp;&nbsp;${post.description}&nbsp;......</p>
                            <p style="text-align:right;">
                                <small>
                                   | 阅读量:${post.seeCount!""} | 创建时间：${post.dateTime!""} |
                                </small>
                            </p>
                        </div>
                        <hr>
                    </#list>
                <#else>
                    <div class="card border-danger mt-3 mb-3">
                        <div class="card-body text-danger">
                            <h2 class="card-title"><i class="fa fa-warning fa-1x"></i> 抱歉，没有找到相关内容</h2>
                            <p class="card-text">试试其他关键字？</p>
                        </div>
                    </div>
                </#if>
            </#if>
            </ul>
        </div>
    <#-- e 左侧 -->
    <#-- s 右侧 -->
        <div class="col-md-4 mt-3">
            <div class="card mb-3">
                <div class="card-header">
                    搜索文章
                </div>
                <div class="card-body">
                    <form action="/postsearch">
                        <div class="input-group">
                            <input name="name" type="text" class="form-control" placeholder="输入你想查找的题目..."
                                   aria-label="输入你想查找的题目...">
                            <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit">搜索</button>
                    </span>
                    </form>
                </div>
            </div>
        </div>
    <#if taglist??>
        <div class="card mb-3">
            <div class="card-header">
                热门标签
            </div>
            <div class="card-body">
                <#list taglist as tag>
                    <!-- tag -->
                    <a href="/index?tagId=${tag.tagId!''}" target="_parent">
                        <button type="button" class="btn btn-outline-primary mb-3">
                        ${tag.tagName!""} <span class="badge badge-primary">${tag.articleCount!""}</span>
                        </button>
                    </a>
                </#list>
            </div>
        </div>
    </#if>
    <#-- e 右侧 -->
    </div>
</div>
</div>

<style>
    .card-body a:{
        font-family: "Microsoft YaHei", Helvetica, "Meiryo UI", "Malgun Gothic", "Segoe UI", "Trebuchet MS", "Monaco", monospace, Tahoma, STXihei, "华文细黑", STHeiti, "Helvetica Neue", "Droid Sans", "wenquanyi micro hei", FreeSans, Arimo, Arial, SimSun, "宋体", Heiti, "黑体", sans-serif;
        font-size: small;
    }
</style>


<#-- s-footer -->
<#include "public/footer.ftl">
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">
</body>
</html>
