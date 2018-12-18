<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title!'书中人 - 鸿蒙空间'}</title>

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
<#--<header>-->
    <#---->
<#--</header>-->
<#-- e-slide-header-->

<!-- Page Content -->
<section class="py-5">
    <br>
    <marquee behavior="alternate" bgcolor="#FFEFD5">人生如逆旅，我亦是从行人。</marquee>
    <br>
    <marquee behavior="scroll" scrolldelay="30" direction="up" height="300" bgcolor="#D3D3D3">
    <div class="container container-fluid" style="text-align:center">
        <header>2019年我的目标就是完成2018年那些本该在2017年完成的我在2016年就信誓旦旦要完成2015年制定的目标</header>
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
    </marquee>
</section>

<#-- s-footer -->
<#include "public/footer.ftl">
<#-- e-footer -->

<#-- JS -->
<#include "public/front_js.ftl">
</body>
</html>
