document.addEventListener("DOMContentLoaded", () => {
  let modal = document.querySelector("div#modal");
  modal.querySelector("span").addEventListener("click", (e) => {
    modal.style.display = "none";
  });
  document.querySelector("form#book_input").addEventListener("keydown", (e) => {
    let key = e.key;
    let tagName = e.target.tagName;
    let id = e.target.id;
    if (key === "Enter" && tagName === "INPUT") {
      let text = e.target.value;

      if (id === "bk_ccode") {
        // ${rootPath}/comp/list 로 데이터 request(요청)을한다
        fetch(`${rootPath}/comp/list`)
          // 실행결과 데이터를 통채로 응답(response)받음
          .then((res) => {
            // 응답받은 데이터를 text부분만 분리
            return res.text();
          })
          .then((result) => {
            let div = document.createElement("div");
            // html 규격에 맞게 result 데이터를 변형
            div.innerHTML = result;
            modal.appendChild(div);
          });

        modal.style.display = "block";
      } else if (id === "bk_acode") {
        modal.style.display = "block";
      }
    }
  });
});
