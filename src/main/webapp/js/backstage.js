$(document).ready(function(){
    $(".siderbar_menu li").click(function(){
        // 去掉原先的激活类
        $(".siderbar_menu li").removeClass("active");
        $(this).addClass("active");

        // 获取点击的 menu-item 的 data-target 属性
        var target = $(this).find("a").data("target");

        // 隐藏所有页面内容
        $(".page").hide();

        // 显示目标页面内容
        $("#" + target).show();
    });

    $(".hamburger").click(function(){
        $(".wrapper").addClass("active");
    });

    $(".bg_shadow,.close").click(function(){
        $(".wrapper").removeClass("active");
    });
});
