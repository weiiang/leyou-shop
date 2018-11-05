<template>
    <div>
        <v-card>
            <v-card-title>
                <v-btn @click="addBrand" color="primary">新增品牌</v-btn>
                <v-spacer/>
                <v-text-field append-icon="search" label="搜索" single-line hide-details v-model="search"/>
            </v-card-title>
        </v-card>
        <v-data-table :headers="headers" :items="brands" :pagination.sync="pagination" :total-items="totalBrands"
                      :loading="loading" class="elevation-1">
            <template slot="items" slot-scope="props">
                <td class="text-xs-center">{{ props.item.id }}</td>
                <td class="text-xs-center">{{ props.item.name }}</td>
                <td class="text-xs-center"><img v-if="props.item.image" :src="props.item.image" width="130"
                                                height="40"/></td>
                <td class="text-xs-center">{{ props.item.letter }}</td>
                <td class="justify-center layout px-0">
                    <v-btn icon @click="editBrand(props.item)"><i class="el-icon-edit"/></v-btn>
                    <v-btn icon @click="deleteBrand(props.item)"><i class="el-icon-delete"/></v-btn>
                </td>
            </template>
        </v-data-table>
        <v-layout>
            <!--弹出的对话框-->
            <v-dialog max-width="500" v-model="show" persistent>
                <v-card>
                    <!--对话框的标题-->
                    <v-toolbar dense dark color="primary">
                        <v-toolbar-title>{{isEdit ? "编辑品牌" : "新增品牌"}}</v-toolbar-title>
                        <v-spacer/>
                        <!--关闭窗口的按钮-->
                        <v-btn icon @click="closeWindow">
                            <v-icon>close</v-icon>
                        </v-btn>
                    </v-toolbar>
                    <!--对话框的内容，表单-->
                    <v-card-text class="px-5">
                        <brand-form :oldBrand="brand" :isEdit="isEdit" @close="closeWindow"></brand-form>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-layout>
    </div>
</template>

<script type="es6">

    import BrandForm from './edit.vue'

    export default {
        components: {
            BrandForm
        },
        name: "myBrand",
        data () {
            return {
                brand: {
                    name: '', // 品牌名称
                    letter: '', // 品牌首字母
                    image: '',// 品牌logo
                    categories: [], // 品牌所属的商品分类数组
                },
                isEdit: false,//false:新增品牌  true:编辑品牌
                show: false,
                totalBrands: 0, // 总条数
                brands: [], // 当前页品牌数据
                loading: true, // 是否在加载中
                pagination: {}, // 分页信息
                search: "", //搜索关键字
                headers: [ // 头信息
                    {text: 'id', align: 'center', value: 'id'},
                    {text: '名称', align: 'center', value: 'name', sortable: false},
                    {text: 'LOGO', align: 'center', value: 'image', sortable: false},
                    {text: '首字母', align: 'center', value: 'letter'},
                    {text: '操作', align: 'center', value: 'id', sortable: false}
                ]
            }
        },
        methods: {
            //编辑品牌
            editBrand(item){
                this.$http.get("/item/category/" + item.id).then(res => {
                    this.isEdit = true;
                    this.brand = item;
                    let data = res.data;
                    let t = [];
                    data.forEach(e => {
                        let f = {};
                        f.name = e.name;
                        f.id = e.id;
                        t.push(f);
                    })
                    this.brand.categories = t;
                    this.show = true;
                }).catch(err => {
                    this.$message.error(err)
                });
            },
            //删除方法
            deleteBrand(item){
                this.$message.confirm("此操作将永久删除数据,是否继续?", {
                    confirmButtonText: '确定删除',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$http.delete("/item/brand/" + item.id).then(res => {
                        this.$message.success("删除成功!");
                        this.getDataFromServer();
                    }).catch(err => {
                        this.$message.fail("删除失败!");
                    })
                }).catch(() => {
                    this.$message.info("已取消删除!");
                });
            },
            //新增方法
            addBrand(){
                this.brand = {};
                this.isEdit = false;
                this.show = true;
            },
            closeWindow(){
                this.show = false;
                this.getDataFromServer();
            },
            //加载分页列表
            getDataFromServer(){ // 从服务端加载数据的函数
                this.loading = true;
                this.$http.get("/item/brand/page", {
                    params: {
                        rows: this.pagination.rowsPerPage,
                        page: this.pagination.page,
                        sortBy: this.pagination.sortBy,
                        desc: this.pagination.descending,
                        key: this.search
                    }
                }).then(res=> {
                    this.brands = res.data.records;
                    this.totalBrands = res.data.total;
                    this.loading = false;
                }).catch(err => {
                    this.loading = false;
                    this.$Message.error(err);
                });
            }
        },
        watch: {
            pagination: {
                deep: true,
                handler(){
                    this.getDataFromServer();
                },
            },

            search: {
                handler(){
                    this.getDataFromServer();
                }
            }
        },
        // 渲染后执行
        mounted(){
            this.getDataFromServer() // 调用数据初始化函数
        }
    }
</script>

<!-- scoped:当前样式只作用于当前组件的节点 -->
<style scoped>

</style>
