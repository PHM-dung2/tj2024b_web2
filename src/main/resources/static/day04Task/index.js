console.log( 'index.js open' );

// 1. 글쓰기
const onWrite = async () => {
    const title = document.querySelector('.title').value;
    const content = document.querySelector('.content').value;
    const obj = { title, content };

    const response = await axios.post( `/day04/task/board` , obj )
    if( response.data ){ alert('글쓰기 성공'); onFindAll(); }
    else{ alert('글쓰기 실패'); }

} // f end

// 2. 전체 글 조회
const onFindAll = async () => {
    const tbody = document.querySelector('tbody');
    let html = '';

    const response = await axios.get( `/day04/task/board` )
    response.data.forEach( board => {
        console.log( board.bno );
        html += `<tr>
                    <td> ${ board.bno } </td>
                    <td> <a href="index.html?bno=${ board.bno }" > ${ board.title } </a> </td>
                    <td> ${ board.content } </td>
                  </tr>`
        tbody.innerHTML = html;
    })
} // f end
onFindAll();

// 3. 개별 글 조회
const onFind = async ( ) => {
    const pBno = new URLSearchParams(location.search).get('bno');
    const titlediv = document.querySelector('.titlediv');
    const contentdiv = document.querySelector('.contentdiv');
    const btnbox = document.querySelector('.btnbox');

    const response = await axios.get( `/day04/task/board/view?bno=${pBno}` )
    titlediv.innerHTML = response.data.title;
    contentdiv.innerHTML = response.data.content;

    html = `<button type="button" onclick="updateInput(${pBno})"> 수정 </button>
            <button type="button" onclick="onDelete(${pBno})"> 삭제 </button>`
    btnbox.innerHTML = html;

} // f end
onFind( );

// 4. 개별 글 수정
const onUpdate = async ( bno ) => {
    const title = document.querySelector('.titleinput').value;
    const content = document.querySelector('.contentinput').value;
    obj = { title, content };

    const response = await axios.put( `/day04/task/board?bno=${ bno }` , obj )
    if( response.data ){ alert('글수정 성공'); onFindAll(); updateCancle( bno ); }
    else{ alert('글수정 실패'); }
}

// 5. 개별 글 삭제
const onDelete = async ( bno ) => {
    const response = await axios.delete( `/day04/task/board?bno=${bno}` )
    if( response.data ){ alert('글삭제 성공'); onFindAll(); }
    else{ alert('글삭제 실패'); }
}

// 6. 수정 input 생성
const updateInput = ( pBno ) => {
    const titlediv = document.querySelector('.titlediv');
    const contentdiv = document.querySelector('.contentdiv');
    const btnbox = document.querySelector('.btnbox');

    // 현재 제목과 내용을 가져오기
    const title = titlediv.innerText;
    const content = contentdiv.innerText;

    // 기존 내용을 data-* 속성에 저장 (취소 버튼을 눌렀을 때 복원할 값)
    titlediv.setAttribute("data-original", title);
    contentdiv.setAttribute("data-original", content);

    // 입력 필드로 변환
    titlediv.innerHTML = `<input type="text" class="titleinput" value="${title}">`;
    contentdiv.innerHTML = `<input type="text" class="contentinput" value="${content}">`;

    let html = `<button type="button" onclick="onUpdate(${pBno})"> 수정 </button>
                <button type="button" onclick="updateCancle(${pBno})"> 취소 </button>`;
    btnbox.innerHTML = html;
};

// 7. 수정 취소
const updateCancle = ( pBno ) => {
    const titlediv = document.querySelector('.titlediv');
    const contentdiv = document.querySelector('.contentdiv');
    const btnbox = document.querySelector('.btnbox');

    // data-original 속성에서 원래 값을 복원
    const originalTitle = titlediv.getAttribute("data-original");
    const originalContent = contentdiv.getAttribute("data-original");

    titlediv.innerText = originalTitle;
    contentdiv.innerText = originalContent;

    let html = `<button type="button" onclick="updateInput(${pBno})"> 수정 </button>
                <button type="button" onclick="onDelete(${pBno})"> 삭제 </button>`;
    btnbox.innerHTML = html;
};
