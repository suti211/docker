import Vue from 'vue';
import Vuex from 'vuex';
import RegisterService from './api/service/RegisterService';
import LoginService from './api/service/LoginService';

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        main: {
            showMenu: false
        },
        register: {
            registerSuccess: false,
            loading: false,
            error: false,
            conflict: false
        },

        login: {
            loading: false,
            loginSuccess: false,
        }
    },
    // sync
    mutations: {
        CHANGE_REGISTER_SUCCESS: (state, success) => {
            state.register.registerSuccess = success;
        },
        CHANGE_REGISTER_LOADING: (state, isLoading) => {
            state.register.loading = isLoading;
        },
        CHANGE_REGISTER_ERROR: (state, error) => {
            state.register.error = error;
        },
        CHANGE_REGISTER_CONFLICT: (state, conflict) => {
            state.register.conflict = conflict;
        },
        CHANGE_LOGIN_LOADING: (state, loading) => {
            state.login.loading = loading;
        },
        CHANGE_MAIN_SHOWMENU: (state, show) => {
            state.main.showMenu = show;
        }
    },
    // async
    actions: {
        sendRegisterRequest: (context, registerBody) => {
            context.commit('CHANGE_REGISTER_LOADING', true);
            RegisterService.postRegisterRequest(registerBody)
                .then(response => {
                    console.log(response);
                    if (response.status == 201) {
                        context.commit('CHANGE_REGISTER_SUCCESS', true);
                        context.commit('CHANGE_REGISTER_ERROR', false);
                        context.commit('CHANGE_REGISTER_CONFLICT', false)
                    }

                })
                .catch( (error) => {
                    if (error.status == 409){
                        context.commit('CHANGE_REGISTER_CONFLICT', true)
                    }
                    context.commit('CHANGE_REGISTER_SUCCESS', false);
                    context.commit('CHANGE_REGISTER_ERROR', true);
                })
                .finally( () => {
                    context.commit('CHANGE_REGISTER_LOADING', false);
                });
        },

        sendLoginRequest: (context, credentials) => {
            context.commit('CHANGE_LOGIN_LOADING', true);
            LoginService.login(credentials)
                .then( (response) => {
                    if (response.status == 200) {
                        console.log("siker")
                    }
                })
                .catch( (error) => {
                    console.log("fail")
                    console.log(error);
                })
                .finally( () => {
                    context.commit('CHANGE_LOGIN_LOADING', false);
                })
        },
    },
    getters: {
        showSideMenu: (state) => {
            return state.main.showMenu;
        },
        isRegisterSuccessful: (state) => {
            return state.register.registerSuccess;
        },
        isRegisterLoading: (state) => {
            return state.register.loading;
        },
        hasError: (state) => {
            return state.register.error;
        },
        hasConflict: (state) => {
            return state.register.conflict;
        },
        isLoginSuccessful: (state) => {
            return state.login.loginSuccess;
        },
        isLoginLoading: (state) => {
            return state.login.loading;
        }
    }
})
