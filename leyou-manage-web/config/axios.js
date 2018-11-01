///**
// * Created by admin on 2018/11/1.
// */
//import axios from 'axios'
//import config from '/src/config'
//// 配置默认的host,假如你的API host是：http://api.htmlx.club
//axios.defaults.baseURL = config.api
//// 添加请求拦截器
//axios.interceptors.request.use(function (config) {
//    // 在发送请求之前做些什么
//    //console.log("请求之前:config"+JSON.stringify(config))
//    config.headers['X-Token'] = "123455"
//    return config
//}, function (error) {
//    // 对请求错误做些什么
//    return Promise.reject(error)
//});
//// 添加响应拦截器
//axios.interceptors.response.use(function (response) {
//    // 对响应数据做点什么
//    //console.log("响应之前:"+JSON.stringify(response))
//    return response.data
//}, function (error) {
//    // 对响应错误做点什么
//    return Promise.reject(error)
//});