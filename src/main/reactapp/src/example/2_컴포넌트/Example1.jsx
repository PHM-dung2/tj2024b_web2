// (1)
export default function Example2( props ){

    // ================ JSX 문법 s ================== // 
    return(
        <div>
            {/* 주석 내용물 */}
            <h3> 컴포넌트 </h3>
            {/* 다른 컴포넌트 호출 */}
            <Component1 />
            <Component2 />
        </div>
    )
    
    // ================ JSX 문법 s ================== // 

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



