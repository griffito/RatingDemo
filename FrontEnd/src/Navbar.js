import { Link } from "react-router-dom";

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <Link to="/" className="navbar-brand text-white">
                    ELO
                </Link>
                <Link to="/games" className="nav-link text-white">
                    Games
                </Link>
        </nav>
    );
}
export default Navbar;