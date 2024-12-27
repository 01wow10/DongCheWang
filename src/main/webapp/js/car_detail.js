document.addEventListener('DOMContentLoaded', function() {
    // 获取所有菜单项
    const menuItems = document.querySelectorAll('.menu-item');
    // 获取所有页面内容
    const pages = document.querySelectorAll('.page');

    // 为每个菜单项添加点击事件监听器
    menuItems.forEach(item => {
        item.addEventListener('click', function(event) {
            event.preventDefault(); // 阻止默认的链接跳转行为

            // 获取目标页面的 ID
            const targetId = this.getAttribute('data-target');

            // 隐藏所有页面
            pages.forEach(page => {
                page.style.display = 'none';
            });

            // 显示目标页面
            const targetPage = document.getElementById(targetId);
            if (targetPage) {
                targetPage.style.display = 'block';
            }
        });
    });

    // 获取汉堡菜单按钮
    const hamburger = document.querySelector('.hamburger');
    // 获取侧边栏
    const sidebar = document.querySelector('.sidebar');

    // 为汉堡菜单按钮添加点击事件监听器
    hamburger.addEventListener('click', function() {
        // 切换侧边栏的显示状态
        sidebar.classList.toggle('active');
    });

    // 获取关闭按钮
    const closeBtn = document.querySelector('.close');

    // 为关闭按钮添加点击事件监听器
    closeBtn.addEventListener('click', function() {
        // 隐藏侧边栏
        sidebar.classList.remove('active');
    });

    // 初始化时显示默认页面（例如 page1）
    const defaultPage = document.getElementById('page1');
    if (defaultPage) {
        defaultPage.style.display = 'block';
    }
});
