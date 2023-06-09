import { getAllByRole, render, screen } from '@testing-library/react';
import GameList from '../GameList';
import { BrowserRouter } from 'react-router-dom';
import '@testing-library/jest-dom/extend-expect';

const testGameList = [
    {
        "id": 1,
        "winnerName": "Mary",
        "loserName": "David"
    },
    {
        "id": 2,
        "winnerName": "Mary",
        "loserName": "Stephen"
    },
    {
        "id": 3,
        "winnerName": "David",
        "loserName": "Stephen"
    }
];

const MockGameList = ({ games }) => {
    return (
        <BrowserRouter>
            <GameList
                games={games}
            />
        </BrowserRouter>
    );
}

test('Rendered table has correct number of rows', () => {
    render(
        <MockGameList
            games={testGameList}
        />
    );
    const tableRows = screen.getAllByRole("row");
    expect(tableRows.length).toBe(testGameList.length + 1);
});


test('Rendered row contains correct data', () => {
    render(
        <MockGameList
            games={testGameList}
        />
    );
    
    const gameRow1 = screen.getByRole("row", {name:/1/})
    expect(gameRow1).toHaveTextContent("Mary");
    expect(gameRow1).toHaveTextContent("David");
});