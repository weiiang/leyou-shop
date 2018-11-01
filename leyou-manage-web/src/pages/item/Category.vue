<template>
    <v-card>
        <v-card-title>
            <v-btn @click="addFirstCategory" color="primary">新增顶层分类</v-btn>
            <v-spacer/>
            <v-text-field
                    append-icon="search"
                    label="搜索"
                    single-line
                    hide-details
                    v-model="search"
            />
        </v-card-title>
        <v-flex xs12 sm10>
            <v-tree url="/item/category"
                    :treeData="treeData"
                    :isEdit="isEdit"
                    @handleAdd="handleAdd"
                    @handleEdit="handleEdit"
                    @handleDelete="handleDelete"
                    @handleClick="handleClick"
            />
        </v-flex>
        <v-dialog v-model="show" max-width="600" scrollable v-if="show">
            <v-card>
                <v-toolbar dark dense color="primary">
                    <v-toolbar-title>新增顶层分类</v-toolbar-title>
                    <v-spacer/>
                    <v-btn icon @click="show = false">
                        <v-icon>close</v-icon>
                    </v-btn>
                </v-toolbar>
                <v-card-text class="px-5 py-2">
                    <!-- 表单 -->
                    <category-form  :isEdit="isEdit" @close="show = false"/>
                </v-card-text>
            </v-card>
        </v-dialog>
    </v-card>
</template>

<script type="es6">
    import CategoryForm from './CategoryForm.vue'

    export default {
        name: "category",
        components: {
            CategoryForm
        },
        data() {
            return {
                search:"",
                isEdit: true,
                show:false,
                treeData: [],
                isEdit:true
            }
        },
        watch:{
            search:{
                handler(){
                    alert("搜索")
                },
            },
        },
        methods: {
            getDataFromApi(){},
            addFirstCategory(){
                    this.brand = {};
                    this.isEdit = false;
                    this.show = true;
            },
            handleAdd(node) {
                this.$http.post("/item/category",{
                    "isParent": node.isParent,
                    "name": node.name,
                    "parentId": node.parentId,
                    "sort": node.sort,
                }).then(res =>{
                    this.$message.info(res.msg);
                    location.reload();
                });
            },
            handleEdit(id, name) {
                this.$http.put("/item/category",{
                    id: id,
                    name: name,
                }).then(res =>{
                    console.log(res);
                })
            },
            handleDelete(id) {
                this.$http.delete("/item/category/"+id).then(res=>{this.$message.info(res.msg);});
            },
            handleClick(node) {
                this.$http.put("/item/category",{
                    id: node.id,
                    name: node.name,
                    parentId: node.parentId,
                    isParent: node.isParent,
                    sort: node.sort
                }).then(res =>{
                    this.$message.info(res.msg);
            })
            }
        }
    };
</script>

<style scoped>

</style>
