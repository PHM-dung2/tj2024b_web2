import { useState } from "react"

export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    let [ msg, setMsg ] = useState( '' );
    let [ count, setCount ] = useState( 0 );
    
    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        setMsg( event.target.value );
        setCount( event.target.value.length );
        console.log( event.target.value );
        console.log( event.target.value.length );
    }

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={ msg } onChange={ handleChange } />
            <p>글자 수: { count } </p>
        </>
    )
}