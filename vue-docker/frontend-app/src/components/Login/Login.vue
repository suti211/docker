<template lang="pug">
    .login
        .login-panel
            .head
                h2 LOGIN
            .body
                form#login(novalidate)
                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconuser
                        input#email-input.form-control(type="email" placeholder="Email" v-model="username" no-validate)
                    .validation-block(v-if="errors.includes('username')")
                        span Required!
                    .input-group.mb-3
                        .input-group-prepend
                            span.input-group-text.icon.iconkey
                        input#password-input.form-control(type="password" placeholder="Password" v-model="password")
                    .validation-block(v-if="errors.includes('password')")
                        span Required!
                    .input-group.mb-3.text-center
                        .center
                            button.btn.btn-primary(@click="checkAndLogin") Login
                            button.btn.btn-primary(@click="") Register
</template>

<script src="./Login.js">

</script>

<style lang="less" scoped>
    .login {
        height: 100%;
        position: relative;
    }

    .login-panel {
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

    button {
        padding-left: 10px;
        padding-right: 10px;
        margin-left: 20px;
        margin-right: 20px;
        background-color: var(--primary-color-green);
        font-weight: bold;
        height: 40px;
        color: white;
        width: 100px;
        font-size: large;

        &:hover {
            background-color: var(--primary-color-hover);
        }
    }

    .center {
        margin: 0 auto;
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
</style>