import axios from 'axios';

export default {
    name: "Login",
    data: () => {
        return {

        }
    },
    methods: {
        login() {
            //axios.defaults.headers.common['Access-Control-Allow-Origin'] = "*";
            axios.get("api/status")
                .then(response => console.log(response));
        }
    }
}