import { mapGetters, mapActions } from 'vuex';

export default {
    name: "Login",
    data: () => {
        return {
            email: '',
            password: '',
            loginError: false,
            errors: []
        }
    },
    computed: {
        ...mapGetters({
            loading: 'isLoginLoading'
        })
    },
    methods: {
        ...mapActions({
            login: 'sendLoginRequest'
        }),

        checkAndLogin() {
            if (this.checkForm()) {
                this.login({
                    email: this.email,
                    password: this.password
                });
            }
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