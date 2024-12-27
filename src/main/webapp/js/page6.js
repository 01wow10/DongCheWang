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
