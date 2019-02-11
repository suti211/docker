
export default {
    createPromise: (endpoint, params) => {
        let requestUrl;
        let requestMethod;

        if (endpoint) {
            requestUrl = endpoint.url;
            requestMethod = endpoint.method;
        }

        switch (requestMethod) {
            case 'POST':
                break;
            case 'PUT':
                break;
            case 'DELETE';
                break;
            default:
                break;
        }
    },

    testAxios: () => {
        return {
            axios.get("backend/test")
        }
    }
}