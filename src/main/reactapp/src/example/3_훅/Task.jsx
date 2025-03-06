import { useState } from "react"

export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    // const [ 변수명 , set변수명 ] = useState(초기값)
        // - 변수명 : 아무거나(임의)
        // - set변수명 : set변수명(카멜표기법)
            // -> set변수명( 새로운값 )
        // - = useState( 초기값 ) : 모든 타입의 자료 가능하다.
    let [ msg, setMsg ] = useState( '' );
    // let [ count, setCount ] = useState( 0 );

    let [ msgList , setMsgList ] = useState( [] );
    const 저장함수 = () => {
        // msgList.push( msg ); // 입력받은 값이 저장된 state인 'msg'를 msgList 저장
        // setMsgList( msgList ); 

        // 기본차입 자료는 리터럴이라서 그 값 그 자체 -> 기본타입 자료가 변경되면 그 값 그 자체 변경
        // 참조타입( 포장지 ) 자료는 안에 있는 자료가 변경해도 -> 참조타입 자체는 변경되지 않았다.
        // 가방( 핸드폰 = 삼성, 지갑 ), 변경 핸드폰을 애플로 변경 , 가방( 핸드폰 = 애플, 지갑 ) 
            // -> 새로운 가방 // 기존 가방 복제/복사
            // 복사 방법 : 1. map 2. ...스프레드 연산자 3. pre
        setMsgList( [...msgList, msg] );
        // setMsgList( (msgList) => [...msgList, msg] );
    } // f end

    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        setMsg( event.target.value );
        console.log( event.target.value );
        // setCount( event.target.value.length );
        // console.log( event.target.value.length );
    } // f end

    console.log( msgList ); // 확인

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={ msg } onChange={ handleChange } />
            <p>글자 수: { msg.length } </p>

            <h1>입력받은 값 배열에 저장</h1>
            <button onClick={ 저장함수 } > 저장 </button> 
        </>
    ) // f end
}