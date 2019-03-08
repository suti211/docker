import { mapGetters, mapActions } from 'vuex';

export default {
    name: 'Register',
    data: () => {
        return {
            firstName: '',
            lastName: '',
            password: '',
            repeatPassword: '',
            email: '',
            errors: []
        }
    },

    computed: {
        ...mapGetters({
            registerSuccess: 'isRegisterSuccessful',
            loading: 'isRegisterLoading',
            registerError: 'hasError',
            conflict: 'hasConflict'
        })
    },
    methods: {
        ...mapActions({
            sendRegisterRequest: 'sendRegisterRequest'
        }),

        startRegister() {
            this.errors = [];
            if (this.checkIsValid()) {
                this.register();
            }
        },

        register() {
            let body = {
                email: this.email,
                firstName: this.firstName,
                lastName: this.lastName,
                password: this.password,
                repeatPassword: this.repeatPassword
            }
            this.sendRegisterRequest(body);
        },

        checkIsValid() {
            if (this.checkIsFilledOut()){
                let passwordsMatching = this.checkPasswordMatch();

                if (passwordsMatching) {
                    this.checkPasswordStrength();
                }

                this.checkEmailValid();
            }

            if (!this.errors.length) {
                return true;
            } else {
                return false;
            }
        },

        /**
         * checks wether the given passwords are matching
         * @returns {boolean}
         */
        checkPasswordMatch() {
            if (this.password && this.repeatPassword) {
                let passwordsMatching = this.password == this.repeatPassword;

                if (!passwordsMatching) {
                    this.errors.push({ type: 'error', message: 'The given passwords are not matching!' });
                }

                return passwordsMatching;
            }
        },

        checkEmailValid() {
            if (this.email.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) == null) {
                this.errors.push({ type: 'email-invlalid', message:'Invalid email format!' })
                return false;
            } else {
                return true;
            }
        },
        /**
         * Checks if all form fields are filled out, meanwhile pushes error object into
         * the errors array.
         * return boolean
         */
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
                    this.errors.push({ type: 'weak-password', message:'Password is too short!' })
                }
            }

        }
    }
}