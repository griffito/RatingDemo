import PlayerList from "./PlayerList";
import useFetch from "./useFetch";

const Home = () => {
    const {error, isPending, data:players} = useFetch('http://localhost:8080/api/players');
    

    return (
        <div>
            {error && <div>{ error }</div>}
            {isPending && <div>Loading...</div>}
            {players && <PlayerList players={players} />}
        </div>
    );
}

export default Home;