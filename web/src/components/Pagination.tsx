import React from 'react';

interface PaginationProps {
  usersPerPage: number;
  totalUsers: number;
  currentPage: number;
  paginate: any;
}

const Pagination: React.FC<PaginationProps> = ({ usersPerPage, totalUsers, paginate, currentPage }) => {
  const pageNumbers = [];

  for (let i = 1; i <= Math.ceil(totalUsers / usersPerPage); i++) {
    pageNumbers.push(i);
  };

  return (
    <nav>
      <ul className="pagination">
        {pageNumbers.map(number => (
          number === currentPage ? (
            <li key={number} className="page-item active">
              <a className="page-link" onClick={() => { paginate(number) }}>
                {number}
              </a>
            </li>
          ) : (
            <li key={number} className="page-item">
              <a className="page-link" onClick={() => { paginate(number) }}>
                {number}
              </a>
            </li>
          )
        ))}
      </ul>
    </nav>
  );
}

export default Pagination;