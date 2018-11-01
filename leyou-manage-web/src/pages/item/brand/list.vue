<template>
    <div>
        <v-card>
            <v-card-title>
                <v-btn @click="addFirstCategory" color="primary">新增品牌</v-btn>
                <v-spacer/>
                <v-text-field
                        append-icon="search"
                        label="搜索"
                        single-line
                        hide-details
                        v-model="search"
                />
            </v-card-title>
        </v-card>
        <v-data-table
                :headers="headers"
                :items="brands"
                :pagination.sync="pagination"
                :total-items="totalBrands"
                :loading="loading"
                class="elevation-1"
        >
            <template slot="items" slot-scope="props">
                <td class="text-xs-center">{{ props.item.id }}</td>
                <td class="text-xs-center">{{ props.item.name }}</td>
                <td class="text-xs-center"><img v-if="props.item.image" :src="props.item.image" width="130"
                                                height="40"/></td>
                <td class="text-xs-center">{{ props.item.letter }}</td>
            </template>
        </v-data-table>
    </div>
</template>

<script type="es6">
    export default {
        name: "myBrand",
        data () {
            return {
                totalBrands: 0, // 总条数
                brands: [], // 当前页品牌数据
                loading: true, // 是否在加载中
                pagination: {}, // 分页信息
                headers: [ // 头信息
                    {text: 'id', align: 'center', value: 'id'},
                    {text: '名称', align: 'center', value: 'name', sortable: false},
                    {text: 'LOGO', align: 'center', value: 'image', sortable: false},
                    {text: '首字母', align: 'center', value: 'letter'},
                ]
            }
        },
        methods: {
            getDataFromServer(){ // 从服务端加载数据的函数
                // 伪造演示数据
                const brands = [
                    {
                        "id": 2032,
                        "name": "OPPO",
                        "image": "http://img10.360buyimg.com/popshop/jfs/t2119/133/2264148064/4303/b8ab3755/56b2f385N8e4eb051.jpg",
                        "letter": "O",
                        "categories": null
                    },
                    {
                        "id": 2033,
                        "name": "飞利浦（PHILIPS）",
                        "image": "http://img12.360buyimg.com/popshop/jfs/t18361/122/1318410299/1870/36fe70c9/5ac43a4dNa44a0ce0.jpg",
                        "letter": "F",
                        "categories": null
                    },
                    {
                        "id": 2034,
                        "name": "华为（HUAWEI）",
                        "image": "http://img10.360buyimg.com/popshop/jfs/t5662/36/8888655583/7806/1c629c01/598033b4Nd6055897.jpg",
                        "letter": "H",
                        "categories": null
                    },
                    {
                        "id": 2036,
                        "name": "酷派（Coolpad）",
                        "image": "http://img10.360buyimg.com/popshop/jfs/t2521/347/883897149/3732/91c917ec/5670cf96Ncffa2ae6.jpg",
                        "letter": "K",
                        "categories": null
                    },
                    {
                        "id": 2037,
                        "name": "魅族（MEIZU）",
                        "image": "http://img13.360buyimg.com/popshop/jfs/t3511/131/31887105/4943/48f83fa9/57fdf4b8N6e95624d.jpg",
                        "letter": "M",
                        "categories": null
                    }
                ];
                // 延迟一段时间，模拟数据请求时间
                setTimeout(()=> {
                    this.brands = brands; // 赋值给品牌数组
                    this.totalBrands = brands.length; // 赋值数据总条数
                    this.loading = false; // 数据加载完成
                }, 1000);
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