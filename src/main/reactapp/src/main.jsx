import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// react18
// (!) 기본값 주석처리
// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     <App />
//   </StrictMode>,
// )

// (*) index.html에 root 구역 가져오기
const root = createRoot( document.querySelector('#root') )

// day01 : '컴포넌트 만들기' 렌더링
  // import 호출할컴포넌트명 form '경로/파일명(확장자);
import Component1 from './example/1_동작구조/Component1.jsx'
// root.render( <Component1 /> );

// day01 : 여러 컴포넌트 만들기
import Component2 from './example/1_동작구조/Component2.jsx'
// root.render( <Component2 /> );

// day02 : 컴포넌트의 JSX 활용
import Example1 from './example/2_컴포넌트/Example1.jsx'
// root.render( <Example1 /> )

// day02 : 컴포넌트의  props 활용
import Example2 from './example/2_컴포넌트/Example2.jsx'
root.render( <Example2 /> )
