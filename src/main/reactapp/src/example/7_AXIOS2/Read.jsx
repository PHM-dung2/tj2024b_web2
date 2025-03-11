import { useEffect, useState } from "react"
import axios from 'axios';

export default function Read( porps ){
    const [ boards , setBoards ] = useState( [] );
    useEffect( () => { onFindAll(); }, [ ] );

    const onFindAll = async (e) => {
        try{
            const response = await axios.get( 'http://192.168.40.45:8080/day08/product' );
            setBoards( response.data );
        }catch( error ){ console.log( error ); }
    } // f end

    const updateLink = ( id ) => {
        location.href = `./Update?id=${id}`
    } // f end

    const onDelete = async ( id ) => {
        if( !confirm('정말 삭제하시겠습니까?') ){ return; }

        const response = await axios.delete( `http://192.168.40.45:8080/day08/product?id=${id}` );
        if( response.data == true ){
            alert('삭제 성공');
            onFindAll();
        }else{ alert('삭제 실패'); }
    } // f end

    return(<>
        <div>
            <h2> Read 페이지 </h2> <br/>
            <table border={1} > 
                <thead>
                    <tr>
                        <th> 제품번호 </th>
                        <th> 제품명 </th>
                        <th> 제품가격 </th>
                        <th> 제품설명 </th>
                        <th> 비고 </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boards.map( ( board ) => {
                            return( 
                                <tr key={ board.id }>
                                    <td>{ board.id }</td>
                                    <td>{ board.name }</td>
                                    <td>{ board.price }</td>
                                    <td>{ board.comment }</td>
                                    <td>
                                        <button type="button" onClick={ (e) => { updateLink( board.id ) } } > 수정 </button>
                                        <button type="button" onClick={ (e) => { onDelete( board.id )  } } > 삭제 </button>
                                    </td>
                                </tr>
                             )
                        })
                    }
                </tbody>
            </table>
        </div>
    </>)
}