import BaseService from './BaseService';

export default {
    login: (credentials) => {
        return BaseService.createPromise('login', credentials);
    }
}