import "./App.css";
import "react-toastify/dist/ReactToastify.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import Farmer from "./pages/Farmer";
import Dealer from "./pages/Dealer";
import About from "./pages/About";
import Notifications from './pages/Notifications'
import Notification from './components/Notification';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <ToastContainer />
        <Routes>
          <Route path='/home' element={<Home />} />
          <Route path='/' element={<Login />} />
          <Route path='/signup' element={<Signup />} />
          <Route path='/farmer' element={<Farmer />} />
          <Route path='/dealer' element={<Dealer />} />
          <Route path='/notification' element={<Notification/>} />
          <Route path='/noti' element={<Notifications/>}/>
          <Route path='/about' element={<About />} />

        </Routes>
      </BrowserRouter>


    </div>
  );
}

export default App;
