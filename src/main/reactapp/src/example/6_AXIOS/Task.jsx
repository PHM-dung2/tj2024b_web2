import { useEffect, useState } from "react";
import axios from 'axios';

const TableCom = ( props ) => {
    return(<>
        <tr>
            <td>{ props.no }</td>
            <td>{ props.name }</td>
            <td>{ props.phone }</td>
        </tr>
    </>)
} // f end

export default function Task1( props ){

    const [ formData, setFormData ] = useState( { name: '', phone:'' } );
    // const [ members, setMembers ] = useState( { name : '' , phone : '' } );
    const DataChange = ( e ) => {
        console.log( e.target.value );
        setFormData( { ...formData, [ e.target.name ] : e.target.value } );
        // setMembers( { ...members, name, phone } );
    }


    const onPost = async ( e ) => {
        try{
            const response = await axios.post( 'http://192.168.40.45:8080/day07/task', formData );
            if( response.data ){
                alert('등록성공');
                setFormData( { name: '', phone: '' } );
                onFindAll();
            }
        }catch( error ){ console.log( error) }
    }

    useEffect( () => { onFindAll(); }, [] );
    const [ boards, setBoards ] = useState( [] );
    const onFindAll = async ( e ) => {
        try{
            const response = await axios.get( 'http://192.168.40.45:8080/day07/task' );
            setBoards( response.data );
        }catch( error ){ console.log( error ) }
    }

    return(<>
        <form>
            이름 : <input type='text' value={ formData.name } name='name' onChange={ DataChange } /> <br/>
            전화번호 : <input type='text' value={ formData.phone } name='phone' onChange={ DataChange } /> <br/>
            <button type="button" onClick={ onPost } > 등록 </button>
        </form>

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
                    boards.map( ( board, index ) => {
                        return ( <TableCom key={index} no={index+1} name={board.name} phone={board.phone} />)
                    })
                }
            </tbody>
        </table>
    </>)
} // f end