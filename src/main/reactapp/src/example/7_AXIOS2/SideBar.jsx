import { Link } from "react-router-dom";

export default function SideBar(){
    return(<>
        {/* Link a태그로 취급 */}
        <div>
            <ul id='sideMenu'>
                <li> 사이드바 메뉴 </li>
                <li> <Link to="/" > 메인페이지(HOME) </Link> </li>
                <li> <Link to="/Create" > CREATE 페이지 </Link> </li>
                <li> <Link to="/Read" > READ 페이지 </Link> </li>
                {/* <li> <Link to="/Update" > UPDATE 페이지 </Link> </li>
                <li> <Link to="/Delete" > DELETE 페이지 </Link> </li> */}
            </ul>
        </div>
    </>)
}