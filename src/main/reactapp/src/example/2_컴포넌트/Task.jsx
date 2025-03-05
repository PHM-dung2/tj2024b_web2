
const ProductCard = ( props ) => {
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
                ( <ProductCard key={index} title={product.title} price={product.price} inStock={product.inStock} > </ProductCard> )
            )
        }
    </div>
</>);
}