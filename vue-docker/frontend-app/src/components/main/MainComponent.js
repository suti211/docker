export default {
    name: "MainComponent",
    data: () => {
        return {
            page: 1
        }
    },

    methods: {
        testFunction() {
            this.page++;
        }
    }

}
