import axios from 'axios';
import { useState } from 'react';

export default function Create( porps ){

    const [ formData, setFormData ] = useState( { name: '', price: '', comment: '' } );
    const formDataChange = ( e ) => {
        console.log( e.target.value );
        setFormData( { ...formData, [ e.target.name] : e.target.value })
    } // f end

    const onPost = async ( props ) => {
        try{
            const response = await axios.post( 'http://192.168.40.45:8080/day08/product', formData );
            if( response.data ){
                alert('등록 성공');
                setFormData( { name: '', price: '', comment: '' } );
                location.href = './Read';
            }else{ alert('등록 실패'); }
        }catch( error ){ console.log( error) } 
    } // f end

    return(<>
        <div>
            <h2> Create 페이지 </h2> <br/>
            <form id="inputForm" >
                제품명 : <input type="text" name="name" onChange={ formDataChange } /> <br/>
                가격 : <input type="number" name="price" onChange={ formDataChange } /> <br/>
                제품설명 : <input type="text" name="comment" onChange={ formDataChange } /> <br/>
                <button type="button" onClick={ onPost } > 등록 </button>
            </form>
        </div>
    </>)
}