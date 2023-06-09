import { Link, useNavigate } from "react-router-dom";

const GameList = ({ games }) => {
    let navigate = useNavigate();
    const deleteClick = (gameToDelete) => {
        console.log(gameToDelete.id)
        fetch('http://localhost:8080/api/games/' + gameToDelete.id, {
            method: 'DELETE'
        }).then(() => {
            navigate(0);
        })
    }

    return (
        <>
        <table className="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Winner</th>
                    <th scope="col">Loser</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {games.map(game => (
                    <tr key={game.id}>
                        <th scope="row">{game.id}</th>
                        <td>{game.winnerName}</td>
                        <td>{game.loserName}</td>
                        <td>
                            <button className="btn btn-danger" onClick={() => deleteClick(game)}>Delete</button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
        <Link to="/games/create" className="btn btn-primary">
            Add Game
        </Link>
        </>
    );
}

export default GameList;