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
            axios.get("http://localhost:8080/api/status")
                .then(response => console.log(response));
        }
    }
}