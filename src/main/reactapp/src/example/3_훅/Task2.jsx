import { useState } from "react";

/* 
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : '이름'이랑 '전화번호' 입력받아 배열에 저장
        조건2 : '저장도니 배열 내 모든 정보(이름/전호번호)를 table 또는 ol 또는 ul로 모두 출력하시오
        조건3 : useState 사용
*/

const TableCom = ( props ) => {
    return(<>
        <tr>
            <td>{ props.no }</td>
            <td>{ props.name }</td>
            <td>{ props.phone }</td>
        </tr>
    </>)
} // f end

export default function Task2( props ){

    let [ arr, setArr ] = useState( [] );

    let [ msg, setMsg ] = useState( '' );
    let [ msg2, setMsg2 ] = useState( '' );

    const inputFunc = (event) => {
        setMsg( event.target.value );
        console.log( msg );
    } // f end

    const inputFunc2 = (event) => {
        setMsg2( event.target.value );
        console.log( msg2 );
    } // f end

    const saveFunc = () => {
        const obj = { name : msg, phone : msg2 };
        setArr( [ ...arr, obj ] );
        console.log( arr );
    }

    return(<>
        <span>이름 : </span><input value={ msg } onChange={ inputFunc } /> <br/>
        <span>전화번호 : </span><input value={ msg2 } onChange={ inputFunc2 } /> <br/>
        <button typr="button" onClick={ saveFunc } > 등록 </button>

        <table border={1}>
            <thead>
                <tr>
                    <th> 번호 </th>
                    <th> 이름 </th>
                    <th> 전화번호 </th>
                </tr>
            </thead>
            <tbody>
                {
                    arr.map(
                        ( item, index ) =>
                        ( <TableCom key={index} no={index+1} name={item.name} phone={item.phone} />)
                    )
                }
            </tbody>
        </table>
    </>)
} // f end


