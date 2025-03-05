// (1)
export default function Example1( props ){

    // ================== JSX 문법 s ================== // 
    return(
        <div>
            {/* 주석 내용물 */}
            <h3> 컴포넌트 </h3>
            {/* 다른 컴포넌트 호출 */}
            <Component1 />
            <Component2 />
            <Component3 />
            <Component4 />
            <Component5 />
            <Component6 />
            <Component7 />
        </div>
    )
    
    // ================== JSX 문법 s ================== // 

} // f end

// (2)
function Component1( props ){
    return <h4> 한줄로 입력시 ( ) 생략 가능 </h4>
} // f end

// (3)
function Component2( props ){
    return(
        <div>
            <h4> 두줄로 입력시 ( ) 필수로 감싼다. </h4>
        </div>
    )
} // f end

// (4)
function Component3( props ){
    return(
        <>
            <h4> div 대신에 이름없는 마크업 사용 가능하다. </h4>
        </>
    )
} // f end

// (5)
function Component4( props ){
    const name = '유재석'
    const age = 40;
    const obj = { name, age }

    return(
        <>
            <h4> { name } 님의 나이 : { age } </h4>
            <h4> { obj.name } 님의 나이 : { obj.age } </h4>
        </>
    )
} // f end

// (6)
function Component5( props ){
    const loginState = true; // 로그인상태
    // JSX 문법 { } 표현식에서는 if, for, function, const, let 불가능하다.
    return (
        <>
            <h4> 로그인상태 : { loginState ? '로그인중' : '비로그인중' } </h4>
            <h4> { loginState && <p> 로그인상태일때만 보이는 메시지 </p> } </h4>
        </>
    )
} // f end

// (7)
function Component6( props ){
    const items = [ '사과', '딸기', '바나나' ]
    // JSX 문법의 목록( list, option 등등 ) 마크업들에는 key 속성 필요로 한다.
        // => 리액트는 자동렌더링(새로고침) key 변화를 감지하여 변화된 key만 별도로 렌더링하는 기능
    // JSX 문법에서는 forEach 함수보다 map 함수를 자주 사용된다.
    return(<>
        <ul>
            { /* JSX 표현식 시작 */
                items.map( 
                    ( item, index ) => 
                    ( <li key={index}> { item } </li> )
                )/* map 시작 */
            }
        </ul>
    </>)
} // f end

// (8)
// * css 파일 import
import './Example1.css' // * css 파일 import // import '경로/파일명.clsss'
function Component7( props ){
    // style 속성에 style="color:blue" [x]
    // style 속성에 style={ {CSS객체} } [o]
    // 주의할점 : css 카멜표기법, JS의 속성명은
    const cssObj = { color : 'red', fontSize : 30 }
    // class 속성이 아닌 className 사용한다.
    return(<>
        <h4 style={ { color : 'blue' } }> 인라인 형식의 CSS 넣기 </h4>
        <h4 style={ cssObj } > 인라인 형식의 객체CSS 넣기 </h4>
        <h4 className="myclass" > CSS파일 내 선택자 이용한 CSS 넣기 </h4>
    </>)
} // f end


