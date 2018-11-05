<template>
    <v-form v-model="valid" ref="brandEdit">
        <v-text-field v-model="brand.name" label="请输入品牌名称" :rules="nameRules" required/>
        <v-text-field v-model="brand.letter" label="请输入品牌首字母" :rules="letterRules" required/>
        <v-cascader url="/item/category" multiple required v-model="brand.categories" label="请选择商品分类"/>
        <v-layout row>
            <v-flex xs3>
                <span style="font-size: 16px; color: #444">品牌LOGO：</span>
            </v-flex>
            <v-flex>
                <v-upload v-model="brand.image" url="/upload" :multiple="false" :pic-width="250" :pic-height="90"/>
            </v-flex>
        </v-layout>
        <v-layout class="my-4" row>
            <v-spacer/>
            <v-btn @click="submit" color="primary">提交</v-btn>
            <v-btn @click="clear">重置</v-btn>
        </v-layout>
    </v-form>
</template>

<script type="es6">
    export default {
        name: "brand-form",
        props: {
            oldBrand: Object,
            isEdit: {
                type: Boolean,
                default: false
            },
            show: {
                type: Boolean,
                default: true
            },
        },
        data(){
            return {
                nameRules: [
                    v => !!v || "品牌名称不能为空",
                    v => v.length > 1 || "品牌名称至少2位"
                ],
                letterRules: [
                    v => !!v || "首字母不能为空",
                    v => /^[A-Z]{1}$/.test(v) || "品牌字母只能是A~Z的大写字母"
                ],

                valid: false, // 表单校验结果标记
                brand: {
                    name: '', // 品牌名称
                    letter: '', // 品牌首字母
                    image: '',// 品牌logo
                    categories: [], // 品牌所属的商品分类数组
                }
            }
        },
        methods: {
            submit(){
                //通过表单校验
                if (this.$refs.brandEdit.validate()) {
                    //用解构表达式提取属性
                    const {letter,categories, ...params} = this.brand;
                    params.letter = letter.toUpperCase();
                    params.cids = categories.map(e => e.id).join(",");
                    this.$http.post("/item/brand", this.$qs.stringify(params)).then(res => {
                        this.closeWindow();
                        this.$message.success("保存成功!")
                    }).catch(err => {
                        this.closeWindow();
                        this.$message.success("保存失败!")
                    })

                }
            },
            clear(){
                this.$refs.brandEdit.reset();
                this.brand.categories = [];
            },
            closeWindow(){
                this.$emit("close");
            }
        },
        watch: {
            oldBrand: {
                deep: true,
                handler(val){
                    //Object.deepCopy(val, this.brand);
                    this.brand.name = this.oldBrand.name;
                    this.brand.letter = this.oldBrand.letter;
                    this.brand.image = this.oldBrand.image;
                    this.brand.categories = this.oldBrand.categories;
                    this.brand.id = this.oldBrand.id;
                    console.log("brand:" + JSON.stringify(this.brand))
                }
            }
        },
        mounted(){
        }
    }


</script>
