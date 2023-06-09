import { useNavigate} from "react-router-dom";
import { useState } from "react";


const PlayerForm = ({ player }) => {
    const navigate = useNavigate();

    let defaultName = '';
    let defaultID = 0;
    if(player) {
        defaultName = player.name;
        defaultID = player.id;
    }

    const [name, setName] = useState(defaultName);
    const [id, setID] = useState(defaultID);

    const handleSubmit = (e) => {
        e.preventDefault();
        const rating = 0;
        const newPlayer = {id, name, rating};

        if(player) {
            fetch('http://localhost:8080/api/players', {
                method: 'PUT',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(newPlayer)
            }).then(() => {
                navigate('/');
            })
        } else {
            fetch('http://localhost:8080/api/players', {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(newPlayer)
            }).then(() => {
                navigate('/');
            })
        }
        
    }

    let buttonLabel = 'Create Player';
    if(player) {
        buttonLabel = 'Update Player';
    }

    return (
        <>
        <form onSubmit={handleSubmit}>
            <div className="form-group">
                <label>Name:</label>
                <input type="text"
                    required 
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    className="form-control"
                />
            </div>
            <button className="btn btn-primary">{buttonLabel}</button>
        </form>
        </>
    );
}

export default PlayerForm;