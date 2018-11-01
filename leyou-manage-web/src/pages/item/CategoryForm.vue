<template>
  <v-form v-model="valid" ref="categoryForm">
    <v-text-field
      label="分类名称"
      v-model="category.name"
      :rules="[v => !!v || '分类名称不能为空']"
      :counter="10"
      required
    />
    <v-layout class="my-4">
      <v-btn @click="submit" color="primary">提交</v-btn>
      <v-btn @click="clear" color="warning">重置</v-btn>
    </v-layout>
  </v-form>
</template>

<script type="es6">
  import config from '@/config';
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
      }
    },
    data() {
      return {
        valid:false,
        category: {
          name: "",
          isParent: false,
          parentId: 0,
          sort: 0,
        },
      }
    },

    methods: {
      submit() {
        // 表单校验
        if (this.$refs.categoryForm.validate()) {
          // 将数据提交到后台
          this.$http({
            method: 'post',
            url: '/item/category',
            data: this.category
          }).then(() => {
            // 关闭窗口
            this.$message.success("保存成功！");
            this.closeWindow();
          }).catch(() => {
            this.$message.error("保存失败！");
          });
        }
      },
      clear() {
        // 重置表单
        this.$refs.categoryForm.reset();
      },

      closeWindow(){
        this.$emit("close");
      }
    }
  }
</script>

<style scoped>

</style>
