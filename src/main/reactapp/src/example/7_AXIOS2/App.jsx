import { BrowserRouter, Route, Routes } from "react-router-dom";

/* 라우터로 연결한 컴포넌트 import 가져온다. */
import Home from './Home.jsx'
import Create from './Create.jsx'
import Read from './Read.jsx'
import Update from './Update.jsx'
import Delete from './Delete.jsx'
import SideBar from "./SideBar.jsx";

/* css import */
import './app.css'; // ./ : 현재 파일과 같은 경로 뜻

// App.jsx : 라우터(가상URL)이요한 라이팅
export default function App( porps ){ // 컴포넌트
    return(<>
        <BrowserRouter> { /* 모든 라우터를 감싼다. */ }
            <div id='wrap'>
                <SideBar />
                <Routes> {/* 가상으로 정의한 URL을 감싼다. */}
                    <Route path="/" element={ <Home /> } ></Route> { /* 각 가상의 URL 정의한다. 컴포넌트 연결 */ }
                    <Route path="/create" element={ <Create />  } ></Route> { /* 각 가상의 URL 정의한다. 컴포넌트 연결 */ }
                    <Route path="/read" element={ <Read /> } ></Route> { /* 각 가상의 URL 정의한다. 컴포넌트 연결 */ }
                    <Route path="/update" element={ <Update /> } ></Route> { /* 각 가상의 URL 정의한다. 컴포넌트 연결 */ }
                    <Route path="/delete" element={ <Delete /> } ></Route> { /* 각 가상의 URL 정의한다. 컴포넌트 연결 */ }
                </Routes>
            </div>
        </BrowserRouter>
    </>)
} // f end
