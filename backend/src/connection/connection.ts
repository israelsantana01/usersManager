import { Connection } from "mysql";
const mysql = require('mysql');

export const connection =  mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'sampledb'
});

export function verifyConnection(connection: Connection) {
    connection.connect((error: Error) => {
        if (error) {
            console.log(error);
        } else {
            console.log('Connected...');
        }
    }); 
}

