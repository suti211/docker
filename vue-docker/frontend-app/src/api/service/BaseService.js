import endpoints from '../endpoints';
import axios from 'axios';
export default {
    createPromise: (endpoint, params) => {
        let requestUrl;
        let requestMethod;

        if (endpoint) {
            requestUrl = endpoints[endpoint].url;
            requestMethod = endpoints[endpoint].method;
        }

        let axiosConfigObj = {
            url: '',
            method: '',
            data: params || {},
        }

        axiosConfigObj.url = requestUrl;
        axiosConfigObj.method = requestMethod;

        return axios(axiosConfigObj);
    }
}