<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/backstage.css">
    <!--这里引入的是矢量图标签库-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>

<body>
<div class="wrapper">
    <div class="sidebar">
        <div class="bg_shadow"></div>
        <div class="sidebar_inner">
            <div class="close">
                <i class="fas fa-times"></i>
            </div>
            <div class="profile_info">
                <div class="profile_data">
                    <p class="name">懂车王</p>
                </div>
            </div>

            <ul class="siderbar_menu">
                <li>
                    <a href="#" class="menu-item" data-target="page1">
                        <div class="icon">
                            <i class="fas fa-heart"></i>
                        </div>
                        <div>主页</div>
                    </a>
                </li>
                <li>
                    <a href="#" class="menu-item" data-target="page2">
                        <div class="icon">
                            <i class="fas fa-user"></i>
                        </div>
                        <div>智能推荐ai</div>
                    </a>
                </li>
                <li>
                    <a href="#" class="menu-item" data-target="page3">
                        <div class="icon">
                            <i class="fas fa-receipt"></i>
                        </div>
                        <div>汽车信息查询</div>
                    </a>
                </li>
                <li>
                    <a href="#" class="menu-item" data-target="page4">
                        <div class="icon">
                            <i class="fas fa-credit-card"></i>
                        </div>
                        <div>汽车排行</div>
                    </a>
                </li>
                <li>
                    <a href="#" class="menu-item" data-target="page5">
                        <div class="icon">
                            <i class="fas fa-unlock"></i>
                        </div>
                        <div>汽车资讯</div>
                    </a>
                </li>
                <li>
                    <a href="#" class="menu-item" data-target="page6">
                        <div class="icon">
                            <i class="fas fa-unlock"></i>
                        </div>
                        <div>二手车出租</div>
                    </a>
                </li>
            </ul>
            <div class="logout_btn">
                <a href="#">退出登陆</a>
            </div>
        </div>
    </div>
    <div class="main_container">
        <div class="navbar">
            <div class="hamburger">
                <i class="fas fa-bars"></i>
            </div>
            <div class="logo">
                <a href="header.jsp">主页</a>
            </div>
        </div>
        <div class="content">
            <div id="page1" class="page" style="display: none; font-family: Arial, sans-serif; line-height: 1.8;">
                <h2 style="font-size: 3em; margin-bottom: 30px;">汽车智能推荐系统</h2>
                <p style="font-size: 1.5em; margin-bottom: 30px;">我们的汽车智能推荐系统利用先进的AI技术，为您提供以下主要功能：</p>
                <ul style="font-size: 1.4em; margin-left: 20px;">
                    <li style="margin-bottom: 15px;"><strong>AI智能推荐：</strong>根据用户的驾驶习惯、需求和偏好，自动推荐最适合的汽车品牌、型号和配置。</li>
                    <li style="margin-bottom: 15px;"><strong>汽车信息查询：</strong>用户可以方便地查询汽车的详细信息，包括品牌、价格、性能、燃油效率等各方面数据。</li>
                    <li style="margin-bottom: 15px;"><strong>汽车资讯：</strong>提供最新的汽车行业新闻、技术动态、市场趋势等资讯，让您时刻了解汽车世界的最新动态。</li>
                    <li style="margin-bottom: 15px;"><strong>二手车出租广告：</strong>通过系统，用户可以轻松查看二手车出租信息，找到最适合的出租汽车，支持快捷的筛选与对比。</li>
                </ul>
            </div>


            <div id="page2" class="page" style="display: none;">
                <iframe
                        src="https://bisheng.dataelem.com/chat/assistant/3a2b7843-54b2-40a5-980e-5aecdb07ac12"
                        style="width: 100%; height: 100%; min-height: 700px"
                        frameborder="0"
                        allow="fullscreen;clipboard-write">
                </iframe>
            </div>
            <div id="page3" class="page" style="display: none;">汽车信息查询</div>
            <div id="page4" class="page" style="display: none;">
                <!-- 排行榜按钮区 -->
                <div class="ranking-buttons">
                    <button class="ranking-btn" id="sales-ranking">销量榜</button>
                    <button class="ranking-btn" id="focus-ranking">关注榜</button>
                    <button class="ranking-btn" id="value-retention-ranking">保值榜</button>
                </div>

                <!-- 榜单显示区 -->
                <div class="ranking-content">
                    <div id="sales" class="ranking-list" style="display: none;">
                        <h3 class="ranking-title">销量榜</h3>
                        <ul id="sales-list" class="ranking-items"></ul>
                    </div>
                    <div id="focus" class="ranking-list" style="display: none;">
                        <h3 class="ranking-title">关注榜</h3>
                        <ul id="focus-list" class="ranking-items"></ul>
                    </div>
                    <div id="value-retention" class="ranking-list" style="display: none;">
                        <h3 class="ranking-title">保值榜</h3>
                        <ul id="value_retention-list" class="ranking-items"></ul>
                    </div>
                </div>
            </div>



            <div id="page5" class="page" style="display: none;"> <jsp:include page="newshow.jsp"></jsp:include></div>
            <div id="page6" class="page" style="display: block;">

            </div>
        </div>
    </div>
</div>

<script src="js/backstage.js"></script>
<script>
    $(document).ready(function() {
        // 其他代码...

        // 点击page5事件
        $('a.menu-item[data-target="page5"]').click(function(e) {
            e.preventDefault();
            $('#page5').load('/car_recommendation_war/carNews', function() {
                // 数据加载完成后的回调
                console.log('Data loaded successfully');
            });
            $('.page').hide(); // 隐藏其他页面
            $('#page5').show(); // 显示page5
        });

        // 其他代码...
    });
</script>

</body>

</html>
