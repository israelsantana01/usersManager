import React from 'react';

import '../styles/components/userItem.css'

export interface User {
	id: number;
	username: string;
	subject: string;
	year_of_entry: string;
	image_url: string;
}

interface UserProps {
	users: Array<User>
}

const UserItem: React.FunctionComponent<UserProps> = ({ users }) => {

	return (
		<>
			{users.map(user => (
				<div className="card" key={user.id}>
					<div className="card-img">
						<img src={user.image_url} className="card-img-top" alt="..." />
					</div>

					<div className="card-body">
						<div className="card-content">
							<p className="font-weight-bold mr-1">Nome</p>
							<p>{user.username}</p>
						</div>

						<div className="card-content">
							<p className="font-weight-bold mr-1">Matéria</p>
							<p>{user.subject}</p>
						</div>

						<div className="card-content">
							<p className="font-weight-bold mr-1">Ano de entrada</p>
							<p>{user.year_of_entry}</p>
						</div>
					</div>
				</div>
			))}
		</>
	);
}

export default UserItem;