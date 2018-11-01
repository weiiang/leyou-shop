var menus = [
  {
    action: "home",
    title: "首页",
    path:"/index",
    items: [{ title: "统计", path: "/dashboard" }]
  },
  {
    action: "list",
    title: "WQ-商品管理",
    path:"/item",
    items: [
      { title: "WQ-分类管理", path: "/wq-category" },
      { title: "WQ-品牌管理", path: "/wq-brand" },
      { title: "WQ-商品列表", path: "/wq-list" },
      { title: "WQ-规格参数", path: "/wq-specification" }
    ]
  },

  {
    action: "list",
    title: "WQ-会员管理",
    path:"/user",
    items: [
      { title: "WQ-会员统计", path: "/count" },
      { title: "WQ-会员管理", path: "/manage" },
    ]
  },
  {
    action: "apps",
    title: "商品管理",
    path:"/item",
    items: [
      { title: "分类管理", path: "/category" },
      { title: "品牌管理", path: "/brand" },
      { title: "商品列表", path: "/list" },
      { title: "规格参数", path: "/specification" }
    ]
  },
  {
    action: "people",
    title: "会员管理",
    path:"/user",
    items: [
      { title: "会员统计", path: "/statistics" },
      { title: "会员管理", path: "/list" }
    ]
  },
  {
    action: "attach_money",
    title: "销售管理",
    path:"/trade",
    items: [
      { title: "交易统计", path: "/statistics" },
      { title: "订单管理", path: "/order" },
      { title: "物流管理", path: "/logistics" },
      { title: "促销管理", path: "/promotion" }
    ]
  },
  {
    action: "settings",
    title: "权限管理",
    path:"/authority",
    items: [
      { title: "权限管理", path: "/list" },
      { title: "角色管理", path: "/role" },
      { title: "人员管理", path: "/member" }
    ]
  }
]

export default menus;
