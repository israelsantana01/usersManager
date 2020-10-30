import React, { useEffect, useState } from 'react';

import api from '../services/Api';
import UserItem, { User } from '../components/UserItem';
import Pagination from '../components/Pagination';
import Select from '../components/Select';

import '../styles/pages/landing.css';

interface Select {
	value: string;
	label: string;
}

function Landing() {
	const [users, setUsers] = useState([]);
	const [filteredUsers, setFilteredUsers] = useState([]);
	const [search, setSearch] = useState('');
	const [select, setSelect] = useState([]);
	const [subject, setSubject] = useState('');

	// Pagination
	const [loading, setLoading] = useState(false);
	const [currentPage, setCurrentPage] = useState(1);
	const [usersPerPage] = useState(4);

	// Fetch items of api
	useEffect(() => {
		async function getUsers() {
			const res = await api.get('/');
			setUsers(res.data);
		}

		getUsers();
	}, []);

	// Search function
	useEffect(() => {
		setFilteredUsers(
			users.filter((user: User) => {
				return (
					user.username.toLowerCase().includes(search.toLowerCase()) 
					&& user.subject.toLowerCase().includes(subject.toLowerCase()));
			})
		);
	}, [search, users]);

	// Filter by category
	useEffect(() => {
			setFilteredUsers(
				users.filter((user: User) => {
					return user.subject.toLowerCase().includes(subject.toLowerCase());
				})
			);

	}, [subject])

	// Handle Categories
	useEffect(() => {
		function handleSelectCategories() {
			let categories: any = [];
			let labels: any = [];
			let values: any = [];

			users.forEach((user: User) => {
				values.push(user.subject.substring(0, 1).toLowerCase() + user.subject.substring(1, user.subject.length));
				labels.push(user.subject);
			});

			let uniqueValues = Array.from(new Set(values));
			let uniqueLabels = Array.from(new Set(labels));

			for (let i = 0; i < uniqueValues.length; i++) {
				let selectObject = {
					value: uniqueValues[i],
					label: uniqueLabels[i]
				};

				categories.push(selectObject);
			}
			categories.splice(0, 0, { value: '', label: 'Selecione uma opção' });

			setSelect(categories);
		}
		handleSelectCategories();

	}, [users]);

	// Get current users
	const indexOfLastUser = currentPage * usersPerPage;
	const indexOfFirstUser = indexOfLastUser - usersPerPage;

	const currentUsers = filteredUsers.slice(indexOfFirstUser, indexOfLastUser);

	//Change page
	function paginate(pageNumber: any) {
		setCurrentPage(pageNumber)
	}

	return (
		<div className="container-fluid d-flex align-items-center justify-content-center flex-column">

			<div className="header-bg">
				<div className="header">
					<h3>Catálogo</h3>
				</div>
			</div>
	
			<div className="search-bg w-100 mb-4 d-flex align-tems-center justify-content-center">
				<div className="search-group d-flex">

					<div className="select-group">
						<div className="select mb-2">
							<Select
								name="subject"
								value={subject}
								onChange={event => { setSubject(event.target.value) }}
								options={select}
							/>
						</div>
					</div>
					<input 
						type="text"  
						className="form-control" 
						placeholder="Pesquisa"
						onChange={event => {setSearch(event.target.value)}} 
					/>

				</div>
			</div>

			<Pagination
				usersPerPage={usersPerPage}
				totalUsers={filteredUsers.length}
				currentPage={currentPage}
				paginate={paginate}
			/>

			<div className="users">
				<UserItem users={currentUsers} />
			</div>
		</div>
	);
}

export default Landing;