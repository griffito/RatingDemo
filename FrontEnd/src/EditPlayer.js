import { useParams } from "react-router-dom";
import useFetch from "./useFetch";
import PlayerForm from "./PlayerForm";

const EditPlayer = () => {
    const { id } = useParams();
    const {data:player, error, isPending} = useFetch('http://localhost:8080/api/players/' + id);
    
    return (
        <div>
            {error && <div>{ error }</div>}
            {isPending && <div>Loading...</div>}
            {player && <PlayerForm player={player} />}
        </div>
    );


}

export default EditPlayer;