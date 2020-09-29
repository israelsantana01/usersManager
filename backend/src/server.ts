import { Response, Request } from 'express';
import express = require('express');
import mysql = require('mysql');
import fs = require('fs');
import { connection } from './connection/connection';
import path = require('path');

let outputfile;

connection.connect((error: Error) => {
    if (!!error) {
        console.log('Error!');
    } else {
        console.log('Connected...');
    }
});

const app = express();
app.listen(3333);

app.get('/', (req: Request, res: Response) => {
    connection.query(
        "SELECT * FROM students", 
        (error: mysql.MysqlError, rows: any, fields: mysql.FieldInfo) => {
            if (error) throw error;

            const row = rows[0];
            const data = row.image;
            outputfile = `${row.username}.jpg'`;

            const buf = new Buffer(data, "base64");

            fs.writeFileSync(path.resolve(__dirname, 'uploads', `${outputfile}`), buf);
            console.log("New output file:", outputfile)
            res.send("File created!");
    });
});
