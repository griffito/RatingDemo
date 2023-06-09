import { useNavigate } from "react-router-dom";
import { useState} from 'react';

const GameForm = ({ players }) => {
    const navigate = useNavigate();

    const defaultID = players[0].id;

    const [winnerID, setWinnerID] = useState(defaultID);
    const [loserID, setLoserID] = useState(defaultID);

    const handleSubmit = (e) => {
        e.preventDefault();
        const id = 0;
        const newGame = {id, loserID, winnerID};

        fetch('http://localhost:8080/api/games', {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newGame)
        }).then(() => {
            navigate('/games');
        })
    }
    
    return (
        <>
        <form onSubmit={handleSubmit}>
            <div className="form-group">
                <label>Winner:</label>
                <select 
                    value={winnerID}
                    onChange={(e) => setWinnerID(e.target.value)}
                >
                    {players.map(player => (
                        <option value={player.id} key={player.id}>{player.name}</option>
                    ))}
                </select>
                <label>Loser:</label>
                <select 
                    value={loserID}
                    onChange={(e) => setLoserID(e.target.value)}
                >
                    {players.map(player => (
                        <option value={player.id} key={player.id}>{player.name}</option>
                    ))}
                </select>
            </div>
            <button className="btn btn-primary">Create Game</button>
        </form>
        </>
    );
}

export default GameForm;