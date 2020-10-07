const express = require('express');

import ImagesController from './controllers/imagesController';

const routes = express.Router();

const imagesController = new ImagesController();

routes.get('/', imagesController.index);

export default routes;