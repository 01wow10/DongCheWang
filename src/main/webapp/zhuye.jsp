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
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
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
                <div class="profile_img">
                    <img src="images/logo_logo.png" alt="">
                </div>
                <div class="profile_data">
                    <p class="name">懂车王</p>
                    <span>
                            <i class="fas fa-map-marker-alt"></i>
                            用户名
                        </span>
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
                        <div>暂无</div>
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
                <a href="header.jsp">主页logo</a>
            </div>
        </div>
        <div class="content">
            <div id="page1" class="page" style="display: none;">主页内容</div>
            <div id="page2" class="page" style="display: none;">
                <iframe
                        src="https://bisheng.dataelem.com/chat/assistant/3a2b7843-54b2-40a5-980e-5aecdb07ac12"
                        style="width: 100%; height: 100%; min-height: 700px"
                        frameborder="0"
                        allow="fullscreen;clipboard-write">
                </iframe>
            </div>
            <div id="page3" class="page" style="display: none;">投稿信息内容</div>
            <div id="page4" class="page" style="display: none;">占个位置内容</div>
            <div id="page5" class="page" style="display: none;">占个位置内容</div>
        </div>
    </div>
</div>

<script src="js/backstage.js"></script>
</body>

</html>
