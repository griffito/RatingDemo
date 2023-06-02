import { useNavigate, useParams } from "react-router-dom";
import { useState } from "react";

const CreatePlayer = () => {
    const navigate = useNavigate();

    const [name, setName] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const id = 0;
        const rating = 0;
        const newPlayer = {id, name, rating};
        fetch('http://localhost:8080/api/players', {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newPlayer)
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
            <button className="btn btn-primary">Create Player</button>
        </form>
        </>
    );
}

export default CreatePlayer;