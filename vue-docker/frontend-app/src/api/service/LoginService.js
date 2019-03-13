import BaseService from './BaseService';

export default {
    login: (credentials) => {
        let requestBody = {
            email: credentials.email,
            password: credentials.password
        }
        return BaseService.createPromise('login', requestBody);
    }
}