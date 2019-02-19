<template lang="pug">
    .login
        .login-panel
            .head
                h2 LOGIN
            .body
                .row
                    label(for="mail") Email:
                    span.icon.iconuser.sized
                    input.form-input(id="mail" type="text" maxlength="32")
                .row
                    label(for="pass") Password:
                    input.form-input(id="pass" type="password")
                .row
                    .button-container
                        button(@click="login") Login
                        button(@click="") Register
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

    .form-input {
        display: inline-block;
        height: var(--global-login-height);
        width: ~'calc(100% - 30px)';
        font-size: 1.5em;
        padding-left: 5px;
        padding-right: 5px;
    }

    .body {

        h4 {
            margin-bottom: 0;
            text-align: left;
        }

        padding: var(--global-component-padding);
        background-color: white;
    }

    .row {
        margin-top: 20px;
        margin-bottom: 20px;
        padding-left: var(--global-component-padding);
        padding-right: var(--global-component-padding);

        .button-container {
            padding-top: 10px;
            padding-bottom: 10px;
            display: inline;

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
        }

        label {
            text-align: left;
            display: block;
            font-weight: bold;
        }
    }

    .sized {
        height: var(--global-login-height);
        width: var(--global-login-height);
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