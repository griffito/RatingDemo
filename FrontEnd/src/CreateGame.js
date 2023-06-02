import { useNavigate, useParams } from "react-router-dom";
import { useState } from "react";

const CreateGame = () => {
    const navigate = useNavigate();

    const [winnerName, setWinnerName] = useState('');
    const [loserNamer, setLoserName] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const id = 0;

        // We need code to find the ID from the name
        const winnerID = 1;
        const loserID = 2;
        const newGame = {id, name, rating};
        fetch('http://localhost:8080/api/games', {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newGame)
        }).then(() => {
            navigate('/');
        })
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
            <button className="btn btn-primary">Create Game</button>
        </form>
        </>
    );
}

export default CreateGame;