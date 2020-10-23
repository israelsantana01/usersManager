import React from 'react';
import './UserItem.css'

export interface User {
    id: number,
    username: string,
    subject: string,
    year_of_entry: string,
    image_url: string
}

interface UserProps {
    user: User
}

const UserItem: React.FunctionComponent<UserProps> = ({ user }) => {

    return (
        <div className="card">
            <div className="card-header">
                <img src={user.image_url} alt="" />
            </div>
            <div className="card-body">
                <div className="card-body-content">
                    <h4>Nome:</h4>
                    <span>{user.username}</span>
                </div>
                <div className="card-body-content">
                    <h4>Matéria:</h4>
                    <span>{user.subject}</span>
                </div>
                <div className="card-body-content">
                    <h4>Ano de entrada:</h4>
                    <span>{user.year_of_entry}</span>
                </div>
            </div>
        </div>
    );
}

export default UserItem;