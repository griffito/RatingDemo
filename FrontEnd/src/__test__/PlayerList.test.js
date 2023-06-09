import { getAllByRole, render, screen } from '@testing-library/react';
import PlayerList from '../PlayerList';
import { BrowserRouter } from 'react-router-dom';
import '@testing-library/jest-dom/extend-expect';

const MockPlayerList = ({ players }) => {
    return (
        <BrowserRouter>
            <PlayerList
                players={players}
            />
        </BrowserRouter>
    )
}

const testPlayerList = [
    { 
        "id": 1,
        "name": "David",
        "rating": 1000
    },
    { 
        "id": 2,
        "name": "Mary",
        "rating": 1200
    },
    { 
        "id": 3,
        "name": "Stephen",
        "rating": 800
    }
];

test('Rendered table has correct number of rows', () => {
    render(
        <MockPlayerList
            players={testPlayerList}
        />
    );
    const tableRows = screen.getAllByRole("row");
    expect(tableRows.length).toBe(testPlayerList.length + 1);
});

test('Rendered row contains correct data', () => {
    render(
        <MockPlayerList
            players={testPlayerList}
        />
    );
    
    const davidRow = screen.getByRole("row", {name:/David/})
    expect(davidRow).toHaveTextContent("1000");
});