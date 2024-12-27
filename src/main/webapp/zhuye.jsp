<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <link rel="stylesheet" href="css/page6.css">
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
                <a href="header.jsp">主页logo</a>
            </div>
        </div>
        <div class="content">
            <div id="page1" class="page" style="display: none;">
                介绍用户系统主要功能
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
            <div id="page4" class="page" style="display: none;">汽车排行</div>
            <div id="page5" class="page" style="display: none;">汽车资讯</div>
            <div id="page6" class="page">
                <h1>汽车列表</h1>
                <table border="1">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>品牌</th>
                        <th>公里数</th>
                        <th>车龄</th>
                        <th>价格</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="car" items="${cars}">
                        <tr>
                            <td>${car.id}</td>
                            <td>${car.brand}</td>
                            <td>${car.mileage}</td>
                            <td>${car.age}</td>
                            <td>${car.price}</td>
                            <td><a href="car-detail?id=${car.id}">查看详情</a></td>
                        </tr>
                    </c:forEach>
                    <!-- 数据将通过 JavaScript 动态插入 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="js/backstage.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        // 默认显示主页
        document.getElementById('page1').style.display = 'block';

        // 获取所有菜单项
        const menuItems = document.querySelectorAll('.menu-item');

        // 为每个菜单项添加点击事件监听器
        menuItems.forEach(item => {
            item.addEventListener('click', function (event) {
                event.preventDefault(); // 阻止默认行为

                // 获取目标页面的 ID
                const targetId = this.getAttribute('data-target');

                // 隐藏所有页面内容
                document.querySelectorAll('.page').forEach(page => {
                    page.style.display = 'none';
                });

                // 显示目标页面内容
                document.getElementById(targetId).style.display = 'block';

                // 如果需要发送 GET 请求，可以在这里添加 AJAX 请求
                if (targetId === 'page6') {
                    fetchCarsData();
                }
            });
        });

        // 模拟获取汽车数据的函数
        function fetchCarsData() {
            console.log('Fetching cars data...');
            fetch('/EX04_war/get-cars')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    console.log('Received data:', data);
                    const carTableBody = document.querySelector('#page6 table tbody');
                    console.log('Selected table body:', carTableBody);

                    if (!carTableBody) {
                        console.error('Table body element not found');
                        return;
                    }

                    carTableBody.innerHTML = ''; // 清空现有表格内容

                    if (!data || data.length === 0) {
                        console.warn('No data to display');
                        return;
                    }

                    data.forEach(car => {
                        console.log('Processing car:', car); // 打印每个汽车对象

                        if (!car || typeof car !== 'object') {
                            console.error('Invalid car object:', car);
                            return;
                        }

                        if (!car.id || !car.brand || !car.mileage || !car.age || !car.price) {
                            console.error('Car object missing required fields:', car);
                            return;
                        }

                        const row = document.createElement('tr');

                        const idCell = document.createElement('td');
                        idCell.textContent = car.id;
                        row.appendChild(idCell);

                        const brandCell = document.createElement('td');
                        brandCell.textContent = car.brand;
                        row.appendChild(brandCell);

                        const mileageCell = document.createElement('td');
                        mileageCell.textContent = car.mileage;
                        row.appendChild(mileageCell);

                        const ageCell = document.createElement('td');
                        ageCell.textContent = car.age;
                        row.appendChild(ageCell);

                        const priceCell = document.createElement('td');
                        priceCell.textContent = car.price;
                        row.appendChild(priceCell);

                        const detailCell = document.createElement('td');
                        const detailLink = document.createElement('a');
                        detailLink.href = `car-detail?id=${car.id}`;
                        detailLink.textContent = '查看详情';
                        detailCell.appendChild(detailLink);
                        row.appendChild(detailCell);

                        carTableBody.appendChild(row);
                        console.log('Row appended:', row.outerHTML); // 打印插入的行
                    });
                    console.log('Final table body:', carTableBody.innerHTML); // 打印最终的表格
                })
                .catch(error => console.error('Error fetching cars:', error));
        }



    });

</script>

</body>

</html>
