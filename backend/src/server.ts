import { connection, verifyConnection } from './connection/connection';
import routes from './routes';

const cors = require('cors');
const path = require('path');
const express = require('express');

const app = express();
app.use(cors());
verifyConnection(connection);
app.use(routes);

app.use('/uploads', express.static(path.resolve(__dirname, 'uploads')));

app.listen(3333);
