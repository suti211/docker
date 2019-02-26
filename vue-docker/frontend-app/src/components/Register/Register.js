import axios from 'axios';
export default {
    name: 'Register',
    data: () => {
        return {
            firstName: '',
            lastName: '',
            password: '',
            retypePassword: '',
            email: ''
        }
    },
    methods: {
        register() {
            let body = {
                firstName: this.firstName,
                lastName: this.lastName,
                password: this.password,
                retypePassword: this.retypePassword
            }
            axios.post("/api/user/register", body)
        }
    }
}