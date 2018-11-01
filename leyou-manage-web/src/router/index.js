import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

function route (path, file, name, children) {
  return {
    exact: true,
    path,
    name,
    children,
    component: () => import('../pages' + file)
  }
}

export default new Router({
  routes: [
    route("/login",'/Login',"Login"),
    {
      path:"/",
      component: () => import('../pages/Layout'),
      redirect:"/index/dashboard",
      children:[
        route("/index/dashboard","/Dashboard","Dashboard"),
        route("/item/category",'/item/Category',"Category"),
        route("/item/brand",'/item/Brand',"Brand"),
        route("/item/list",'/item/Goods',"Goods"),
        route("/item/specification",'/item/Specification',"Specification"),
        route("/user/statistics",'/item/Statistics',"Statistics"),
        route("/trade/promotion",'/trade/Promotion',"Promotion"),

        //自定义  菜单路径=>页面路径
        route("/item/wq-category",'/item/category/list',"category"),
        route("/item/wq-brand",'/item/brand/list',"brand"),
        route("/item/wq-list",'/item/goods/list',"goods"),
        route("/item/wq-specification",'/item/specification/list',"specification"),

        route("/user/manage",'/user/list',"userManage"),
        route("/user/count",'/user/count',"userCount"),
      ]
    }
  ]
})
