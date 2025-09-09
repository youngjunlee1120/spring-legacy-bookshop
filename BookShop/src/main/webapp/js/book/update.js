window.addEventListener("load", () => {
    document.querySelectorAll(".delete").forEach(item => {
        item.addEventListener("click", e => {
            const { code } = e.target.dataset;
            alert(code);

            //book/attach/delete/123
            fetch(`../attach/delete/${code}`)
            .then(resp => {
                if(resp.ok) {
                    alert("삭제되었습니다.");
                }
            }).catch(err => alert(err))
        });
    });
});