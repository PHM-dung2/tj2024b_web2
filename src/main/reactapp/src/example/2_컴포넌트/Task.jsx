
// 컴포넌트란? 1. 클래스형 컴포넌트 2. 함수형 컴포넌트(*)
// ProductCard 컴포넌트 : 하나의 제품정보를 표현하는 UI 구역      (하위)
// Task 컴포넌트 : 여러개의 ProductCard 컴포넌트 포함하는  UI 구역(상위)
// 1. 샘플데이터로 간단한 화면 구현
// 2. 'ProductCard' 재사용(재호출)함으로써 HTML 코드 양 줄일 수 있다.
// 3. props : 하위 컴포넌트의 속성(매개변수) 전달
// 4. 반복문 필요한 하위 컴포넌트 호울
// 5. 목록 마크업들에는 항상 key 속성 필수 필요로 한다.(리액트는 key 속성의 변화에 따라 자동으로 재렌더링(새로고침))
const ProductCard = ( props ) => { // props 객체를 구문(객체) 분해해서 각 변수로 저장
    const number = props.price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

    return (<>
        <div className="productCard">
            <h2> { props.title } </h2>
            <div className="price"> 가격: { number } </div>
            { props.inStock ? <div className="stock_true" > '재고있음' </div> : <div className="stock_false" >  '재고없음' </div> }
        </div>
    </>);
};
  
import './Task.css'
export default function Task( props ) {
const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
];
return (<>
    <div className="cardBox">
        {
            products.map(
                ( product, index ) => 
                ( <ProductCard key={index} title={product.title} price={product.price} inStock={product.inStock} /> )
            )
        }
    </div>
</>);
}