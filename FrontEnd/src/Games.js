import GameList from "./GameList";
import useFetch from "./useFetch";

const Games = () => {
    const {error:gameError, isPending:gamePending, data:gameData} = useFetch('http://localhost:8080/api/games');
    const {error:playerError, isPending:playerPending, data:playerData} = useFetch('http://localhost:8080/api/players');

    let games = null;
    if(gameData && playerData) {
        games = [];
        gameData.forEach(game =>
             {
                const winnerName = playerData.find(player => player.id === game.winnerID).name;
                const loserName = playerData.find(player => player.id === game.loserID).name;
                games.push({id:game.id, winnerName, loserName});
             })
        games.push();
    }
    return (
        <div>
            {gameError && <div>{ gameError }</div>}
            {gamePending && <div>Loading...</div>}
            {games && <GameList games={games} />}
        </div>
    );
}

export default Games;