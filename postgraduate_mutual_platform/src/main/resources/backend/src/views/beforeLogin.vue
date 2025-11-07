<template>
  <div>
    <div class="container">
      <div class="loader"></div>
      <div class="message">正在登录，请稍等...</div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
    };
  },
  created() {
    let account = window.location.href.split("?")[1].split("=")[1];
    let table = window.location.href.split("&")[1].split("=")[1];
    if(account!=null&&table!=null){
      this.autoLogin(account,table)
    }
  },

  methods: {
    autoLogin(account,table) {
      this.$http({
        url: `${table}/autoLogin?account=${account}`,
        method: "post"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$storage.set("Token", data.token);
          if(table=='student'){
            this.$storage.set("role", '考生');
          }else if(table=='teacher'){
            this.$storage.set("role", '教师');
          }else{
            this.$storage.set("role", '管理员');
          }
          this.$storage.set("sessionTable", table);
          this.$storage.set("account", account);
          this.$http({
            url: `${this.$storage.get("sessionTable")}/session`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$storage.set("userId", data.data.id);
              this.$storage.set("userName", data.data.userName);
            }
          });
          this.$router.replace({ path: "/index/" });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
body {
  background-color: #f2f2f2;
  font-family: Arial, sans-serif;
}
.container {
  margin-top: 50px;
  text-align: center;
}
.loader {
  border: 16px solid #f3f3f3;
  border-top: 16px solid #3498db;
  border-radius: 50%;
  width: 120px;
  height: 120px;
  animation: spin 2s linear infinite;
  margin: 0 auto;
}
@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
.message {
  margin-top: 20px;
  font-size: 24px;
}
</style>
