import Navbar from './Navbar';
import Home from './Home';
import Games from './Games';
import EditPlayer from './EditPlayer';
import CreatePlayer from './CreatePlayer';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';

function App() {
  return (
    <Router>
       <Navbar />
      <div class="container">
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/games" element={<Games />} />
                <Route path="/create" element={<CreatePlayer />} />
                <Route path="/:id" element = {<EditPlayer />} />
              </Routes>
      </div>
    </Router>
  );
}

export default App;
