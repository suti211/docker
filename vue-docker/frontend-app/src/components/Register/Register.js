import axios from 'axios';
export default {
    name: 'Register',
    data: () => {
        return {
            firstName: '',
            lastName: '',
            password: '',
            repeatPassword: '',
            email: '',
            loading: false,
            registerError: false,
            errors: []
        }
    },
    methods: {

        startRegister() {
            this.errors = [];
            this.checkIsValid();
        },

        register() {
            let body = {
                firstName: this.firstName,
                lastName: this.lastName,
                password: this.password,
                repeatPassword: this.repeatPassword
            }
            this.loading = true;
            axios.post("/api/user/register", body)
                .then(response => {
                    console.log(response);
                })
                .catch(error => {
                    console.log(error);
                })
                .finally(() => {
                    this.loading = false;
                });
        },

        checkIsValid() {
            if (this.checkIsFilledOut()){
                this.checkPasswordMatch();
            }
        },

        checkPasswordMatch() {
            if (this.password && this.repeatPassword) {
                return this.password == this.repeatPassword;
            }
        },

        checkIsFilledOut() {

            if (!this.firstName) {
                this.errors.push({ type: 'required', message: 'First name is required!' });
            }

            if (!this.lastName) {
                this.errors.push({ type: 'required', message: 'Last name is required!' });
            }

            if (!this.email) {
                this.errors.push({ type: 'required', message: 'Email is required!' });
            }

            if (!this.password) {
                this.errors.push({ type: 'required', message: 'Password is required!' });
            }

            if (!this.repeatPassword) {
                this.errors.push({ type: 'required', message: 'Repeat password is required!' });
            }

            return this.errors.filter(error => error.type === 'required').length == 0;
        },

        checkPasswordStrength() {

            if (this.password) {
                if (this.password.length < 6) {
                    this.errors.push('Password is too short!')
                }
            }

        }
    }
}