import { Request, Response } from 'express';
import mysql from 'mysql';

const path = require('path');
const ip = require('ip');
const fs = require('fs');

import { connection } from '../connection/connection';

class ImagesController {
    async index(req: Request, res: Response) {
        connection.query(
            "SELECT * FROM students", 
            (error: mysql.MysqlError, rows: any, fields: mysql.FieldInfo) => {
                if (error) throw error;
                const users = [];

                for (let item of rows) {
                    const data = item.image;
                    const imageName = `${item.username}.jpg`;
                    let outputfile = imageName;
                    const buf = new Buffer(data, "base64");
                    fs.writeFileSync(path.resolve(__dirname, '..', 'uploads', `${outputfile}`), buf);

                    const user = {
                        id: item.id,
                        username: item.username,
                        subject: item.subject,
                        year_of_entry: item.year_of_entry,
                        image_url: `http://${ip.address()}:3333/uploads/${imageName}`
                    }

                    users.push(user);
                }
                return res.json(users);
        });
    }
}

export default ImagesController;