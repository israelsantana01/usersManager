import React, { useEffect, useState } from 'react';

import api from '../services/Api';

interface User {
    username: string,
    subject: string,
    year: string,
    image: number
}

function Landing() {

    const [users, setUsers] = useState([]);

    useEffect(() => {
        async function getUsers() {
            const res = await api.get('/');
            setUsers(res.data);
        }
        getUsers();

    }, []);

    return (
        <ul>
            { users.map((item: User) => {
                return (
                    <li key={item.subject}>
                         {item.username}
                    </li>
                );
            }) }
        </ul>
    );
}

export default Landing;