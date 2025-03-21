import { useState } from "react";
import axios from 'axios';
import { useNavigate } from "react-router-dom";

export default function Signup( props ){
  // (1) 입력받은 값들을 저장하는 state변수 선언 c
  // const [ 변수명, set변수명 ] = useState(초기값)
  // setXXXX( 새로운 (주소)값 ) : 새로운 주소 및 리터럴이 들어올 경우 자동 렌더링한다.
  const [ memberInfo, setMemberInfo ] = useState( {
    mid: '',
    mpwd: '',
    mname: ''
  } );
  const navigate = useNavigate();

  // (2) 입력받은 값들을 state 렌더링하는 함수, event : onChange 결과정보, event.target : 해당 함수를 실행시킨 마크업
  const onInputChange = ( e ) => { 
    // ... 스프레드 연산자 : 새로운 주소 매핑
    setMemberInfo( { ...memberInfo, [e.target.name] : e.target.value } );
  } // f end

  // (3) 입력받은 첨부파일 * 첨부파일의 미리보기
  const [ profile, setProfile ] = useState( null ); // 업로드 파일을 파일객체로 저장하는 state 변수
  const [ preview, setPreview ] = useState( null ); // 업로드 파일을 바이트로 저장하는 state 변수
  const onFileChange = ( e ) =>{
    console.log( e.target.files[0] ); // 사용자가 입력한 파일 객체 반환 // JS에서 File 클래스 제공
    // (리액트)memberInfo는 속성명은 일반적으로 (자바)memberDto의 멤버변수와 동일하게
    // setMemberInfo( { ...memberInfo, "uploadFile" : e.target.files[0] } ) // 사용자가 입력한 파일객체를 state에 대입

    // 1. 업로드된 파일 반환
    const file = e.target.files[0];
    // 2. state 시정
    setProfile( file );
    // 3. * 이미지 미리보기( 업로드x )
    if( file ){
      // 4. 파일 읽기 객체 선언
      const reader = new FileReader(); // js객체 : 파일 읽기 객체
      // 5. 파일 읽기 메소드 정의 // reader.onloadend( () => { 파일읽어들일때 실행할 코드 } )
      reader.onloadend = () => {
        console.log( reader.result ); // 읽어들인 파일을 출력, reader.result : 가져온 파일의 결과물(바이트)
        setPreview( reader.result ); // state에 저장
      }
      // 6. 파일 읽기, // 파일 객체 읽기, reader.readAsDataURL( file객체 )
      reader.readAsDataURL( file );
    }else{ // 파일이 없으면
      setPreview( null );
    }
  } // f end

  console.log( memberInfo );

  const onSignup = async ( props ) => {
    if( !confirm('회원가입 하시겠습니까?') ){ return; }

    // 1. formData 객체 만들기, json과 다르게 문자열 전송이 아닌 바이트(바이너리) 전송을 하기 위한 폼 전송
    const formData = new FormData();
    // 2. formData에 속성 넣기, append( '속성명', 값 )
    formData.append( 'mid', memberInfo.mid );
    formData.append( 'mpwd', memberInfo.mpwd );
    formData.append( 'mname', memberInfo.mname );
    // * 만약에 첨부파일이 존재하면 첨부파일 추가
    if( profile ){
      formData.append( 'uploadFile', profile );
    }
    // 3. axios에서 사용할 http 헤더 정보, application/json은 기본값이므로 할 필요 없다.
    const option = { headers : { "Content-Type" : "multipart/form-data" } };
    // 4. axios 동기
    const response = await axios.post( 'http://localhost:8080/api/member/signup', memberInfo, option );
    // 5. 응답 받기, response.data
    const result = response.data;
    // 6. 응답에 따른 처리
    if( result ){
      alert('회원가입 성공');
      navigate( "/member/login" );
    }else{ alert('회원가입 실패') }
  } // f end

  return(<>
    <h3> 회원가입 페이지 </h3>
    <form>
      아이디 : <input type="text" name="mid" value={ memberInfo.mid } onChange={ onInputChange }  /> <br/>
      비밀번호 : <input type="password" name="mpwd" value={ memberInfo.mpwd } onChange={ onInputChange } /> <br/>
      닉네임 : <input type="text" name="mname" value={ memberInfo.mname } onChange={ onInputChange } /> <br/>
      프로필 : <input type="file" accept="image/*" onChange={ onFileChange } /> <br/>
      { 
        preview && ( <>
          미리보기 : 
          <img src={ preview } 
               style={{ width:"100px" }}
          />
        </> ) 
      } <br/>
      <button type="button" onClick={ onSignup } > 회원가입 </button>
    </form>
  </>)
} // f end