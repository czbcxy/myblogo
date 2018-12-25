<html lang="zh">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://pk8hectkz.bkt.clouddn.com/bitbug_favicon">
    <title>${article.title!'书中人的博客'}</title>

<#-- EditorMD -->
    <link href="/vendor/editor/css/editormd.css" rel="stylesheet">

<#-- 自定义 样式 -->
<#include "public/front_custom_css.ftl">

<#-- CSS -->
<#include "public/front_css.ftl">
</head>

<body>

<#-- s-nav.ftl -->
<#include "public/nav.ftl">
<#-- e-nav.ftl -->

<div class="container container-fluid cus_content">
<#-- 博客标题 -->
    <div class="row mt-md-5"></div>
    <div class="row mt-md-5">
    <#-- 博客内容 -->
        <div class="col-md-8 offset-md-2">
            <h5 class="p-3 font-weight-bold" >${article.title!'标题'}</h5>
            <div class="row pl-3 pr-3">
                <div class="col-md-6"></div>
                <div class="col-md-6 text-md-right">
                    <p class="small text-secondary" style="font-size: 15px;color: #5c5855">${article.dateTime!""}</p>
                </div>
            </div>
        ${article.htmlMaterial!'文章内容'}
        </div>
    </div>
    <div class="row mb-md-5"></div>
</div>


<#-- s-footer -->
<#include "public/footer.ftl">
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">
</body>
</html>
