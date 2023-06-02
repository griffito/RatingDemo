import { Link, useNavigate } from "react-router-dom";

const PlayerList = ({ players }) => {
    let navigate = useNavigate();
    const deleteClick = (playerToDelete) => {
        console.log(playerToDelete.id)
        fetch('http://localhost:8080/api/players/' + playerToDelete.id, {
            method: 'DELETE'
        }).then(() => {
            navigate(0);
        })
    }
    return (
        <>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {players.map(player => (
                    <tr>
                        <th scope="row">{player.id}</th>
                        <td>{player.name}</td>
                        <td>{player.rating}</td>
                        <td>
                            <button className ="btn btn-danger" onClick={() => deleteClick(player)}>Delete</button>
                            <Link to={`/${player.id}`} className="btn btn-info"> 
                                Edit
                            </Link>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
        <Link to="/create" className="btn btn-primary">
            Add player
        </Link>
        </>
    );
}

export default PlayerList