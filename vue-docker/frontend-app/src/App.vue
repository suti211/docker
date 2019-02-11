<template lang="pug">
    #app
        #head
            //button(@click="toggleMenu") test
        .menu(ref="menu", v-show="showMenu")
            ul
                li
                    router-link(to="/") Home
                li
                    router-link(to="/login") Login
        #content
            router-view
</template>

<script>
    export default {
        name: 'App',
        data: () => {
            return {
                showMenu: true
            }
        },
        methods: {
            toggleMenu() {
                if (this.showMenu) {
                    this.$refs.menu.style.opacity = 0;
                    setTimeout(() =>{this.showMenu = false;}, 500);
                } else {
                    this.showMenu = true;
                    this.$refs.menu.style.opacity = 0;
                    setTimeout(() =>{this.$refs.menu.style.opacity = 1;}, 500);
                }
            }
        }
    }
</script>

<style lang="less">

@import './assets/varibles.less';
@import './assets/fonts/icomoon/style.less';
#app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    display: grid;
    grid-template-columns: 1fr 11fr;
    grid-template-rows: 1fr 11fr;
    height: 100vh;
    background-color: var(--primary-color-background);
}

#head {
    display: inline;
    grid-row-start: 1;
    grid-row-end: 1;
    grid-column-start: 1;
    grid-column-end: 3;
    background-color: var(--primary-color-green);
}

.menu {
    display: inline;
    grid-row-start: 2;
    grid-row-end: 3;
    grid-column-start: 1;
    grid-column-end: 1;
    background-color: var(--primary-color-grey);
    transition: opacity 0.5s ease-in;
}

ul {
    padding: 0;
    margin: 0;

    li {
        list-style: none;
        height: 60px;
        line-height: 60px;
        transition: background-color 0.3s;
        font-size: 20px;


        a {
            color: white;
            text-decoration: none;
        }

        &:hover {
            background-color: var(--primary-color-hover);
        }
    }
}

#content {
    display: inline;
    grid-row-start: 2;
    grid-row-end: 3;
    grid-column-start: 2;
    grid-column-end: 3;
    background-color: var(--primary-color-background);
    padding: var(--global-component-padding);
}

</style>
