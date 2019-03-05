import axios from 'axios';

export default {
    name: "Login",
    data: () => {
        return {
            email: '',
            password: '',
            loading: false,
            loginError: false,
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
            this.loading = true;
            this.loginError = false;
            axios.get("api/status")
                .then(response => {
                    console.log(response)
                })
                .catch(error => {
                    console.log(error);
                    this.loginError = true;

                })
                .finally(() => {
                    this.loading = false;
                    this.errors = [];
                })
        },

        checkForm() {
            if (this.email && this.password) {
                return true;
            }

            this.errors = [];

            if(!this.email) {
                this.errors.push('email-required');
            } else {
                if (this.email.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) == null) {
                    this.errors.push('email-format-invalid')
                }
            }

            if(!this.password) {
                this.errors.push('pass-required');
            }
        }
    }
}