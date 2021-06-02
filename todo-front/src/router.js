import Vue from "vue";
import VueRouter from "vue-router";
import Home from "./views/Home";
import CompleteRate from "./views/CompleteRate";

Vue.use(VueRouter);

const router = new VueRouter({ // eslint-disable-line no-unused-vars
    mode: "history",
    routes: [
        { path: "/", component: Home },
        { path: "/completeRate", component: CompleteRate },
    ]
});

export default router;