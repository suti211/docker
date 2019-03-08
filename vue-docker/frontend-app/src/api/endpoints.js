export default {

    testEndpoint: {
        url: 'backend/test',
        method: 'GET'
    },

    testEndpointWithParam: {
        url: 'backend/test?docId={}',
        method: 'POST'
    },

    register: {
        url: '/api/user/register',
        method: 'POST'
    },

    login: {
        url: '/api/user/login',
        method: 'POST'
    }
}