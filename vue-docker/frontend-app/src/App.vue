<template lang="pug">
    #app
        #head

        #menu
            ul
                li
                    router-link(to="/") Home
        #content
            router-view
</template>



<style lang="less">
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
}

#head {
    display: inline;
    grid-row-start: 1;
    grid-row-end: 1;
    grid-column-start: 1;
    grid-column-end: 3;
    background-color: #008D54;
}

#menu {
    display: inline;
    grid-row-start: 2;
    grid-row-end: 3;
    grid-column-start: 1;
    grid-column-end: 1;
    background-color: #545B58;
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
            background-color: #838A87;
        }
    }
}

#content {
    display: inline;
    grid-row-start: 2;
    grid-row-end: 3;
    grid-column-start: 2;
    grid-column-end: 3;
}

</style>
