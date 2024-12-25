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
$(document).ready(function() {
    // 默认显示销量榜
    $('#sales').show();
    loadRankingData("sales"); // 默认加载销量榜

    // 点击按钮时切换榜单
    $('#sales-ranking').click(function() {
        $('.ranking-list').hide();  // 隐藏所有榜单
        $('#sales').show();         // 显示销量榜
        loadRankingData("sales");
    });

    $('#focus-ranking').click(function() {
        $('.ranking-list').hide();  // 隐藏所有榜单
        $('#focus').show();         // 显示关注榜
        loadRankingData("focus");
    });

    $('#value-retention-ranking').click(function() {
        $('.ranking-list').hide();  // 隐藏所有榜单
        $('#value-retention').show(); // 显示保值榜
        loadRankingData("value_retention");
    });

    // 加载排行榜数据
    function loadRankingData(rankingType) {
        $.ajax({
            url: "get_rank",  // 调用 Servlet
            method: "GET",
            data: { rankingType: rankingType },  // 传递参数
            success: function(data) {
                // 清空当前榜单列表
                $("#" + rankingType + "-list").empty();

                // 设置动态标题
                var rankingTitle = "";
                if (rankingType === "sales") {
                    rankingTitle = "销量";
                } else if (rankingType === "focus") {
                    rankingTitle = "关注量";
                } else if (rankingType === "value_retention") {
                    rankingTitle = "保值率";
                }

                // 添加表格头
                var headerHtml = "<div class='ranking-header'>" +
                    "<span>排名</span>" +
                    "<span>图片</span>" +
                    "<span>车型</span>" +
                    "<span>" + rankingTitle + "</span>" +
                    "</div>";
                $("#" + rankingType + "-list").append(headerHtml);

// 根据返回的数据填充榜单
                data.forEach(function(item, index) {
                    var rank = index + 1;  // 排名是从1开始的

                    // 假设数据库返回的路径是 'D:\\car_recommendation\\src\\main\\webapp\\static\\haiou.jpg'
                    // 你需要将其转换为可以访问的相对路径 '/static/haiou.jpg'
                    var carPhotoPath = item.car_photo.replace("D:\\car_recommendation\\src\\main\\webapp\\static", "/car_recommendation_war ````/static");

                    $("#" + rankingType + "-list").append(
                        "<div class='ranking-item'>" +
                        "<span class='rank'>" + rank + "</span>" +
                        "<img src='" + carPhotoPath + "' alt='" + item.model + "' class='car-photo' />" +
                        "<span class='model'>" + item.model + "</span>" +
                        "<span class='value'>" + item.value + "</span>" +
                        "</div>"
                    );
                });


            },
            error: function(xhr, status, error) {
                console.error("Error fetching ranking data:", error);
            }
        });
    }


});



