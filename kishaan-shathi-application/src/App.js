
import './App.css';
import 'react-toastify/dist/ReactToastify.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { ToastContainer, } from 'react-toastify';
import Home from './pages/Home';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Farmer from './pages/Farmer';
import Dealer from './pages/Dealer';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <ToastContainer />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/login' element={<Login />} />
          <Route path='/signup' element={<Signup />} />
          <Route path='/farmer' element={<Farmer />} />
          <Route path='/dealer' element={<Dealer />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
