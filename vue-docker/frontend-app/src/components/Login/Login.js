import axios from 'axios';

export default {
    name: "Login",
    data: () => {
        return {
            username: '',
            password: '',
            errors: []
        }
    },
    methods: {

        checkAndLogin() {
            if (this.checkForm()) {
                this.login();
            }
        },

        login() {
            axios.get("api/status")
                .then(response => console.log(response));
        },

        checkForm() {
            if (this.username && this.password) {
                return true;
            }

            this.errors = [];

            if(!this.username) {
                this.errors.push('username');
            }

            if(!this.password) {
                this.errors.push('password');
            }
        }
    }
}