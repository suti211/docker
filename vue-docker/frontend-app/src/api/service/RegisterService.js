import BaseService from './BaseService';

export default {
    postRegisterRequest: (body) => {
        return BaseService.createPromise('register', body);
    }
}