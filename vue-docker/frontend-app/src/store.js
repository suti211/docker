import Vue from 'vue';
import Vuex from 'vuex';
import RegisterService from './api/service/RegisterService';

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        register: {
            loginSuccess: false,
            registerSuccess: false,
            loading: false,
            error: false
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
    },
    // async
    actions: {
        sendRegisterRequest: (context, registerBody) => {
            context.commit('CHANGE_REGISTER_LOADING', true);
            RegisterService.postRegisterRequest(registerBody)
                .then(response => {
                    console.log(response);
                    if (response){
                        context.commit('CHANGE_REGISTER_SUCCESS', true);
                    }
                })
                .catch( () => {
                    context.commit('CHANGE_REGISTER_SUCCESS', false);
                    context.commit('CHANGE_REGISTER_ERROR', true);
                })
                .finally( () => {
                    context.commit('CHANGE_REGISTER_LOADING', false);
                });
        }
    },
    getters: {
        isRegisterSuccessful: (state) => {
            return state.register.registerSuccess;
        },

        isLoading: (state) => {
            return state.register.loading;
        },

        hasError: (state) => {
            return state.register.error;
        }
    }
})
