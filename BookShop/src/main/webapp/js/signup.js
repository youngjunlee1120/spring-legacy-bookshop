window.addEventListener("load", () => {
    document.getElementById("check_id").addEventListener("click", e => {
      const id = document.querySelector("input[name='id']").value;  
      const xhr = new XMLHttpRequest();

      xhr.open("GET", `check_id/${id}`, false);

      xhr.send();
      if(xhr.status == 200) {
        if(xhr.responseText == "OK") {
        alert("사용 가능한 아이디 입니다.");
      } else {
        alert("이미 다른 사용자가 사용하는 아이디 입니다.");
      }
      } else 
        alert("아이디 중복검사를 할 수 없습니다.")
      
    });


    document.getElementById("signup").addEventListener("click", e => {
        const [form] = document.getElementsByName("signup_form");

    

        if(form.id.value == "") {
            alert("아이디를 입력하셔야 합니다.")
            form.id.focus();
            return;
        }

        if(form.password.value == "") {
            alert("비밀번호를 입력하셔야 합니다.")
            form.password.focus();
            return;
        }

        if(form.name.value == "") {
            alert("성명을 입력하셔야 합니다.")
            form.name.focus();
            return;
        }

       form.submit();
    //    document.signup_form.submit();
    });
});