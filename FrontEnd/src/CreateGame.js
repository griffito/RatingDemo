import GameForm from "./GameForm";
import useFetch from "./useFetch";

const CreateGame = () => {
    /*
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
                <label>Winner:</label>
                <select 
                    value={winnerName}
                    onChange={(e) => setWinnerName(e.target.value)}
                >
                    {games.map(game => (
                    <tr>
                        <th scope="row">{game.id}</th>
                        <td>{game.winnerName}</td>
                        <td>{game.loserName}</td>
                        <td>
                            <button className="btn btn-danger" onClick={() => deleteClick(game)}>Delete</button>
                        </td>
                    </tr>
                ))}
                </select>
            </div>
            <button className="btn btn-primary">Create Game</button>
        </form>
        </>
    );*/

    const {error, isPending, data:players} = useFetch('http://localhost:8080/api/players');
    const isNotEmpty = players && players.length > 0;
    return (
        <div>
            {error && <div>{ error }</div>}
            {isPending && <div>Loading...</div>}
            {isNotEmpty && <GameForm players={players} />}
        </div>
    );
}

export default CreateGame;