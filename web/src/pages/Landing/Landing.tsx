import React, { useEffect, useState } from 'react';

import api from '../../services/Api';
import UserItem, { User } from '../../components/UserItem/UserItem';

import './Landing.css';

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
        <div className="container">
            <div className="header-bg">
                <div className="header">
                    <h3>Catálogo</h3>
                </div>
            </div>
            <div className="users">
                {users.map((item: User) => {
                    return (
                        <UserItem key={item.id} user={item} />
                    );
                })}
            </div>
        </div>
    );
}

export default Landing;