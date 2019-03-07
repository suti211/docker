<template lang="pug">
    .register
        .register-panel
            .head
                h2 Register
            .body
                .body
                form#login(novalidate)
                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconuser
                        input.form-control(type="text" placeholder="First name" v-model="firstName" no-validate maxlength="32")

                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconuser
                        input.form-control(type="text" placeholder="Last name" v-model="lastName" no-validate maxlength="32")

                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconmail4
                        input.form-control(type="text" placeholder="Email address" v-model="email" no-validate maxlength="32")

                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconkey
                        input.form-control(type="text" placeholder="Password" v-model="password" no-validate maxlength="32")

                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconkey
                        input.form-control(type="text" placeholder="Repeat password" v-model="repeatPassword" no-validate maxlength="32")

                    .alert-danger(v-for="error in errors") {{ error.message }}

                    .alert-danger(v-if="registerError")
                        span Error happened during register!

                    .input-group.mb-3
                        .center
                            button.btn.btn-primary.large(@click="startRegister" v-bind:disabled="loading") Register&nbsp
                                span.spinner-border.spinner-border-sm(v-show="loading")


</template>

<script src="./Register.js">
</script>

<style lang="less" scoped>
    .register {
        height: 100%;
        position: relative;
    }

    .register-panel {
        position: absolute;
        width: 600px;
        top: 50%;
        left: 50%;
        transform: translate(-50% , -50%);
        border-radius: 5px;
        border: #959e83 solid 2px;

        -webkit-box-shadow: 0px 5px 19px 8px rgba(0,0,0,0.58);
        -moz-box-shadow: 0px 5px 19px 8px rgba(0,0,0,0.58);
        box-shadow: 0px 5px 19px 8px rgba(0,0,0,0.58);
    }

    .body {

        h4 {
            margin-bottom: 0;
            text-align: left;
        }

        padding: var(--global-component-padding);
        background-color: white;
    }

    .head {
        background-color: var(--primary-color-green);
        h2 {
            margin: 0;
            padding-top: 20px;
            padding-bottom: 20px;
            color: white;
        }
    }

    button.btn.btn-primary.large {
        margin-top: 30px;
    }

    .alert-danger {
        padding: 5px 10px;
    }

</style>