import { useEffect, useState } from "react"
import axios from 'axios'

export default function Example2(){

    // [1] 입력받은 데이터를 저장하는 폼 state 변수 , { writer: '', content: '', pwd : '' } 초기값
    const [ formData, setFormData ] = useState( { writer: '', content: '', pwd : '' } );
    // [2] 입력받은 데이터를 렌더링하는 이벤트함수
    const formDataChange = (e) => {
        console.log( e.target ); // 이벤트를 발생한 html dom(마크업/태그)
        console.log( e.target.name ); // 이벤트를 발생한 html dom의 name 속성 값 반환
        console.log( e.target.value ); // 이벤트를 발생한 html dom의 value 속성 값 반환
        // 스프레드 연산자 이용한  state 변수 변경
        // - setXXXX( { ...기존객체, 새로운속성명 : 새로운값 } )
        setFormData( { ...formData, [ e.target.name ] : e.target.value } );
    } // f end
    // [3] 현재 state 변수를 스프링 서버에게 보내기, AXIOS
    const onPost = async ( e ) => {
        try{
            const response = await axios.post( 'http://localhost:8080/day07/react' , formData ); // state변수를 axios보내기
            if( response.data ){ // 만약에 등록 응답이 TRUE이면
                alert('등록성공'); // 알림
                setFormData({ writer: '', content: '', pwd: '' }) // state 초기화
                onFindAll();
            }else{ 
                alert(' 등록실패'); 
            } // if end
        }catch( error ) { console.log( error ); }
    } 

    // [4] 서버에 저장된 방문록정보( 작성자/내용/비밀번호 여러개 ) 요청한다.
        // (1) 컴포넌트 마운트(생성)될 때 최초 1번 실행 함수 // 컴포넌트가 생성될 때 딱 1번 onFindAll
    useEffect( () => { onFindAll() }, [] ); // onFinaAll --> setBoards 끝
    // useEffect( () => { onFindAll() } ); // onFindAll --> setBoards --> onFindAll --> setBoards 무한 렌더링
    // useEffect( () => { onFindAll() }, [ boards ] ); // onFindAll --> setBoards --> onFindAll --> setBoards 무한 렌더링
    
    const [ boards, setBoards ] = useState( [] ); // (2) 여러개의 방문록 가지는 state 변수
    
    const onFindAll = async ( e ) => {
        // (3) 주로 동기 통신 : async( e ) => { await axios.메소드명() }
            // -> 서버의 도메인 같은 경우 : '/day07/react' [오류발생]
            // -> 서버와 도메인 다른 경우 : http://localhost:8080/day07/react [서버도메인까지 작성]
        try{
            const response = await axios.get( 'http://192.168.40.45:8080/day07/react' );
            setBoards( response.data ); // 서버로부터 받은 정보를 state 변수에 저장
        }catch( error ){ console.log( error ); }
    } // f end
  
    return(<>
        <div>
            <h4> 입력 폼 </h4>
            <form>
                작성자 : <input type='text' value={ formData.writer } name='writer' onChange={ formDataChange } /> <br/>
                방문록 : <input type='text' value={ formData.content } name='content' onChange={ formDataChange } /> <br/>
                비밀번호 : <input type='text' value={ formData.pwd } name='pwd' onChange={ formDataChange } /> <br/>
                <button type='button' onClick={ onPost } > 등록 </button>
            </form>

            <table border={1} >
                <thead>
                    <tr>
                        <th> 번호 </th>
                        <th> 작성자 </th>
                        <th> 방문록내용 </th>
                        <th> 비고 </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boards.map( ( board, index ) => {
                            return(
                                <tr key={ index } > 
                                    <td> { index+1 } </td>
                                    <td> { board.writer } </td>
                                    <td> { board.content } </td>
                                    <td> 
                                        <button> 수정 </button> 
                                        <button> 삭제 </button> 
                                    </td>
                                </tr>
                                )
                        }) // map end
                    }
                </tbody>
            </table>
        </div>
    </>)
} // f end