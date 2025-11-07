<template>

	<div class="navbar" :style="{height:heads.headHeight,boxShadow:heads.headBoxShadow,lineHeight:heads.headHeight}">
		<div class="title-menu" :style="{justifyContent:heads.headTitleStyle=='1'?'flex-start':'center'}">
			<el-image v-if="heads.headTitleImg" class="title-img" :style="{width:heads.headTitleImgWidth,height:heads.headTitleImgHeight,boxShadow:heads.headTitleImgBoxShadow,borderRadius:heads.headTitleImgBorderRadius}" :src="heads.headTitleImgUrl" fit="cover"></el-image>
			<div class="title-name" :style="{color:heads.headFontColor,fontSize:heads.headFontSize}">{{this.$project.projectName}}</div>
		</div>
		<div class="right-menu">
      <div class="user-info" v-if="this.$storage.get('role')=='教师'" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">
        <svg class="icon" aria-hidden="true" style="width: 25px;height: 25px;">
          <use xlink:href="#icon-jiaoshitongji-01" ></use>
        </svg>{{this.$storage.get('role')}}</div>
      <div class="user-info" v-if="this.$storage.get('role')=='考生'" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">
        <svg class="icon" aria-hidden="true" style="width: 25px;height: 25px;">
          <use xlink:href="#icon-xuesheng" ></use>
        </svg>{{this.$storage.get('role')}}</div>
      <div class="user-info" v-if="this.$storage.get('role')=='管理员'" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">
        <svg class="icon" aria-hidden="true" style="width: 25px;height: 25px;">
          <use xlink:href="#icon-wangguan" ></use>
        </svg>{{this.$storage.get('role')}}</div>
      <img class="user-info" style="width: 55px;height: 55px;border-radius: 50%;" :src="this.user.avatar"></img>
      <div :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">{{this.$storage.get('userName')}}</div>


			<div class="logout" :style="{color:heads.headLogoutFontColor,fontSize:heads.headLogoutFontSize}" @click="onIndexTap">
          <div style="position: relative;display: inline-block;">
            <svg class="icon" aria-hidden="true" style="width: 25px;height: 25px;">
              <use xlink:href="#icon-shouye" ></use>
            </svg>
            <span style="font-size: 20px;">退出到前台</span>
          </div>

      </div>

			<div class="logout" :style="{color:heads.headLogoutFontColor,fontSize:heads.headLogoutFontSize}" @click="onLogout">
        <svg class="icon" aria-hidden="true" style="width: 25px;height: 25px;">
          <use xlink:href="#icon-web-icon-" ></use>
        </svg>
        <span style="font-size: 20px;">退出登录</span></div>
		</div>
	</div>
</template>

<script>

	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: {},
				heads: {"headLogoutFontHoverColor":"rgb(236,237,243)","headFontSize":"30px",
          "headUserInfoFontColor":"#fdfdfd","headBoxShadow":"0 1px 6px #444","headTitleImgHeight":"44px",
          "headLogoutFontHoverBgColor":"#2b88f5",
          "headFontColor":"#fcfafa","headTitleImg":false,"headHeight":"60px","headTitleImgBorderRadius":"22px","headTitleImgUrl":"http://codegen.caihongy.cn/20201021/cc7d45d9c8164b58b18351764eba9be1.jpg",
          "headBgColor":"#40baf8","headTitleImgBoxShadow":"0 1px 6px #444",
          "headLogoutFontColor":"#faf8f8","headUserInfoFontSize":"20px","headTitleImgWidth":"44px","headTitleStyle":"1","headLogoutFontSize":"16px"},

        color:'skyblue'
			};



		},
		created() {
			this.setHeaderStyle()
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.user = data.data;
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {

			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.remove("Token");
				storage.remove("role");
				storage.remove("userName");
				storage.remove("account");
				storage.remove("userId");
				storage.remove("Token");
				storage.remove("sessionTable");
				router.replace({
					name: "login"
				});
			},
      onIndexTap(){
          // this.onLogout();
        window.location.href = `${this.$base.indexUrl}`
      },
			setHeaderStyle() {
			  this.$nextTick(()=>{
			    document.querySelectorAll('.navbar .right-menu .logout').forEach(el=>{
			      el.addEventListener("mouseenter", e => {
			        e.stopPropagation()
			        el.style.backgroundColor = this.heads.headLogoutFontHoverBgColor
					el.style.color = this.heads.headLogoutFontHoverColor
			      })
			      el.addEventListener("mouseleave", e => {
			        e.stopPropagation()
			        el.style.backgroundColor = "transparent"
					el.style.color = this.heads.headLogoutFontColor
			      })
			    })
			  })
			},
		}
	};
</script>


<style lang="scss" scoped>
  .navbar{
    //background-image: linear-gradient(to top, #30cfd0 0%, #330867 100%);
    //background-image: linear-gradient(to top, #5ee7df 0%, #b490ca 100%);
    //background-image: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);
    //background-image: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);
    //background-image: linear-gradient(to top, #3f51b1 0%, #5a55ae 13%, #7b5fac 25%, #8f6aae 38%, #a86aa4 50%, #cc6b8e 62%, #f18271 75%, #f3a469 87%, #f7c978 100%);
    //background-image: linear-gradient(-225deg, #7085B6 0%, #87A7D9 50%, #DEF3F8 100%);
    //background-image: linear-gradient(-225deg, #77FFD2 0%, #6297DB 48%, #1EECFF 100%);
    //background-image: linear-gradient(to top, #00c6fb 0%, #005bea 100%);
    //background-image: linear-gradient(to right, #eea2a2 0%, #bbc1bf 19%, #57c6e1 42%, #b49fda 79%, #7ac5d8 100%);
    background-image: linear-gradient(to top, #48c6ef 0%, #6f86d6 100%);
  }





	.navbar {
		height: 60px;
		line-height: 60px;
		width: 100%;
		padding: 0 34px;
		box-sizing: border-box;
		background-color: #ffffff;
		position: relative;
		z-index: 111;
		
		.right-menu {
			position: absolute;
			right: 34px;
			top: 0;
			height: 100%;
			display: flex;
			justify-content: flex-end;
			align-items: center;
			z-index: 111;
			
			.user-info {
				font-size: 20px;
				color: red;
				padding: 0 12px;
			}
			
			.logout {
				font-size: 16px;
				color: red;
				padding: 0 12px;
				cursor: pointer;
			}
			
		}
		
		.title-menu {
			display: flex;
			justify-content: flex-start;
			align-items: center;
			width: 100%;
			height: 100%;
			
			.title-img {
				width: 44px;
				height: 44px;
				border-radius: 22px;
				box-shadow: 0 1px 6px #444;
				margin-right: 16px;
			}
			
			.title-name {
				font-size: 24px;
				color: #fff;
				font-weight: 700;
			}
		}
	}

</style>
