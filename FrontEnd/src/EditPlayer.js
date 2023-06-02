import { useNavigate, useParams } from "react-router-dom";
import { useState } from "react";
import useFetch from "./useFetch";

const EditPlayer = () => {
    const { id } = useParams();
    const {data:player, error, isPending} = useFetch('http://localhost:8080/api/players/' + id);
    const navigate = useNavigate();

    let baseName = "";
    if(player) {
        baseName = player.name;
    }

    const [name, setName] = useState(baseName);

    const handleSubmit = (e) => {
        e.preventDefault();
        const rating = 0;
        const updatedPlayer = {id, name, rating};
        fetch('http://localhost:8080/players', {
            method: 'PUT',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(updatedPlayer)
        }).then(() => {
            navigate('/');
        })
    }

    return (
        <>
        <form onSubmit={handleSubmit}>
            <label>Name:</label>
            <input type="text" 
                required 
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
        </form>
        </>
    );
}

export default EditPlayer;