document.addEventListener("DOMContentLoaded", () => {
  let modal = document.querySelector("div#modal");
  modal.querySelector("span").addEventListener("click", (e) => {
    // 임의로 생성된 div_search box 는 modal과 별개로 생성하였으므로
    // div_search box 를 remove하고 modal을 감춘다.
    document.querySelector("div#div_search").remove();
    modal.style.display = "none";
  });

  document.querySelector("form#book_input").addEventListener("keydown", (e) => {
    let key = e.key;
    let tagName = e.target.tagName;
    let id = e.target.id;
    let className = e.target.className;

    if (key === "Enter" && tagName === "INPUT") {
      let text = e.target.value;

      let urlPath = rootPath;
      if (id === "bk_ccode") {
        urlPath += `/comp/search?cp_title=${text}`;
      } else if (id === "bk_acode") {
        urlPath += `/author/search?au_name=${text}`;
      }
      if (className === "search") {
        // ${rootPath}/comp/list 로 데이터 request(요청)을한다
        fetch(urlPath)
          // 실행결과 데이터를 통채로 응답(response)받음
          .then((res) => {
            // 응답받은 데이터를 text부분만 분리
            return res.text();
          })
          .then((result) => {
            // 새로운 element(tag)
            let div = document.createElement("div");
            // html 규격에 맞게 result 데이터를 변형
            // 본문내용 추가
            div.innerHTML = result;
            // id 추가
            div.setAttribute("id", "div_search");
            document.querySelector("body").appendChild(div);
            modal.style.display = "block";
          });
      }
    }
  });

  document
    .querySelector("form#book_input button.btn_save")
    .addEventListener("click", (e) => {
      let form = document.querySelector("form#book_input");

      let bk_isbn = form.querySelector("input#bk_ISBN");
      let bk_title = form.querySelector("input#bk_title");
      let bk_ccode = form.querySelector("input#bk_ccode");
      let bk_acode = form.querySelector("input#bk_acode");
      let bk_date = form.querySelector("input#bk_date");
      let bk_price = form.querySelector("input#bk_price");
      let bk_pages = form.querySelector("input#bk_pages");

      // front 단에서 유효성 검사
      if (bk_isbn.value === "") {
        alert("ISBN은 반드시 입력하세요");
        bk_isbn.focus();
        return false;
      }

      if (bk_isbn.value.length !== 13) {
        alert("ISBN은 13자리 이어야 합니다");
        bk_isbn.focus();
        return false;
      }

      if (bk_title.value === "") {
        alert("도서명은 반드시 입력하세요");
        bk_title.focus();
        return false;
      }

      // 여기 도착하면 유효성 검사 모두 통과
      // form에 담긴 데이터를 서버로 req하는데 front에서는 submit 한다 라고 표현한다.
      form.submit();
    });
});
