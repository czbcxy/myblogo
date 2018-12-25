<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title!'书中人的博客'}</title>

    <!-- Custom styles for this template -->
    <link href="/css/full-slider/full-slider.css" rel="stylesheet">

<#-- 自定义 样式 -->
<#include "public/front_custom_css.ftl">

<#-- CSS -->
<#include "public/front_css.ftl">
</head>

<body>
<#assign page_index = 0>
<#-- s-nav.ftl -->
<#include "public/nav.ftl">
<#-- e-nav.ftl -->

<#-- s-slide-header -->
<header>
    <div id="slideIndicators" class="carousel slide" data-ride="carousel" data-interval="3000" data-pause="">
        <ol class="carousel-indicators">
            <li data-target="#slideIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#slideIndicators" data-slide-to="1"></li>
            <li data-target="#slideIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active"
                 style="background-image: url('https://goss.veer.com/creative/vcg/veer/1600water/veer-310166551.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3 class="txt_shadow">你所有不努力的借口都是自欺欺人</h3>
                    <p class="txt_shadow">You don't work hard all excuses are deluding themselves .</p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item"
                 style="background-image: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545193047980&di=f37f8a63e47b4a060392ea917f669a04&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fc8ea15ce36d3d539dfa9dd173087e950342ab04a.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3 class="txt_shadow">若去时无人道声珍重，愿归时无人落笔剧终</h3>
                    <p class="txt_shadow">When go to no humanitarian care, may be the end of the no one to put pen to paper . </p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item"
                 style="background-image: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545193047977&di=aefa18c7987a676294d173a18d10b077&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F32fa828ba61ea8d342dca8d09d0a304e241f586c.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3 class="txt_shadow">你们中大多数人都熟悉程序员的美德，有三种：那就是懒惰、急躁和傲慢</h3>
                    <p class="txt_shadow">Most of you are familiar with the programmer's virtues, and there are three: laziness,
                        impatience, and arrogance. </p>
                </div>
            </div>
        </div>
</header>
<#-- e-slide-header-->
<div>
    <marquee behavior="alternate">人生如逆旅，我亦是行人</marquee>
</div>
<!-- Page Content -->
<section class="py-5">
    <h6 align="center">2019年我的目标就是完成2018年那些本该在2017年完成的我在2016年就信誓旦旦要完成2015年制定的目标</h6>
    <#--<marquee behavior="scroll" scrolldelay="20" direction="up" height="300" bgcolor="#D3D3D3">-->
    <div class="container container-fluid" style="text-align:center">
        <table id="mytable" cellspacing="0" summary="2018年度总评" style="margin: auto; width:100%">
            <tr>
                <th scope="col" abbr="项目" >项目</th>
                <th scope="col" abbr="进度">进度</th>
                <th scope="col" abbr="评价">评价</th>
            </tr>
            <tr>
                <th scope="row" abbr="Model" class="spec">坚持读书</th>
                <td>70%</td>
                <td>良好</td>
            </tr>
            <tr>
                <th scope="row" abbr="G5 Processor" class="specalt">顺利工作</th>
                <td class="alt">70%</td>
                <td class="alt">良好</td>
            </tr>
            <tr>
                <th scope="row" abbr="Frontside bus" class="spec">锻炼身体</th>
                <td>50%</td>
                <td>不及格</td>
            </tr>
            <tr>
                <th scope="row" abbr="L2 Cache" class="specalt">学历提升</th>
                <td class="alt">80%</td>
                <td class="alt">良好</td>
            </tr>
            <tr>
                <th scope="row" abbr="L2 Cache" class="specalt">专业技能</th>
                <td class="alt">70%</td>
                <td class="alt">良好</td>
            </tr>
            <tr>
                <th scope="row" abbr="L2 Cache" class="specalt">旅游</th>
                <td class="alt">70%</td>
                <td class="alt">良好</td>
            </tr>
            <#--<tr>-->
            <#--<th scope="row" abbr="L2 Cache" class="specalt">找个对象</th>-->
            <#--<td class="alt">----</td>-->
            <#--<td class="alt">----</td>-->
            <#--</tr>-->
            <#--<tr>-->
            <#--<th scope="row" abbr="L2 Cache" class="specalt">买房</th>-->
            <#--<td class="alt">20%</td>-->
            <#--<td class="alt">不及格</td>-->
            <#--</tr>-->
                <tr>
                    <th scope="row" abbr="L2 Cache" class="specalt">考驾照</th>
                    <td class="alt">100%</td>
                    <td class="alt">优秀</td>
                </tr>
            <#--<tr>-->
            <#--<th scope="row" abbr="L2 Cache" class="specalt">买车</th>-->
            <#--<td class="alt">30%</td>-->
            <#--<td class="alt">不及格</td>-->
            <#--</tr>-->
        </table>
    </div>
    <#--</marquee>-->
</section>

<#-- s-footer -->
<#include "public/footer.ftl">
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">
</body>
</html>
