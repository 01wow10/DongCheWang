function judgement(){
    let username=document.getElementById("username").value;
    let password=document.getElementById("password").value;
    let data = { 'username': username, 'password': password };
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "User_Entry_Judgement", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function() {
        if (xhr.status === 200) {
            let response = JSON.parse(xhr.responseText);
            if(response.message==="false"){
                alert('用户名或密码错误！');
            }
            else {
                window.location.href = "zhuye.jsp";
            }
        }
    };
    xhr.send(JSON.stringify(data));
}