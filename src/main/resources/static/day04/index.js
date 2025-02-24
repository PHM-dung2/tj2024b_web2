console.log("index.js open");

// [4] 개별 삭제 함수
const onDelete = async ( sno ) => {
    // (1) 삭제할 번호 : sno
    // (2) axios 통신
    const response = await axios.delete( `/day04/student?sno=${ sno }` )
    if( response.data == 1 ){ alert('삭제 성공'); onFindAll(); } // 만약에 ���� 내용이 1이면 ��제 성공 ->
    else{ alert('삭제 실패') }
} // f end

// [3] 개별 수정 함수
const onUpdate = async ( sno ) => {
    // (1) 수정할 값 받기
    const name = prompt('새로운 이름');
    const kor = prompt('새로운 국어점수');
    const math = prompt('새로운 수학점수');
    // (2) 객체화
    const obj = { sno , name , kor , math }
    // (3) axios 통신
    const response = await axios.put( '/day04/student' , obj )
    console.log( response.data )
    if( response.data == 1 ){ alert('수정 성공'); onFindAll(); } // 만약에 응답 내용이 1이면 수정 성공 -> 전체 조회함수 실행
    else{ alert('수정 실패') }
} // f end

// [2] 전체 조회 함수
const onFindAll = async () => {
    try{
        const response = await axios.get( '/day04/student' )
        console.log( response.data ) // response 응답(정보) 객체 , response.data : 응답깨체 내 본문내용

        const tbody = document.querySelector('tbody')
        let html = ''
            response.data.forEach( student => {
                html += `<tr>
                            <td>${ student.name }</td>
                            <td>${ student.kor }</td>
                            <td>${ student.math }</td>
                            <td>
                                <button onclick="onUpdate(${student.sno})">수정</button>
                                <button onclick="onDelete(${student.sno})">삭제</button>
                            </td>
                        </tr>`
            })
        tbody.innerHTML = html;
    }catch( e ) { console.log( e ); }
} // f end
onFindAll(); // 전체조회 함수 실행

// [1] 등록 함수
const onSave = () => {
    // (1)
    const name = document.querySelector('.name').value;
    const kor = document.querySelector('.kor').value;
    const math = document.querySelector('.math').value;
    // (*) 객체{}  선언할 때 대입할 변수명이 객체의 필드명과 동일하면 생략가능
    // const obj = { name : name, kor : kor, math : math }
    const obj = { name, kor, math };
    console.log(obj);

    // (*) fetch 대신 axios 활용한 비동기 통신 vs 동기화 통신
    axios.post( '/day04/student' , obj)
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log(e); })


    // (*) Fetch( JS 내장함수 ) vs Axios( 기본값 JSON ) vs $.ajax(JQUERY)
        // 1. axios 설치 : HTML에 AXIOS CDN 코드 넣어준다. <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        // 2. axios 문법
            // 1. axios.[HTTP메소드드명].() : axios.get() , axios.post() , axios.put(), axios.delete()
            // 2. .('통신할HTTP주소' , {옵션} )

    // (1) fetch와 비슷한 구조의 axios 사용하는 방법
    // axios.post( '/day04/student' )
    //     .then( response => { console.log( response.data ) })
    //     .catch( e => { console.log(e); })

    // (2)
    // console.log('axios 실행 전'); // 1. 첫번째 콘솔
    // axios.post( 'day04/student', obj )
    //     .then( response => { console.log( response.data ) }) // 2. 두번째 콘솔
    //     .catch( e => { console.log(e); }) // 3. 세번째 콘솔
    // console.log('axios 실행 후')
    // 첫번째 콜솔 --> 세번째 콘솔 --> 두번째 콘솔 : why?
    // 비동기 콩신( JS는 axios요청 보낸 후에 응답을 기다리지 않고 다음 코드 실행 )
    // 예) 카페에서 '커피' 하나 주문할 사맘과 '커피1/빵10개/파스타1' 주문 사람 중 누가 먼저 응답올까? => 사람님 마음
    // (비동기) :먼저 처리/응답된 순서대로 처리한다. '커피' 먼저 나온다.
    // (동기) : 앞에 있는 처리가 읍답/처리 올때까지 다음 요청을 대기상태

    // (3)
    // console.log('axios 실행 전'); // 1. 첫번째 콘솔
    // axios.post( 'day04/student', obj )
    // console.log( response.data ) // 2. 두번째 콘솔
    // console.log('axios 실행 후') // 3. 세번째 콘솔
    // 실행순서 : 첫번째 콘솔 --> 두번째 콘솔 --> 세번째 콘솔 : why?
    // axios의 응답값이 반환 되기전에 두번째 콘솔 출력된다.

    // (4) 동기화 방법 = 필요에 따라 vs 비동기 방법 = 기본값
        // 동기화 : await 함수명( )
    // console.log('axios 실행 전'); // 1. 첫번째 콘솔
    // const response = await axios.post('/day04/student' , obj)
    // console.log( response.data ) // 2. 두번째 콘솔
    // console.log('axios 실행 후') // 3. 세번째 콘솔

    // (2)
    /*
    option = {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify(obj)
    }
    fetch( '/day04/student' , option )
        ,then( r => r.json())
        .then( data => console.log( data ))
        .catch( e =>  { console.log(e); })
    */


} // f end


