import axios from 'axios';
import { useState } from 'react';

export default function Update( porps ){

    const id = new URL( location.href ).searchParams.get('id');
    console.log( id );

    const [ formData, setFormData ] = useState( { name: '', price: '', comment: '' } );
    const formDataChange = ( e ) => {
        console.log( e.target.value );
        setFormData( { ...formData, [ e.target.name ] : e.target.value } );
    } // f end

    const onPut = async ( props ) => {
        try{
            const response = await axios.put( `http://192.168.40.45:8080/day08/product?id=${id}`, formData );
            if( response.data == true ){
                alert('수정 성공');
                setFormData( { name: '', price: '', comment: '' } );
                location.href = './Read';
            }else{ alert('수정 실패'); }
        }catch( error ){ console.log( error ); }
    } // f end

    return(<>
        <div>
            <h2> Update 페이지 </h2> <br/>
            <form id="inputForm" >
                제품명 : <input type="text" name="name" onChange={ formDataChange } /> <br/>
                가격 : <input type="number" name="price" onChange={ formDataChange } /> <br/>
                제품설명 : <input type="text" name="comment" onChange={ formDataChange } /> <br/>
                <button type="button" onClick={ onPut } > 등록 </button>
            </form>
        </div>
    </>)
}