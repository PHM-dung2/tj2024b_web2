import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router-dom";


import { useDispatch } from 'react-redux'
import { login } from '../reducx/userSlice'

export default function Login( props ){

  // (***********************) 리덕스 ( 전역변수 ) 사용하기 (***********************)
  const dispatch = useDispatch();

  const navigate = useNavigate();
  const [ memberInfo, setMemberInfo ] = useState( { mid: '', mpwd: '' } );

  const onInputChange = ( e ) => {
    setMemberInfo( { ...memberInfo, [ e.target.name ] : e.target.value } )
  } // f end

  const onLogin = async ( props ) => {
    const response = await axios.post( 'http://localhost:8080/api/member/login', memberInfo, { withCredentials : true } );
    const result = response.data;
    console.log( result );
    if( result == true ){
      // (4) 로그인 성공할 경우 로그인 성공한 회원 정보 가져오기
      const response2 = await axios.get( 'http://localhost:8080/api/member/info', { withCredentials : true } );
      alert('로그인 성공');
      navigate( '/' );
      // location.href="/";
      // (***********************) 리덕스 ( 전역변수 ) 사용하기 (***********************)
      // (2) useDispatch 함수를 이용한 리듀서 함수 액션하기 // 로그인 액션에 (로그인한) 회원정보를 대입한다.
      dispatch( login( response2.data ) ); // useState(지역상태)가 아닌 store(전역상태)에 저장된다.
      console.log( response2.data )
    }else{ alert('로그인 실패'); }
  } // f end

  return(<>
    <h3> 로그인 페이지 </h3>
    <form>
      아이디 : <input type="text" name="mid" value={ memberInfo.mid } onChange={ onInputChange } /> <br/>
      비밀번호 : <input type="password" name="mpwd" value={ memberInfo.mpwd } onChange={ onInputChange } /> <br/>
      <button type="button" onClick={ onLogin } > 로그인 </button>
    </form>
  </>)
} // f end