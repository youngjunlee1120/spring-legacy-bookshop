let check_id = false;

window.addEventListener("load", () => {
  document.querySelectorAll(".pwd").forEach(item => {
      const input = item.querySelector("input[type='password']");
      const button = item.querySelector(".view");
      
      button.addEventListener("mousedown", () => {
        input.setAttribute("type","text");
      });

      button.addEventListener("mouseup", () => {
        input.setAttribute("type","password");
      });

      button.addEventListener("mouseleave", () => {
        input.setAttribute("type","password");
      });
  });

  document.querySelector("input[name='id']").addEventListener("change", e => {
    check_id = false;
  });

  document.getElementById("check_id_fetch").addEventListener("click", e => {
    const button = e.target;
    const id = document.querySelector("input[name='id']").value;
    button.setAttribute("disabled", true);

    fetch(`check_id/${id}`, {
      method: "GET",
    }).then(resp => {
       button.removeAttribute("disabled");
      if(resp.ok)
        return resp.text();
      else
       throw new Error("[fetch] 아이디 중복검사를 할 수 없습니다.")
    })
    .then(result => {
        if(result == "OK") {
           alert("[fetch] 사용 가능한 아이디 입니다.");
           check_id = true;
        } else {
          alert("[fetch] 이미 다른 사용자가 사용하는 아이디 입니다.");
        }
    }).catch(e => alert(e));
  });


  document.getElementById("check_id").addEventListener("click", e => {
    const id = document.querySelector("input[name='id']").value;
    const xhr = new XMLHttpRequest();

    xhr.open("GET", `check_id/${id}`, false);

    xhr.send();
    if (xhr.status == 200) {
      if (xhr.responseText == "OK") {
        alert("[동기] 사용 가능한 아이디 입니다.");
        check_id = true;
      } else {
        alert("[동기] 이미 다른 사용자가 사용하는 아이디 입니다.");
      }
    } else
      alert("[동기] 아이디 중복검사를 할 수 없습니다.");

  });

  document.getElementById("check_id_async").addEventListener("click", e => {
    const button = e.target;
    const id = document.querySelector("input[name='id']").value;

    button.setAttribute("disabled", true);

    const xhr = new XMLHttpRequest();

    xhr.open("GET", `check_id/${id}`, true);

    xhr.onreadystatechange = () => {
      if (xhr.readyState == xhr.DONE) {
        button.removeAttribute("disabled");

        if (xhr.status == 200) {
          if (xhr.responseText == "OK") {
            alert("[비동기] 사용 가능한 아이디 입니다.");
            check_id = true;
          } else {
            alert("[비동기] 이미 다른 사용자가 사용하는 아이디 입니다.");
          }
        } else
          alert("[비동기] 아이디 중복검사를 할 수 없습니다.");
      }
    }

    xhr.send();
  });


  document.getElementById("signup").addEventListener("click", e => {
    const [form] = document.getElementsByName("signup_form");



    if (form.id.value == "") {
      alert("아이디를 입력하셔야 합니다.");
      form.id.focus();
      return;
    }

    if(!check_id) {
      alert("아이디 중복 검사를 하셔야 합니다.");
      return;
    }

    if (form.password.value == "") {
      alert("비밀번호를 입력하셔야 합니다.");
      form.password.focus();
      return;
    }

    if (form.password.value !== form.check_password.value) {
      alert("비밀번호와 비밀번호 확인이 일치하도록 입력하셔야 합니다.");
      form.check_password.value = "";
      form.check_password.focus();
      return;
    }

    if (form.name.value == "") {
      alert("성명을 입력하셔야 합니다.");
      form.name.focus();
      return;
    }

    form.submit();
    //    document.signup_form.submit();
  });
});