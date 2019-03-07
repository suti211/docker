import Vue from 'vue';
import Vuex from 'vuex';
import RegisterService from './api/service/RegisterService';

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        register: {
            loginSuccess: false,
            registerSuccess: false,
            loading: false
        }
    },
    // sync
    mutations: {
        CHANGE_REGISTER_STATE: (state, status) => {
            state.register.registerSuccess = status;
        },
        CHANGE_REGISTER_LOADING: (state, loading) => {
            state.register.loading = loading;
        }
    },
    // async
    actions: {
        sendRegisterRequest: (context, registerBody) => {
            context.commit('CHANGE_REGISTER_LOADING', true);
            RegisterService.postRegisterRequest(registerBody)
                .then(response => {
                    if (response){
                        context.commit('CHANGE_REGISTER_STATE', true);
                    }
                })
                .catch( () => {
                    context.commit('CHANGE_REGISTER_STATE', false);
                })
                .finally( () => {
                    context.commit('CHANGE_REGISTER_LOADING', false)
                })
        }
    },
    getters: {
        isRegisterSuccessful: (state) => {
            return state.register.registerSuccess;
        },

        isLoading: (state) => {
            return state.register.loading;
        }
    }
})
