<template lang="pug">
    .login
        .login-panel
            p ...asdasdasd
</template>

<script src="./Login.js">

</script>

<style lang="less" scoped>
    .login {
        display: grid;
        grid-template-columns: 4fr 5fr 4fr;
        grid-template-rows: 4fr 5fr 4fr;
        height: 100%;
    }

    .login-panel {
        grid-column-start: 2;
        grid-column-end: 3;
        grid-row-start: 2;
        grid-row-end: 3;

        background-color: #545B58;
        border-radius: 5px;
        border: #959e83 solid 2px;

        -webkit-box-shadow: 0px 5px 19px 8px rgba(0,0,0,0.58);
        -moz-box-shadow: 0px 5px 19px 8px rgba(0,0,0,0.58);
        box-shadow: 0px 5px 19px 8px rgba(0,0,0,0.58);
    }
</style>