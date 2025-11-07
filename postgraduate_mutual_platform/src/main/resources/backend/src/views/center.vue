<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
       <el-col :span="12">
        <el-form-item  label="账号" prop="account">
          <el-input v-model="ruleForm.account"
              placeholder="账号" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="12">
        <el-form-item  label="密码" prop="password">
          <el-input v-model="ruleForm.password"
              placeholder="密码" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="12">
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="ruleForm.userName"
              placeholder="用户名" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="12">
        <el-form-item  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in xueshenggenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
       <el-col :span="24">
        <el-form-item label="头像" prop="avatar">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.avatar?ruleForm.avatar:''"
          @change="xueshengavatarUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
       <el-col :span="12">
        <el-form-item  v-if="flag=='student'"  label="专业" prop="major">
          <el-input v-model="ruleForm.major"
              placeholder="专业" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="12">
        <el-form-item  v-if="flag=='teacher'"  label="职位" prop="position">
          <el-input v-model="ruleForm.position"
              placeholder="专业" clearable></el-input>
        </el-form-item>
      </el-col>

       <el-col :span="12">
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="ruleForm.phone"
              placeholder="手机号" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="12">
        <el-form-item  label="邮箱" prop="email">
          <el-input v-model="ruleForm.email"
              placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
       <el-col :span="12">
         <el-form-item  label="余额" prop="money">
           <el-input v-model="ruleForm.money"
                     placeholder="余额" disabled ></el-input>
         </el-form-item>
       </el-col>

      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      xueshenggenderOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.xueshenggenderOptions = "男,女".split(',')
  },
  methods: {
    xueshengavatarUploadChange(fileUrls) {
        this.ruleForm.avatar = fileUrls;
    },
    onUpdateHandler() {
      if(!this.ruleForm.account){
        this.$message.error('账号不能为空');
        return
      }
      if(!this.ruleForm.password){
        this.$message.error('密码不能为空');
        return
      }
      if(!this.ruleForm.userName){
        this.$message.error('用户名不能为空');
        return
      }
      if(this.ruleForm.email&&(!isEmail(this.ruleForm.email))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
      // if( 'xuesheng' ==this.flag && this.ruleForm.money&&(!isNumber(this.ruleForm.money))){
      //   this.$message.error(`余额应输入数字`);
      //   return
      // }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
